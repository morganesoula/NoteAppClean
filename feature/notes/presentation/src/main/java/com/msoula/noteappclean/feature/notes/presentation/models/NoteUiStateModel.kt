package com.msoula.noteappclean.feature.notes.presentation.models

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.PersistentList

sealed interface NoteUiStateModel {
    data object Loading : NoteUiStateModel
    data object Empty : NoteUiStateModel
    @Immutable
    data class Fetched(val list: PersistentList<NoteUiModel>) : NoteUiStateModel
}
