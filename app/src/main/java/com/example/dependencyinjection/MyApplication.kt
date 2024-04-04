package com.example.dependencyinjection

import android.app.Application
import com.example.dependencyinjection.di.AppComponent
import com.example.dependencyinjection.di.DaggerAppComponent

class MyApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.create()
    }
}