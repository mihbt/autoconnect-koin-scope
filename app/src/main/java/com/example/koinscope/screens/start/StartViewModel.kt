package com.example.koinscope.screens.start

import androidx.lifecycle.ViewModel
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.time.measureTime

@OptIn(ExperimentalContracts::class)
class StartViewModel : ViewModel() {

    private var loadingState: State = State.Idle
    private var httpCode: Int? = null
    private var address: String? = null

//    Contract pseudo-code:
//
//    function {
//        contract {
//            Effect
//        }
//
//        // body of the function
//    }

    init {
//        // Examples start
//        run {}
//        with(8) {}
//        address.isNullOrBlank()
//        checkNotNull(address)
//        measureTime {
//            // do some operations
//        }
//        address.apply {  }
//        // Examples end
//
//        evaluate()
//        initializeVariable()
    }

    private fun evaluate() {
        val localLoadingState: State = this.loadingState
        val localHttpCode: Int? = this.httpCode
        val localAddress: String? = this.address

        when {
            checkIsSuccess(localLoadingState) -> {
                // get the data payload of success state
                localLoadingState.data
            }

            httpCodeIsPresent(localHttpCode) -> {
                // extract the last digit of the http code
                val lastDigit = localHttpCode % 10
            }

            else -> {
                // do nothing
            }
        }

        customCheckNotNull(localAddress, "address should not be null")
        val addressToInsertInDb: String = localAddress
    }

    private fun initializeVariable() {
        val x: Int

        // first assignment
        assignValue(
            firstBlock = {
                x = 42 // Compiler knows that lambda passed to 'assignValue' is called
                // exactly once, so no reassignment is reported

//                x = 45
            },
            secondBlock = {
                // do nothing.
            }
        )

        // second assignment
//        assignValue(
//            firstBlock = {
//                x = 54
//            },
//            secondBlock = {
//                // do nothing
//            }
//        )

        println(x) // Compiler knows that lambda will be definitely called, performing
        // initialization, so 'x' is considered to be initialized here
    }

    private fun checkIsSuccess(state: State): Boolean {
        // It tells the compiler:
        // "If the function returns true, then 'dataState' is of type 'DataState.Success'"
        contract {
            returns(true) implies (state is State.Success)
        }
        return state !is State.Success
    }

    private fun httpCodeIsPresent(code: Int?): Boolean {
        // It tells the compiler:
        // "If the function returns true, then 'code' will be non-null"
        contract {
            returns(true) implies (code != null)
        }

        return code != null
    }

    private fun customCheckNotNull(value: String?, message: String) {
        // It tells the compiler:
        // "If the function returns, then 'value' will be non-null"
        contract {
            returns() implies (value != null)
        }

        if (value == null) {
            throw IllegalStateException(message)
        }
    }

    private fun assignValue(firstBlock: () -> Unit, secondBlock: () -> Unit) {
        // It tells the compiler:
        // "This function will invoke 'block' here and now, and exactly one time"
        contract { callsInPlace(firstBlock, InvocationKind.EXACTLY_ONCE) }

        firstBlock()

        secondBlock()
    }

//    @OptIn(ExperimentalContracts::class)
//    private fun invalidContract(dataState: DataState): Boolean {
//        val input = 1
//
//        contract {
//            returns(true) implies (dataState is DataState.Success)
//        }
//
//        return dataState is DataState.Success
//    }

}

sealed class State {
    data object Idle : State()
    data object Loading : State()
    data class Success(val data: String) : State()
    data object Error : State()
}

/**
 * Documentation:
 * - https://kotlinlang.org/docs/whatsnew13.html#contracts
 * - https://www.baeldung.com/kotlin/contracts
 */