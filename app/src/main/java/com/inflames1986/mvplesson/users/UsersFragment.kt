package com.inflames1986.mvplesson.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.inflames1986.mvplesson.App
import com.inflames1986.mvplesson.databinding.FragmentUsersBinding
import com.inflames1986.mvplesson.glide.GlideImageLoader
import com.inflames1986.mvplesson.interfaces.BackButtonListener
import com.inflames1986.mvplesson.interfaces.UsersView
import com.inflames1986.mvplesson.model.RetrofitGitHubUserRepo
import com.inflames1986.mvplesson.myschedulers.MySchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter



class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            RetrofitGitHubUserRepo(com.inflames1986.mvplesson.retrofit.GitHubApiFactory.create()),
            MySchedulersFactory.create(),
            App.instance.router
        )
    }
    var adapter: UsersRVAdapter? = null
    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root


    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter, GlideImageLoader())
        vb?.rvUsers?.adapter = adapter
        vb?.btnGoToImgConverter?.setOnClickListener { presenter.goToImageConverter() }
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


    override fun backPressed(): Boolean = presenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }
}