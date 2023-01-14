package com.arturkowalczyk300.zadanierekrutacyjne.Model.Web

import retrofit2.Call
import retrofit2.http.GET

interface DailymotionApi {
    @GET("/users")
    fun getUsers(): Call<DailymotionUsersList>
}