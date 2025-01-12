package com.adicoding.aplikasispotify.di

import com.adicoding.aplikasispotify.core.data.TrackRepository
import com.adicoding.aplikasispotify.core.data.source.local.TrackLocalDataSource
import com.adicoding.aplikasispotify.core.data.source.remote.TrackRemoteDataSource
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import com.adicoding.aplikasispotify.core.ui.TrackViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<ITrackRepository> { TrackRepository(get(), get()) }
    factory { TrackViewModel(get()) }

    // Provide the ViewModel
    viewModel { TrackViewModel(get()) }
}