package com.inflames1986.mvplesson.userInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.inflames1986.mvplesson.databinding.FragmentUserInfoBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import com.inflames1986.mvplesson.App
import com.inflames1986.mvplesson.interfaces.BackButtonListener
import com.inflames1986.mvplesson.interfaces.UserInfoView
import com.inflames1986.mvplesson.model.GithubUsersRepo

class UserInfoFragment : MvpAppCompatFragment(), UserInfoView, BackButtonListener {

    companion object {
        private const val ARG_USER = "ARG_USER_ID"

        fun newInstance(userId: Int) =
            UserInfoFragment().apply { arguments = bundleOf(ARG_USER to userId) }
    }

    private val userId: Int? by lazy {
        arguments?.getInt(ARG_USER, 0)
    }

    private var vb: FragmentUserInfoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUserInfoBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    val presenter: UserInfoPresenter by moxyPresenter {
        UserInfoPresenter(userId, GithubUsersRepo(), App.instance.router)
    }

    override fun backPressed(): Boolean = presenter.backPressed()

    override fun showLogin(text: String) {
        vb?.tvLogin?.text = text
    }

    override fun showTopString(text: String) {
        vb?.textViewTopString?.text = text
    }

    override fun showCenterString(text: String) {
        vb?.textViewCenterString?.text = text
    }

    override fun showBottomString(text: String) {
        vb?.textViewBottomString?.text = text
    }

}