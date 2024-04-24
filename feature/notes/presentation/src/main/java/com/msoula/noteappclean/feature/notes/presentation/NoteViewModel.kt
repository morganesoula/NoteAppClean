package com.msoula.noteappclean.feature.notes.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msoula.noteappclean.feature.notes.domain.use_cases.ObserveNotesUseCase
import com.msoula.noteappclean.feature.notes.presentation.mappers.toNoteUiModel
import com.msoula.noteappclean.feature.notes.presentation.models.NoteUiStateModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class NoteViewModel @Inject constructor(
    private val observeNotesUseCase: ObserveNotesUseCase
) : ViewModel() {

    val noteState: StateFlow<NoteUiStateModel> by lazy {
        observeNotesUseCase()
            .mapLatest { notes ->
                if (notes.isEmpty()) {
                    NoteUiStateModel.Empty
                } else {
                    NoteUiStateModel.Fetched(notes.map { it.toNoteUiModel() }.toPersistentList())
                }
            }
            .flowOn(Dispatchers.Main)
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                NoteUiStateModel.Loading
            )
    }
}