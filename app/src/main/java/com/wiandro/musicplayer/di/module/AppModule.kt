package com.wiandro.musicplayer.di.module

import com.wiandro.musicplayer.domain.repository.PlaylistRepository
import com.wiandro.musicplayer.domain.usecase.DeleteSongUseCase
import com.wiandro.musicplayer.domain.usecase.GetSongsUseCase
import com.wiandro.musicplayer.domain.usecase.SaveSongDataUseCase
import com.wiandro.musicplayer.presentation.playlist.PlaylistViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    viewModel { PlaylistViewModel(get(), get(), get()) }

    single { createGetSongsUseCase(get()) }

    single { createDeleteSongUseCase(get()) }

    single { createSaveSongDataUseCase(get()) }

    single { createPlaylistRepository(get()) }
}


fun createSaveSongDataUseCase(
    playlistRepository: PlaylistRepository
): SaveSongDataUseCase {
    return SaveSongDataUseCase(playlistRepository)
}

fun createDeleteSongUseCase(
    playlistRepository: PlaylistRepository
): DeleteSongUseCase {
    return DeleteSongUseCase(playlistRepository)
}


fun createGetSongsUseCase(
    playlistRepository: PlaylistRepository
): GetSongsUseCase {
    return GetSongsUseCase(playlistRepository)
}
