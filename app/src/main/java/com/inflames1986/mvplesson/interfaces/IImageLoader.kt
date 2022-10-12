package com.inflames1986.mvplesson.interfaces

interface IImageLoader<T> {
    fun loadInfo(url: String, container: T)
}