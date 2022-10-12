package com.inflames1986.mvplesson.model

import com.inflames1986.mvplesson.core.database.UserDAO
import com.inflames1986.mvplesson.core.network.UsersApi
import com.inflames1986.mvplesson.interfaces.IDataGitHubAPI
import com.inflames1986.mvplesson.interfaces.IGitHubUsersRepo
import com.inflames1986.mvplesson.myschedulers.MySchedulersFactory
import io.reactivex.rxjava3.core.Single


class RetrofitGitHubUserRepo(
    private val api: IDataGitHubAPI,
    private val userDao: UserDAO,
    private val networkStatus: Single<Boolean>
) : IGitHubUsersRepo {

    override fun getUsers(): Single<List<GithubUser>> {
        return api.getUsers().subscribeOn(MySchedulersFactory.create().io())
    }

    override fun getUserByLogin(login: String): Single<GithubUserAdvanced> {
        return api.getUserByLogin(login).subscribeOn(MySchedulersFactory.create().io())
    }

    override fun getUserRepos(
        login: String,
        type: String?,
        sort: String?,
        direction: String?,
        perPage: Int?,
        page: Int?
    ): Single<List<Repository>> {
        return api.getUserRepos(login, type, sort, direction, perPage, page)
            .subscribeOn(MySchedulersFactory.create().io())
    }

    override fun getRepositoryByUrl(url: String): Single<Repository> {
        return api.getRepositoryByUrl(url).subscribeOn(MySchedulersFactory.create().io())
    }
}