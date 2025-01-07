package com.adicoding.aplikasispotify.core.utils

import com.adicoding.aplikasispotify.core.data.source.remote.response.PlaylistResponse
import com.adicoding.aplikasispotify.core.domain.model.Playlist

fun PlaylistResponse.toDomain(): Playlist {
    return Playlist(
        id = this.id,
        name = this.name,
        description = this.description,
        imageUrl = this.imageUrl
    )
}