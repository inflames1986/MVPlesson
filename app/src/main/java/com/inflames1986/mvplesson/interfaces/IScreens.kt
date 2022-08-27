package com.inflames1986.mvplesson.interfaces

import com.github.terrakok.cicerone.Screen

interface IScreens {

    fun users(): Screen

    fun userInfo(userId: Int): Screen

    fun imageConverter(): Screen
}