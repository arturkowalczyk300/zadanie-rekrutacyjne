package com.arturkowalczyk300.zadanierekrutacyjne.Model.Local

import com.arturkowalczyk300.zadanierekrutacyjne.Model.EnumApiSource
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Web.DailymotionUser
import com.arturkowalczyk300.zadanierekrutacyjne.Model.Web.GithubUser

class ConverterToDatabaseUser {
    companion object {
        fun convertDailymotionUser(user: DailymotionUser): User {
            return User(
                id = user.id,
                name = user.screenName,
                source = EnumApiSource.API_DAILYMOTION,
                avatarUrl = null
            )
        }

        fun convertGithubUser(user: GithubUser): User {
            return User(
                id = user.id.toString(),
                name = user.login,
                source = EnumApiSource.API_GITHUB,
                avatarUrl = user.avatarUrl
            )
        }
    }
}