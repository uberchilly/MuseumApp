package com.elfak.museumapp.museum_item_details

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.elfak.museumapp.model.AsyncTaskState
import com.elfak.museumapp.network.ApiInterface
import kotlinx.coroutines.launch

class DetailsActivityViewModel @ViewModelInject constructor(
    private val apiInterface: ApiInterface,
    @Assisted val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _mainDataState = MutableLiveData<AsyncTaskState>()
    val mainDataState: LiveData<AsyncTaskState>
        get() = _mainDataState

    private fun loadData() {
        val scannedKey: String =
            savedStateHandle.get(DetailsActivity.QR_CODE_CONTENT_KEY) ?: ""
        _mainDataState.value = AsyncTaskState.LoadingState
        viewModelScope.launch {
            try {
                val data = apiInterface.getDataFromQrCodeKey(scannedKey)
                _mainDataState.value = AsyncTaskState.SuccessState(data)
            } catch (e: Exception) {
                _mainDataState.value = AsyncTaskState.ErrorState(e)
            }
        }
    }

    fun onCreate() {
        loadData()
    }

    fun onErrorRetryClicked() {
        loadData()
    }

}