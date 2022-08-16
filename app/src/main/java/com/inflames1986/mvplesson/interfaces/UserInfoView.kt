package com.inflames1986.mvplesson.interfaces

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserInfoView: MvpView {

    fun showLogin(text: String)

    fun showTopString(text: String)

    fun showCenterString(text: String)

    fun showBottomString(text: String)
}