package com.elfak.museumapp.museum_item_details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.elfak.museumapp.R
import com.elfak.museumapp.model.MuseumData
import com.elfak.museumapp.model.MuseumItem
import kotlinx.android.synthetic.main.activity_details.*
import java.lang.RuntimeException

class DetailsActivity : AppCompatActivity() {

    companion object {
        private const val QR_CODE_CONTENT_KEY = "QR_CODE_CONTENT_KEY"

        fun startActivity(context: Context, qrCodeContent: String) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(QR_CODE_CONTENT_KEY, qrCodeContent)
            context.startActivity(intent)
        }
    }

    private var museumItemKey: String = ""
    private var museumItem: MuseumItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        museumItemKey =
            if (savedInstanceState != null && savedInstanceState.containsKey(QR_CODE_CONTENT_KEY)) {
                savedInstanceState.getString(QR_CODE_CONTENT_KEY, "")
            } else if (intent != null && intent.hasExtra(QR_CODE_CONTENT_KEY)) {
                intent.getStringExtra(QR_CODE_CONTENT_KEY)
            } else {
                throw RuntimeException("Invalid data passed")
            }

        if (museumItemKey.isNullOrEmpty()) {
            invalidData()
            return
        }

        museumItem = MuseumData.data[museumItemKey]
        if (museumItem == null) {
            invalidData()
            return
        }

        imagePager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                imageIndicator.text = "${position + 1} / ${museumItem?.images?.size ?: 0}"
            }
        })

        displayData()
    }

    private fun displayData() {
        museumItem?.let {
            imageIndicator.text = "${1} / ${it.images.size}"
            titleText.text = it.title
            descriptionText.text = it.description
            imagePager.adapter = MuseumItemImagesAdapter(it.images)
        }
    }


    private fun invalidData() {
        Toast.makeText(this, "Invalid data", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(QR_CODE_CONTENT_KEY, museumItemKey)
    }
}
