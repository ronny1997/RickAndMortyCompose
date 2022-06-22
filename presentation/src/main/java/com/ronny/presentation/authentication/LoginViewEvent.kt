package com.ronny.presentation.authentication

import com.ronny.core.base.Event

sealed class LoginViewEvent : Event {
    object Initialize : LoginViewEvent()
    class Authenticate(val user:String, val pass:String) : LoginViewEvent()

}