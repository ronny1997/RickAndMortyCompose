package com.ronny.presentation.home

import com.ronny.core.base.BaseViewModel
import com.ronny.presentation.authentication.LoginViewEvent
import com.ronny.presentation.authentication.LoginViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeViewState, HomeViewEvent>() {
    override fun onEvent(event: HomeViewEvent) {
        when (event) {
            is HomeViewEvent.Authenticate -> authenticate(event.user, event.pass)
        }
    }

    private fun authenticate(user: String, pass: String) {
        if (user.isNotBlank() && pass.isNotBlank()) {
            updateViewState(HomeViewState.SuccessLogin)
        }
    }
}