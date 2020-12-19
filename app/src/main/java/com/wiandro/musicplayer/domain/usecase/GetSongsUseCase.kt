package com.wiandro.musicplayer.domain.usecase

import com.wiandro.musicplayer.data.model.Song
import com.wiandro.musicplayer.domain.repository.PlaylistRepository

class GetSongsUseCase(private val playlistRepository: PlaylistRepository) {
    fun getSongs(): List<Song>? {
        return playlistRepository.getSongs()
    }
}