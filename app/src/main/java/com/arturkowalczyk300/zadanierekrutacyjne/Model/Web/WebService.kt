package com.arturkowalczyk300.zadanierekrutacyjne.Model.Web

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebService {
    private val mldGithubUsers = MutableLiveData<List<GithubUser>>()
    private val mldDailymotionUsers = MutableLiveData<DailymotionUsersList>()

    fun getGithubUsers(): LiveData<List<GithubUser>> {
        RetrofitClients.getGithubApiHandle().getUsers()
            .enqueue(object : Callback<List<GithubUser>> {
                override fun onResponse(
                    call: Call<List<GithubUser>>,
                    response: Response<List<GithubUser>>
                ) {
                    response.body().let {
                        mldGithubUsers.value = it
                    }
                }

                override fun onFailure(call: Call<List<GithubUser>>, t: Throwable) {
                    Log.e("", "getGithubUsers, onFailure")
                }
            })

        return mldGithubUsers
    }

    fun getDailymotionUsers(): LiveData<DailymotionUsersList> {
        RetrofitClients.getDailymotionApiHandle().getUsers()
            .enqueue(object : Callback<DailymotionUsersList> {
                override fun onResponse(
                    call: Call<DailymotionUsersList>,
                    response: Response<DailymotionUsersList>
                ) {
                    response.body().let {
                        mldDailymotionUsers.value = it
                    }
                }

                override fun onFailure(call: Call<DailymotionUsersList>, t: Throwable) {
                    Log.e("", "getDailymotionUsers, onFailure")
                }
            })

        return mldDailymotionUsers
    }
}