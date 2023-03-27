package com.example.dictionary.view.base

import com.example.dictionary.model.data.AppState

interface IView {
    fun renderData(appState: AppState)
}