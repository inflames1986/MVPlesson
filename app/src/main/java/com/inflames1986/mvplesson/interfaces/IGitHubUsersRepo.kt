package com.inflames1986.mvplesson.interfaces

import com.inflames1986.mvplesson.model.GithubUser
import com.inflames1986.mvplesson.model.GithubUserAdvanced
import com.inflames1986.mvplesson.model.Repository
import io.reactivex.rxjava3.core.Single

interface IGitHubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>

    fun getUserByLogin(login: String): Single<GithubUserAdvanced>

    fun getUserRepos(
        login: String,
        type: String?,
        sort: String?,
        direction: String?,
        perPage: Int?,
        page: Int?
    ): Single<List<Repository>>

    fun getRepositoryByUrl(url: String): Single<Repository>
}