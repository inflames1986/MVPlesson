package com.inflames1986.mvplesson.core.di.modules

import com.inflames1986.mvplesson.core.database.UserDAO
import com.inflames1986.mvplesson.core.network.UsersApi
import com.inflames1986.mvplesson.core.utils.ConnectivityListener
import com.inflames1986.mvplesson.interfaces.IDataGitHubAPI
import com.inflames1986.mvplesson.interfaces.IGitHubUsersRepo
import com.inflames1986.mvplesson.model.RetrofitGitHubUserRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(
        iDataGitHubAPI: IDataGitHubAPI,
        userDao: UserDAO,
        networkStatus: ConnectivityListener
    ): IGitHubUsersRepo{
        return RetrofitGitHubUserRepo(iDataGitHubAPI, userDao, networkStatus.statusSingle())
    }
}