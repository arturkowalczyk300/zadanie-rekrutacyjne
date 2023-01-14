package com.arturkowalczyk300.zadanierekrutacyjne.Model

import android.content.Context
import androidx.lifecycle.LiveData
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Local.ConverterToDatabaseUser
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Local.User
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Local.UsersDatabase
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Web.GithubUser
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Web.WebService
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    private val webService = WebService()
    private var database: UsersDatabase? = null //needs to be initialized with context

    fun initializeDatabase(context: Context) {
        database = UsersDatabase.getInstance(context)
    }

    fun updateGithubUsers() {
        if (!webService.getGithubUsers().hasActiveObservers())
            webService.getGithubUsers().observeForever { list ->
                runBlocking {
                    list.forEach { user ->
                        database?.getDao()?.addUser(ConverterToDatabaseUser.convertGithubUser(user))
                    }
                }
            }
    }

    fun updateDailymotionUsers() {
        if (!webService.getDailymotionUsers().hasActiveObservers())
            webService.getDailymotionUsers().observeForever { users ->
                runBlocking {
                    users.list.forEach { it ->
                        database?.getDao()
                            ?.addUser(ConverterToDatabaseUser.convertDailymotionUser(it))
                    }
                }
            }
    }

    fun getAllUsers(): LiveData<List<User>>? {
        return database?.getDao()?.getAllUsers()
    }
}