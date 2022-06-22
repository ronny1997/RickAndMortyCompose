package com.ronny.core.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class BaseCompose<VM : BaseViewModel<VS, *>, VS : ViewState>(
    private val current: LifecycleOwner,
    var vm: VM,
    val render: (VS) -> Unit,
) {
    init {
        initConfig()
    }

    private fun initConfig() {
        vm.viewState.launchWhenStarted(current)
    }

    private fun SharedFlow<VS?>.launchWhenStarted(
        lifecycleOwner: LifecycleOwner
    ) = with(lifecycleOwner) {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@launchWhenStarted.collect {
                    it?.let {
                        render(it)
                    }
                }
            }
        }
    }
}