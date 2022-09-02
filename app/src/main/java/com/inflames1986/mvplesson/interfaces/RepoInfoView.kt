package com.inflames1986.mvplesson.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepoInfoView : ProgressView, ErrorView, MvpView {

    fun showLogin(text: String)

    fun setImageAvatar(url: String)

    fun showNameRepository(text: String)

    fun showDescriptionRepository(text: String)

    fun showCountFork(count: String)

    fun init()
}