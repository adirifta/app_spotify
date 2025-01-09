package com.adicoding.aplikasispotify.core.data

import com.adicoding.aplikasispotify.core.data.source.local.TrackLocalDataSource
import com.adicoding.aplikasispotify.core.data.source.remote.TrackRemoteDataSource
import com.adicoding.aplikasispotify.core.domain.model.Playlist
import com.adicoding.aplikasispotify.core.domain.model.Track
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.adicoding.aplikasispotify.core.utils.toDomain

class TrackRepository(
    private val remoteDataSource: TrackRemoteDataSource,
    private val localDataSource: TrackLocalDataSource
) : ITrackRepository {

    override fun getTracks(): Flow<List<Track>> {
        TODO("Not yet implemented")
    }

    override fun getTrackDetail(id: String): Flow<Track> {
        TODO("Not yet implemented")
    }

    override fun getFavoriteTracks(): Flow<List<Track>> {
        TODO("Not yet implemented")
    }

    override suspend fun addFavoriteTrack(track: Track) {
        TODO("Not yet implemented")
    }

    override suspend fun removeFavoriteTrack(track: Track) {
        TODO("Not yet implemented")
    }

    override suspend fun getPlaylists(token: String, playlistId: String): List<Playlist> {
        val playlistResponse = remoteDataSource.getPlaylists(token, playlistId)
        return listOf(playlistResponse.toDomain())
    }
}
