package com.inflames1986.mvplesson.core.di.modules

import android.net.ConnectivityManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.inflames1986.mvplesson.core.network.UsersApi
import com.inflames1986.mvplesson.core.utils.ConnectivityListener
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
object ApiModule {
    @Named("baseUrl")
    @Provides
    fun provideBaseUrl(): String = "https://api.github.com/"

    @Provides
    fun provideApi(@Named("baseUrl") baseUrl: String, gson: Gson): UsersApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UsersApi::class.java)

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .excludeFieldsWithoutExposeAnnotation()
        .create()

    @Singleton
    @Provides
    fun provideConnectivityListener(connectivityManager: ConnectivityManager): ConnectivityListener =
        ConnectivityListener(connectivityManager)

}