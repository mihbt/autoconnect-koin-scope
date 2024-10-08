package com.example.koinscope.model.repositories

interface DataStore {

}

class DataStoreImpl(
    private val cachingStrategy: CachingStrategy
): DataStore {
}