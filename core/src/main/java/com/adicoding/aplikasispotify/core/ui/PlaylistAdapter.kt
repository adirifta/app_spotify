package com.adicoding.aplikasispotify.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adicoding.aplikasispotify.core.data.source.remote.response.ItemsItem
import com.adicoding.aplikasispotify.core.data.source.remote.response.Track
import com.adicoding.aplikasispotify.core.databinding.ItemPlaylistBinding
import com.adicoding.aplikasispotify.core.domain.model.Playlist
import com.bumptech.glide.Glide

class PlaylistAdapter : ListAdapter<Track, PlaylistAdapter.TrackViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder {
        val binding = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TrackViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TrackViewHolder(private val binding: ItemPlaylistBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(track: Track) {
            binding.tvName.text = track.name
            binding.tvDescription.text = track.album?.name
            Glide.with(binding.ivImage.context)
                .load(track.album?.images?.firstOrNull()?.url)
                .into(binding.ivImage)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Track>() {
            override fun areItemsTheSame(oldItem: Track, newItem: Track): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Track, newItem: Track): Boolean {
                return oldItem == newItem
            }
        }
    }
}
