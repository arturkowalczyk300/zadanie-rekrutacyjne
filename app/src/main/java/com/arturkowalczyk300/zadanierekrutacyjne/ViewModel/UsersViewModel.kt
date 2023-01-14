package com.arturkowalczyk300.zadanierekrutacyjne.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Local.UsersDatabase
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Repository

class UsersViewModel : ViewModel() {
    private val repository = Repository()

    fun initializeDatabase(context: Context) {
        repository.initializeDatabase(context)
    }

    fun updateGithubUsers() {
        repository.updateGithubUsers()
    }

    fun updateDailymotionUsers() {
        repository.updateDailymotionUsers()
    }

    fun getAllUsers() = repository.getAllUsers()
}