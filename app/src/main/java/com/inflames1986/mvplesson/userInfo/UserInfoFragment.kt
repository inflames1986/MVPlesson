package com.inflames1986.mvplesson.userInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.inflames1986.mvplesson.App
import com.inflames1986.mvplesson.databinding.FragmentUserInfoBinding
import com.inflames1986.mvplesson.glide.GlideImageLoader
import com.inflames1986.mvplesson.interfaces.BackButtonListener
import com.inflames1986.mvplesson.interfaces.UserInfoView
import com.inflames1986.mvplesson.model.RetrofitGitHubUserRepo
import com.inflames1986.mvplesson.myschedulers.MySchedulersFactory
import com.inflames1986.mvplesson.retrofit.GitHubApiFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class UserInfoFragment : MvpAppCompatFragment(), UserInfoView, BackButtonListener {

    companion object {
        private const val ARG_USER = "ARG_USER_LOGIN"

        fun newInstance(userLogin: String) =
            UserInfoFragment().apply { arguments = bundleOf(ARG_USER to userLogin) }
    }

    private val userLogin: String? by lazy {
        arguments?.getString(ARG_USER, "stdimensiy")
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
        UserInfoPresenter(
            userLogin,
            RetrofitGitHubUserRepo(GitHubApiFactory.create()),
            MySchedulersFactory.create(),
            App.instance.router
        )
    }

    var adapter: ReposRVAdapter? = null

    override fun backPressed(): Boolean = presenter.backPressed()

    override fun showLogin(text: String) {
        vb?.tvLogin?.text = text
    }

    override fun setImageAvatar(url: String): Unit = with(vb) {
        this?.imageViewUserAvatar?.let { GlideImageLoader().loadInfo(url, it) }
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

    override fun init() {
        vb?.rvUserRepos?.layoutManager = LinearLayoutManager(context)
        adapter = ReposRVAdapter(presenter.reposListPresenter)
        vb?.rvUserRepos?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showProgressBar() {
        this.vb?.progressBar?.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        vb?.progressBar?.visibility = View.GONE
    }

    override fun showErrorBar() {
        this.vb?.imageViewError?.visibility = View.VISIBLE
    }

    override fun hideErrorBar() {
        this.vb?.imageViewError?.visibility = View.GONE
    }
}