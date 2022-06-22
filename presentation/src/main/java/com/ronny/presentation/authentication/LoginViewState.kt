package com.ronny.presentation.authentication


import com.ronny.core.base.ViewState

sealed class LoginViewState : ViewState {
    object InitState : LoginViewState()
    object SuccessLogin : LoginViewState()
}