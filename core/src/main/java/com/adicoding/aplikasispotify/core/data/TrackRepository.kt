package com.adicoding.aplikasispotify.core.data

import com.adicoding.aplikasispotify.core.data.source.local.TrackLocalDataSource
import com.adicoding.aplikasispotify.core.data.source.remote.TrackRemoteDataSource
import com.adicoding.aplikasispotify.core.domain.model.Playlist
import com.adicoding.aplikasispotify.core.domain.repository.ITrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TrackRepository(
    private val remoteDataSource: TrackRemoteDataSource,
    private val localDataSource: TrackLocalDataSource
) : ITrackRepository {

    override suspend fun getPlaylists(token: String, playlistId: String): List<Playlist> {
        // Ambil playlist dan tracks sesuai playlistId
        val playlistResponse = remoteDataSource.getPlaylists(token, playlistId)

        // Mengonversi TrackResponse menjadi model Playlist
        return playlistResponse.tracks?.items?.mapNotNull { item ->
            // Memastikan track tidak null sebelum dimasukkan
            item?.track?.let { track ->
                Playlist(
                    id = playlistResponse.id.orEmpty(),
                    name = playlistResponse.name.orEmpty(),
                    description = playlistResponse.description.orEmpty(),
                    imageUrl = playlistResponse.images?.firstOrNull()?.url.orEmpty(),
                    tracks = listOf(track)
                )
            }
        } ?: emptyList()
    }

    override fun getMyPlaylists(token: String): Flow<List<Playlist>> = flow {
        val response = remoteDataSource.getMyPlaylists(token)
        val playlists = response.items?.map { item ->
            Playlist(
                id = item.id.orEmpty(),
                name = item.name.orEmpty(),
                description = item.description.orEmpty(),
                imageUrl = item.images?.firstOrNull()?.url.orEmpty(),
                tracks = emptyList()
            )
        }.orEmpty()
        emit(playlists)
    }
}
