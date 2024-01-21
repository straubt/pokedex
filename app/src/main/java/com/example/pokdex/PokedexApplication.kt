package com.example.pokdex

import android.app.Application
import com.example.pokdex.data.AppContainer
import com.example.pokdex.data.DefaultAppContainer

class PokedexApplication : Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}