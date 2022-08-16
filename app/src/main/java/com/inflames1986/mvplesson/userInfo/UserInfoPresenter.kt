package com.inflames1986.mvplesson.userInfo

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.inflames1986.mvplesson.interfaces.UserInfoView
import com.inflames1986.mvplesson.model.GithubUsersRepo

class UserInfoPresenter(
    val userId: Int? = null,
    private val githubUsersRepo: GithubUsersRepo,
    val router: Router
) : MvpPresenter<UserInfoView>() {

    override fun onFirstViewAttach() {
        val currentUser = githubUsersRepo.getUsers().firstOrNull { it.id == userId }
        currentUser?.let { viewState.showLogin(it.login) }
        currentUser?.let { viewState.showTopString("Здесь будет название")
            (it.login) }
        currentUser?.let { viewState.showCenterString(it.htmlUrl) }
        currentUser?.let { viewState.showBottomString("Описательная часть") }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}