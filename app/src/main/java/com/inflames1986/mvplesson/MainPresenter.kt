package com.inflames1986.mvplesson

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import com.inflames1986.mvplesson.interfaces.IScreens
import com.inflames1986.mvplesson.interfaces.MainView

class MainPresenter(val router: Router, val screens: IScreens) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.users())
    }

    fun backClicked() {
        router.exit()
    }
}