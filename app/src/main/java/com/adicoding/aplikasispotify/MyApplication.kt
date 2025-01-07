package com.adicoding.aplikasispotify

import android.app.Application
import com.adicoding.aplikasispotify.core.di.databaseModule
import com.adicoding.aplikasispotify.core.di.networkModule
import com.adicoding.aplikasispotify.core.di.repositoryModule
import com.adicoding.aplikasispotify.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    appModule
                )
            )
        }
    }
}