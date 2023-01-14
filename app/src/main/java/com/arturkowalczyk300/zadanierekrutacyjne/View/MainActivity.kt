package com.arturkowalczyk300.zadanierekrutacyjne.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.arturkowalczyk300.zadanierekrutacyjne.R
import com.arturkowalczyk300.zadanierekrutacyjne.ViewModel.UsersViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initDatabase()
    }
    private fun initViewModel() {
        viewModel =
            ViewModelProvider(this).get(UsersViewModel::class.java)
    }

    private fun initDatabase() {
        viewModel.initializeDatabase(this)
    }

}