package com.example.dictionary.di

import android.app.Application
import com.example.dictionary.DictionaryApp
import com.example.dictionary.di.module.ActivityModule
import com.example.dictionary.di.module.InteractorModule
import com.example.dictionary.di.module.RepositoryModule
import com.example.dictionary.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        AndroidSupportInjectionModule::class]
)
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(englishVocabularyApp: DictionaryApp)
}
