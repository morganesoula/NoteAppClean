package com.msoula.noteappclean.feature.notedetail.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msoula.noteappclean.core.common.Result
import com.msoula.noteappclean.core.di.navigation.NoteDetailScreenRoute
import com.msoula.noteappclean.feature.notedetail.presentation.models.NoteDetailUiState
import com.msoula.noteappclean.feature.notes.domain.use_cases.FetchNoteByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val fetchNoteByIdUseCase: FetchNoteByIdUseCase
) : ViewModel() {

    private val _noteDetailState = MutableStateFlow(NoteDetailUiState())
    val noteDetailState = _noteDetailState.asStateFlow()

    private val route = NoteDetailScreenRoute(savedStateHandle)
    private val savedId: Long = route.id.toLong()

    init {
        fetchNoteInDb()
    }

    private fun fetchNoteInDb() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val note = fetchNoteByIdUseCase(savedId)) {
                is Result.Success -> {
                    _noteDetailState.update { state ->
                        state.copy(
                            title = note.data.title,
                            description = note.data.description
                        )
                    }
                }

                is Result.Failure -> {
                    Log.e("NoteAppClean", note.error.message)
                }
            }

        }
    }
}