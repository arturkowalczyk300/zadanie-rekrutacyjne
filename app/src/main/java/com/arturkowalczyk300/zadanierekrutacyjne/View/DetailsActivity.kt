package com.arturkowalczyk300.zadanierekrutacyjne.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.arturkowalczyk300.zadanierekrutacyjne.Model.EnumApiSource
import com.arturkowalczyk300.zadanierekrutacyjne.R
import com.squareup.picasso.Picasso

const val EXTRA_USER_NAME = "com.arturkowalczyk300.zadanierekrutacyjne.EXTRA_USER_NAME"
const val EXTRA_USER_API_SOURCE = "com.arturkowalczyk300.zadanierekrutacyjne.EXTRA_USER_API_SOURCE"
const val EXTRA_USER_IMAGE_URL = "com.arturkowalczyk300.zadanierekrutacyjne.EXTRA_USER_IMAGE_URL"

class DetailsActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvSourceApi: TextView
    private lateinit var ivAvatar: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        tvName = findViewById(R.id.details_UserTextName)
        tvSourceApi = findViewById(R.id.details_UserTextSourceApi)
        ivAvatar = findViewById(R.id.details_UserImageAvatar)

        intent.extras.let {
            val name = it!!.getString(EXTRA_USER_NAME)
            val source = EnumApiSource.valueOf(it!!.getString(EXTRA_USER_API_SOURCE)!!)
            val avatarUrl = it!!.getString(EXTRA_USER_IMAGE_URL)

            tvName.text = getString(R.string.user_name, name)
            val apiSourceText = when (source) {
                EnumApiSource.API_DAILYMOTION -> getString(R.string.api_dailymotion)
                else -> getString(R.string.api_github)
            }
            tvSourceApi.text = getString(R.string.user_api_source, apiSourceText)
            if (avatarUrl != null) {
                Picasso.get().load(avatarUrl).into(ivAvatar)
            } else
                ivAvatar.setImageResource(R.drawable.default_photo)
        }
    }

}