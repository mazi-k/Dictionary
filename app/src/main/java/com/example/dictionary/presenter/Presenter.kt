package com.example.dictionary.presenter

import com.example.dictionary.view.base.IView
import com.example.dictionary.model.data.AppState

interface Presenter <T : AppState, V : IView> {
    fun attachView(view: V)
    fun detachView(view: V)
    fun getData(word: String, isOnline: Boolean)
}