package com.inflames1986.mvplesson.repositoryinfo

import com.github.terrakok.cicerone.Router
import com.inflames1986.mvplesson.interfaces.RepoInfoView
import com.inflames1986.mvplesson.model.Repository
import com.inflames1986.mvplesson.model.RetrofitGitHubUserRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class RepoInfoPresenter(
    val repositoryUrl: String? = null,
    private val githubUsersRepo: RetrofitGitHubUserRepo,
    val router: Router
) : MvpPresenter<RepoInfoView>() {
    val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        if (repositoryUrl != null) {
            viewState.init()
            viewState.hideErrorBar()
            viewState.showProgressBar()
            githubUsersRepo
                .getRepositoryByUrl(repositoryUrl)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : SingleObserver<Repository> {
                    override fun onSubscribe(d: Disposable?) {
                        disposables.add(d)
                    }

                    override fun onSuccess(repoInfo: Repository?) {
                        onGetRepositorySuccess(repoInfo)
                    }

                    override fun onError(e: Throwable?) {
                        onGetRepositoryError(e)
                    }
                })
        }
    }

    private fun onGetRepositorySuccess(repoInfo: Repository?) {
        repoInfo?.let {
            viewState.showLogin(it.owner.login)
            viewState.setImageAvatar(it.owner.avatarUrl)
            viewState.showNameRepository(it.name)
            viewState.showDescriptionRepository(
                it.description
                        + " \nЗвездный рейтинг: " + it.stargazersCount
                        + " \nКоличество наблюдателей: " + it.watchersCount
            )
            viewState.showCountFork("Количество форков: " + it.forksCount)
            viewState.hideProgressBar()
        }
    }

    private fun onGetRepositoryError(e: Throwable?) {
        viewState.hideProgressBar()
        viewState.showErrorBar()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposables.clear()
    }
}