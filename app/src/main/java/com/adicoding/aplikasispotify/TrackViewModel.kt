package com.adicoding.aplikasispotify

import androidx.lifecycle.ViewModel
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import com.google.ar.core.Track
import kotlinx.coroutines.flow.Flow


class TrackViewModel(
    private val repository: ITrackRepository
) : ViewModel() {
//    fun getTracks(token: String): Flow<List<Track>> = repository.getTracks(token)
//    fun getFavoriteTracks(): Flow<List<Track>> = repository.getFavoriteTracks()
//    suspend fun addFavoriteTrack(track: Track) = repository.addFavoriteTrack(track)
//    suspend fun removeFavoriteTrack(track: Track) = repository.removeFavoriteTrack(track)
}
