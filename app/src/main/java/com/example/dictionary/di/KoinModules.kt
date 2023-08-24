package com.example.dictionary.di

import androidx.room.Room
import com.example.dictionary.database.HistoryDataBase
import com.example.dictionary.model.data.DataModel
import com.example.dictionary.model.datasource.RetrofitImplementation
import com.example.dictionary.model.datasource.RoomDataBaseImplementation
import com.example.dictionary.model.repository.Repository
import com.example.dictionary.model.repository.RepositoryImplementation
import com.example.dictionary.model.repository.RepositoryImplementationLocal
import com.example.dictionary.model.repository.RepositoryLocal
import com.example.dictionary.view.history.HistoryInteractor
import com.example.dictionary.view.history.HistoryViewModel
import com.example.dictionary.view.main.MainInteractor
import com.example.dictionary.view.main.MainViewModel
import org.koin.dsl.module

// Для удобства создадим две переменные: в одной находятся зависимости, используемые во всём приложении, во второй - зависимости конкретного экрана
// Функция single сообщает Koin, что эта зависимость должна храниться в виде синглтона (в Dagger есть похожая аннотация)
// Аннотация named выполняет аналогичную Dagger функцию
// Функция factory сообщает Koin, что эту зависимость нужно создавать каждый раз заново, что как раз подходит для Activity и её компонентов.

val application = module {
    single {
        Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build()
    }

    single {
        get<HistoryDataBase>().historyDao()
    }

    single<Repository<List<DataModel>>> {
        RepositoryImplementation(RetrofitImplementation())
    }
    single<RepositoryLocal<List<DataModel>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}