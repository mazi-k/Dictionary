package com.example.dictionary.model.datasource

import com.example.dictionary.model.data.DataModel

interface DataSource<T> {
    suspend fun getData(word: String): List<DataModel>
}