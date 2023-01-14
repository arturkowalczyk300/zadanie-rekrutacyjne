package com.arturkowalczyk300.zadanierekrutacyjne.Model.Web

import com.google.gson.annotations.SerializedName
    data class DailymotionUser(
        val id: String,
        @SerializedName("screenname")
        val screenName: String
    )