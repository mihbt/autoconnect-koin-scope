package com.example.koinscope

import com.example.koinscope.di.modules.allModules
import org.junit.Test
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.test.verify.verify

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class KoinTest {

    @OptIn(KoinExperimentalAPI::class)
    @Test
    fun `test koin definitions`() {
        allModules.verify()
    }
}