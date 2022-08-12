package com.inflames1986.mvplesson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.inflames1986.mvplesson.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), MainView {


    private var _binding: ActivityMainBinding? = null
    val binding: ActivityMainBinding
        get() = _binding!!


    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initPresenter()

        with(binding) {
            btnNumber1.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber1)
            }
            btnNumber2.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber2)
            }
            btnNumber3.setOnClickListener {
                presenter.onCounterClick(R.id.btnNumber3)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                0 -> tvText1.text = counter
                1 -> tvText2.text = counter
                2 -> tvText3.text = counter
            }
        }
    }
}