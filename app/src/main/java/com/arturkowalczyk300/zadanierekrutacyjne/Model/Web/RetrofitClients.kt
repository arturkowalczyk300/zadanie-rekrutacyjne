package com.arturkowalczyk300.zadanierekrutacyjne.Model.Web

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClients {
    companion object {
        private const val DAILYMOTION_URL = "https://api.dailymotion.com"
        private const val GITHUB_URL = "https://api.github.com"

        private var retrofitClientDailymotion: Retrofit? = null
        private var retrofitClientGithub: Retrofit? = null

        private fun createDailymotionClientInstance() {
            retrofitClientDailymotion = retrofitClientDailymotion ?: Retrofit.Builder()
                .baseUrl(DAILYMOTION_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        private fun createGithubClientInstance() {
            retrofitClientGithub = retrofitClientGithub ?: Retrofit.Builder()
                .baseUrl(GITHUB_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getDailymotionApiHandle(): DailymotionApi {
            retrofitClientDailymotion ?: createDailymotionClientInstance()
            return retrofitClientDailymotion!!.create(DailymotionApi::class.java)
        }

        fun getGithubApiHandle(): GithubApi {
            retrofitClientGithub ?: createGithubClientInstance()
            return retrofitClientGithub!!.create(GithubApi::class.java)
        }
    }
}