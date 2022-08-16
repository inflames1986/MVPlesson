package com.inflames1986.mvplesson.interfaces

interface IListPresenter<V : IItemView> {

    var itemClickListener: ((V) -> Unit)?

    fun bindView(view: V)

    fun getCount(): Int
}