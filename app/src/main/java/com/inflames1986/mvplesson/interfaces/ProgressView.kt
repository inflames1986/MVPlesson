package com.inflames1986.mvplesson.interfaces

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProgressView {

    fun showProgressBar()

    fun hideProgressBar()
}