package com.example.dictionary.view.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dictionary.model.data.AppState
import com.example.dictionary.presenter.Presenter

abstract class BaseActivity<T : AppState> : AppCompatActivity(), IView {

    protected lateinit var presenter: Presenter<T, IView>
    protected abstract fun createPresenter(): Presenter<T, IView>
    abstract override fun renderData(appState: AppState)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView(this)
    }

}