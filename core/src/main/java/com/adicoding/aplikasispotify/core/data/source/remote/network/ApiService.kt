package com.adicoding.aplikasispotify.core.data.source.remote.network

import com.adicoding.aplikasispotify.core.data.source.remote.response.MyPlaylistsResponse
import com.adicoding.aplikasispotify.core.data.source.remote.response.PlaylistResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    suspend fun getPlaylists(
        @Header("Authorization") token: String,
        @Query("id") playlistId: String
    ): PlaylistResponse

    @GET("myPlaylists")
    suspend fun getMyPlaylists(
        @Header("Authorization") token: String,
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): MyPlaylistsResponse
}