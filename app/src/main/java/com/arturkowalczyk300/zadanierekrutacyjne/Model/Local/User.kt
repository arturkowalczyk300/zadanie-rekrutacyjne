package com.arturkowalczyk300.zadanierekrutacyjne.Model.Local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arturkowalczyk300.zadanierekrutacyjne.Model.EnumApiSource

@Entity(tableName = "table_users")
data class User(
    @PrimaryKey val id: String,
    val name: String,
    val source: EnumApiSource,
    val avatarUrl: String?
)