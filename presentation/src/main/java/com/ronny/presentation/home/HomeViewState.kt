package com.ronny.presentation.home

import com.ronny.core.base.ViewState


sealed class HomeViewState : ViewState {
    object InitState : HomeViewState()
    object SuccessLogin : HomeViewState()
}