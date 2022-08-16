package com.inflames1986.mvplesson.users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.inflames1986.mvplesson.AndroidScreens
import com.inflames1986.mvplesson.interfaces.IUserListPresenter
import com.inflames1986.mvplesson.interfaces.UserItemView
import com.inflames1986.mvplesson.interfaces.UsersView
import com.inflames1986.mvplesson.model.GithubUser
import com.inflames1986.mvplesson.model.GithubUsersRepo

class UsersPresenter(
    val usersRepo: GithubUsersRepo,
    val router: Router
) : MvpPresenter<UsersView>() {

    class UsersListPresenter : IUserListPresenter {
        val users = mutableListOf<GithubUser>()
        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
    }

    fun loadData() {
        val users = usersRepo.getUsers()
        usersListPresenter.users.addAll(users)
        usersListPresenter.itemClickListener = { itemView ->
            router.navigateTo(AndroidScreens().userInfo(users[itemView.pos].id))
        }
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}