package com.adicoding.aplikasispotify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MyPlaylistsResponse(
	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("offset")
	val offset: Int? = null,

	@field:SerializedName("previous")
	val previous: String? = null,

	@field:SerializedName("limit")
	val limit: Int? = null,

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("items")
	val items: List<PlaylistItemResponse>? = null
)

data class PlaylistItemResponse(
	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("images")
	val images: List<ImageResponse>? = null
)

data class ImageResponse(
	@field:SerializedName("url")
	val url: String? = null
)
