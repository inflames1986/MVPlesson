package com.inflames1986.mvplesson

class CountersPresenter(
    private val view: MainView
) {
    private val model = CountersModel()

    fun onCounterClick(button: Int) {
        when (button) {
            BUTTON1 -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            BUTTON2 -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            BUTTON3 -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}