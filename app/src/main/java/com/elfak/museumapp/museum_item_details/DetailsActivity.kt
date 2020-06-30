package com.elfak.museumapp.museum_item_details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.elfak.museumapp.R
import com.elfak.museumapp.model.AsyncTaskState
import com.elfak.museumapp.model.MuseumModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*


@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    private var data: MuseumModel? = null
    private val onPageChangeCallback: ViewPager2.OnPageChangeCallback = object :
        ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)

            imageIndicator.text =
                "${position + 1} / ${data?.imageUrl?.size}"
        }
    }
    private val viewModel: DetailsActivityViewModel by viewModels()

    companion object {
        const val QR_CODE_CONTENT_KEY = "QR_CODE_CONTENT_KEY"

        fun startActivity(context: Context, qrCodeContent: String) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(QR_CODE_CONTENT_KEY, qrCodeContent)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        imagePager.registerOnPageChangeCallback(onPageChangeCallback)

        viewModel.mainDataState.observe(this, { state ->
            when (state) {
                is AsyncTaskState.LoadingState -> {
                    progress.visibility = View.VISIBLE
                    errorHolder.visibility = View.GONE
                    mainContent.visibility = View.GONE
                }

                is AsyncTaskState.SuccessState<*> -> {
                    data = state.data as MuseumModel
                    progress.visibility = View.GONE
                    errorHolder.visibility = View.GONE
                    mainContent.visibility = View.VISIBLE

                    displayData(data!!)
                }

                is AsyncTaskState.ErrorState -> {
                    errorHolder.visibility = View.VISIBLE
                    errorText.text = state.error.localizedMessage

                    progress.visibility = View.GONE
                    mainContent.visibility = View.GONE
                }
            }
        })

        errorHolder.setOnClickListener {
            viewModel.onErrorRetryClicked()
        }

        viewModel.onCreate()
    }

    private fun displayData(data: MuseumModel) {
        imageIndicator.text = "${1} / ${data.imageUrl.size}"
        titleText.text = " ${data.artistName} ${data.itemName}"
        descriptionText.text = data.description
        imagePager.adapter = MuseumItemImagesAdapter(data.imageUrl)
    }
}
