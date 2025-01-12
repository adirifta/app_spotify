package com.adicoding.aplikasispotify.core.utils

import com.adicoding.aplikasispotify.core.data.source.remote.response.PlaylistResponse
import com.adicoding.aplikasispotify.core.domain.model.Playlist

fun PlaylistResponse.toDomain(): Playlist {
    val imageUrl = this.images?.firstOrNull()?.url ?: ""
    return Playlist(
        id = this.id.orEmpty(),
        name = this.name.orEmpty(),
        description = this.description.orEmpty(),
        imageUrl = imageUrl,
        tracks = this.tracks?.items?.mapNotNull { it?.track } ?: emptyList()
    )
}