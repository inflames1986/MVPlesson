package com.inflames1986.mvplesson.interfaces

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ErrorView {

    fun showErrorBar()

    fun hideErrorBar()
}