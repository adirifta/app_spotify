package com.adicoding.aplikasispotify.core.di

import androidx.room.Room
import com.adicoding.aplikasispotify.core.data.TrackRepository
import com.adicoding.aplikasispotify.core.data.source.local.TrackLocalDataSource
import com.adicoding.aplikasispotify.core.data.source.local.room.AppDatabase
import com.adicoding.aplikasispotify.core.data.source.remote.TrackRemoteDataSource
import com.adicoding.aplikasispotify.core.data.source.remote.network.ApiService
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

// Modul untuk Room Database
val databaseModule = module {
    factory { get<AppDatabase>().trackDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "app_database"
        ).fallbackToDestructiveMigration().build()
    }
}

// Modul untuk API dan Retrofit
val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://v1.nocodeapi.com/project_adi/spotify/zMjeSwBvhEdNYvox/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

// Modul untuk Repository dan DataSource
val repositoryModule = module {
    single { TrackLocalDataSource(get()) }
    single { TrackRemoteDataSource(get()) }
    single<ITrackRepository> {
        TrackRepository(
            get(),
            get(),
        )
    }
}