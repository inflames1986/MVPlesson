package com.inflames1986.mvplesson.core.di

import com.inflames1986.mvplesson.MainActivity
import com.inflames1986.mvplesson.MainPresenter
import com.inflames1986.mvplesson.core.di.modules.ApiModule
import com.inflames1986.mvplesson.core.di.modules.AppModule
import com.inflames1986.mvplesson.core.di.modules.DataBaseModule
import com.inflames1986.mvplesson.core.di.modules.NavigationModule
import com.inflames1986.mvplesson.core.di.modules.RepositoryModule
import com.inflames1986.mvplesson.userInfo.UserInfoFragment
import com.inflames1986.mvplesson.userInfo.UserInfoPresenter
import com.inflames1986.mvplesson.users.UsersFragment
import com.inflames1986.mvplesson.users.UsersPresenter

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApiModule::class,
        AppModule::class,
        DataBaseModule::class,
        NavigationModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(usersPresenter: UsersPresenter)

    //При выполнении практического задания это должно отсюда уйти
    fun inject(userFragment: UsersFragment)
    fun inject(repositoryFragment: UserInfoFragment)
    fun inject(detailsPresenter: UserInfoPresenter)

}