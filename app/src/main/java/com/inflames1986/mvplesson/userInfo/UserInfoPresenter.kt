package com.inflames1986.mvplesson.userInfo

import com.github.terrakok.cicerone.Router
import com.inflames1986.mvplesson.interfaces.UserInfoView
import com.inflames1986.mvplesson.model.GithubUserAdvanced
import com.inflames1986.mvplesson.model.GithubUsersRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter


class UserInfoPresenter(
    val userId: Int? = null,
    private val githubUsersRepo: GithubUsersRepo,
    val router: Router
) : MvpPresenter<UserInfoView>() {
    val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        if (userId != null) {
            viewState.hideErrorBar()
            viewState.showProgressBar()
            githubUsersRepo
                .getUserById(userId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<GithubUserAdvanced> {
                    override fun onSubscribe(d: Disposable?) {
                        disposables.add(d)
                    }

                    override fun onSuccess(t: GithubUserAdvanced?) {
                        if (t != null) {
                            t.let { viewState.showLogin(it.login) }
                            viewState.showTopString("Заглушка верхей строки")
                            t.let { viewState.showCenterString(it.htmlUrl) }
                            viewState.showBottomString("Заглушка нижней строки")
                            viewState.hideProgressBar()
                        }
                    }

                    override fun onError(e: Throwable?) {
                        viewState.hideProgressBar()
                        viewState.showErrorBar()
                    }
                })
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposables.clear()
    }
}