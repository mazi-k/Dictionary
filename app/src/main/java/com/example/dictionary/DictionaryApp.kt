package com.example.dictionary

import android.app.Application
import com.example.dictionary.di.application
import com.example.dictionary.di.historyScreen
import com.example.dictionary.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DictionaryApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
