package com.example.dictionary.view.base

import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.model.data.AppState

abstract class BaseActivity<T : AppState> : AppCompatActivity() {
    abstract val model: BaseViewModel<T>
    abstract fun renderData(appState: AppState)
}