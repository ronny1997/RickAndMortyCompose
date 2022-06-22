package com.ronny.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ronny.core.dispacher.main
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<VS : ViewState, I : Event> : ViewModel() {

    private val mutableViewState = MutableSharedFlow<VS?>()

    val viewState: SharedFlow<VS?>
        get() = mutableViewState

    private var job: Job? = null

    protected fun updateViewState(viewState: VS) {
        viewModelScope.launch(main) {
            mutableViewState.emit(viewState)
        }
    }


    abstract fun onEvent(event: I)

    fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(main) {
            block()
        }
    }

}