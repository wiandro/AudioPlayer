package com.wiandro.musicplayer.presentation.playlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wiandro.musicplayer.data.model.Song
import com.wiandro.musicplayer.domain.usecase.DeleteSongUseCase
import com.wiandro.musicplayer.domain.usecase.GetSongsUseCase
import com.wiandro.musicplayer.domain.usecase.SaveSongDataUseCase

class PlaylistViewModel(
    private val saveSongDataUseCase: SaveSongDataUseCase,
    private val getSongsUseCase: GetSongsUseCase,
    private val deleteSongUseCase: DeleteSongUseCase
) : ViewModel() {


    val playlistData = MutableLiveData<List<Song>>()

    fun saveSongData(song: Song) {
        saveSongDataUseCase.saveSongItem(song)
    }

    fun getSongsFromDb() {
        playlistData.value = getSongsUseCase.getSongs()
    }

    fun removeItemFromList(song: Song) {
        deleteSongUseCase.deleteSongItem(song)
        val list = playlistData.value as ArrayList<Song>
        list.remove(song)
        playlistData.value = list
    }
}