package com.adicoding.aplikasispotify.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adicoding.aplikasispotify.core.databinding.ItemPlaylistBinding
import com.adicoding.aplikasispotify.core.domain.model.Playlist
import com.bumptech.glide.Glide

class MyPlaylistsAdapter(
    private val onItemClick: (Playlist) -> Unit
) : ListAdapter<Playlist, MyPlaylistsAdapter.PlaylistViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Playlist>() {
            override fun areItemsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Playlist, newItem: Playlist): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        val binding = ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaylistViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlist = getItem(position)
        holder.bind(playlist)
        holder.itemView.setOnClickListener {
            onItemClick(playlist)
        }
    }

    inner class PlaylistViewHolder(private val binding: ItemPlaylistBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(playlist: Playlist) {
            binding.tvName.text = playlist.name
            binding.tvDescription.text = playlist.description
            Glide.with(binding.ivImage.context)
                .load(playlist.imageUrl)
                .into(binding.ivImage)
        }
    }
}
