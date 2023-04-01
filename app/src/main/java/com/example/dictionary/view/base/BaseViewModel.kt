package com.example.dictionary.view.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dictionary.model.data.AppState
import com.example.dictionary.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<T : AppState>(
    protected val liveDataForViewToObserve: MutableLiveData<T> =
        MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable =
        CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    abstract fun getData(word: String, isOnline: Boolean)

    override fun onCleared() {
        compositeDisposable.clear()
    }

}