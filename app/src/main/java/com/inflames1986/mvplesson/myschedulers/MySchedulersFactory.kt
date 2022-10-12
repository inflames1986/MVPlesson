package com.inflames1986.mvplesson.myschedulers

import com.inflames1986.mvplesson.interfaces.IMySchedulers

object MySchedulersFactory {
    fun create(): IMySchedulers = MySchedulers()
}