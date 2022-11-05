package com.inflames1986.mvplesson.core.di.modules

import android.content.Context
import com.inflames1986.mvplesson.core.database.GithubAppDb
import com.inflames1986.mvplesson.core.database.UserDAO
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataBaseModule {

    @Singleton
    @Provides
    fun database(context: Context): GithubAppDb =
        GithubAppDb.create(context)

    @Singleton
    @Provides
    fun userDao(database: GithubAppDb): UserDAO =
        database.userDao()
}