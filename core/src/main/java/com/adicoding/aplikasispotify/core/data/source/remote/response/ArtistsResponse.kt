package com.adicoding.aplikasispotify.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ArtistsResponse(

	@field:SerializedName("images")
	val images: List<ArtistImageItem?>? = null,

	@field:SerializedName("followers")
	val followers: ArtistFollowers? = null,

	@field:SerializedName("genres")
	val genres: List<String?>? = null,

	@field:SerializedName("popularity")
	val popularity: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("href")
	val href: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("external_urls")
	val externalUrls: ArtistExternalUrls? = null,

	@field:SerializedName("uri")
	val uri: String? = null
)

data class ArtistExternalUrls(

	@field:SerializedName("spotify")
	val spotify: String? = null
)

data class ArtistImageItem(

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
)

data class ArtistFollowers(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("href")
	val href: Any? = null
)