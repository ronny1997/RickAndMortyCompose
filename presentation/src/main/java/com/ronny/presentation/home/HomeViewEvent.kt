package com.ronny.presentation.home

import com.ronny.core.base.Event


sealed class HomeViewEvent : Event {
    class Authenticate(val user:String, val pass:String) : HomeViewEvent()

}