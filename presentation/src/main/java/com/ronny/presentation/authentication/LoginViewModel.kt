package com.ronny.presentation.authentication

import com.ronny.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel<LoginViewState, LoginViewEvent>() {
    override fun onEvent(event: LoginViewEvent) {
        when (event) {
            is LoginViewEvent.Authenticate -> authenticate(event.user, event.pass)
            is LoginViewEvent.Initialize -> updateViewState(LoginViewState.InitState)
        }
    }

    private fun authenticate(user: String, pass: String) {
        if (user.isNotBlank() && pass.isNotBlank()) {
            updateViewState(LoginViewState.SuccessLogin)
        }
    }
}