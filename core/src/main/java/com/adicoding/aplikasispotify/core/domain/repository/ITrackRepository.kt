package com.adicoding.aplikasispotify.core.domain.repository

import com.adicoding.aplikasispotify.core.domain.model.Playlist
import com.adicoding.aplikasispotify.core.domain.model.Track
import kotlinx.coroutines.flow.Flow

interface ITrackRepository {
    fun getTracks(): Flow<List<Track>>
    fun getTrackDetail(id: String): Flow<Track>
    fun getFavoriteTracks(): Flow<List<Track>>
    suspend fun addFavoriteTrack(track: Track)
    suspend fun removeFavoriteTrack(track: Track)
    suspend fun getPlaylists(token: String): List<Playlist>
}