package com.arturkowalczyk300.zadanierekrutacyjne.Model.Local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 2)
abstract class UsersDatabase : RoomDatabase() {
    abstract fun getDao(): UsersDao

    companion object {
        private var instance: UsersDatabase? = null

        fun getInstance(context: Context): UsersDatabase? {
            instance = instance ?: Room.databaseBuilder(
                context,
                UsersDatabase::class.java,
                "users_database"
            ).fallbackToDestructiveMigration()
                .build()

            return instance
        }
    }
}