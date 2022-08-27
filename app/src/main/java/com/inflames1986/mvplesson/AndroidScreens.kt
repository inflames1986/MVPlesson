package com.inflames1986.mvplesson

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.inflames1986.mvplesson.imageconverter.ImageConverterFragment
import com.inflames1986.mvplesson.interfaces.IScreens
import com.inflames1986.mvplesson.userInfo.UserInfoFragment
import com.inflames1986.mvplesson.users.UsersFragment

class AndroidScreens : IScreens {

    override fun users(): Screen = FragmentScreen { UsersFragment.newInstance() }

    override fun userInfo(userId: Int): Screen = FragmentScreen { UserInfoFragment.newInstance(userId) }

    override fun imageConverter(): Screen =
        FragmentScreen { ImageConverterFragment() }
}
