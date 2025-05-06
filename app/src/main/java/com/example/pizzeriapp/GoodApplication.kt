package com.example.pizzeriapp

import android.app.Application
import com.example.pizzeriapp.Database.AppContainer
import com.example.pizzeriapp.Database.AppDataClass


class GoodApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()

        container = AppDataClass(this)

    }
}