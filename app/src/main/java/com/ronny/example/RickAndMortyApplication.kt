package com.ronny.example

import dagger.hilt.android.HiltAndroidApp
import android.app.Application
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import javax.inject.Inject

@HiltAndroidApp
class RickAndMortyApplication : Application()