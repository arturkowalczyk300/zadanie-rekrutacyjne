package com.arturkowalczyk300.zadanierekrutacyjne.Model.Web

import retrofit2.Call
import retrofit2.http.GET

interface GithubApi {
    @GET("/users")
    fun getUsers(): Call<List<GithubUser>>
}