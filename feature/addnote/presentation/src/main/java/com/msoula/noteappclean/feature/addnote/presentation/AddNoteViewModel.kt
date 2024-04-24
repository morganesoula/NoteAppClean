package com.msoula.noteappclean.feature.addnote.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.msoula.noteappclean.core.common.Result
import com.msoula.noteappclean.core.common.StringResourceProvider
import com.msoula.noteappclean.core.di.navigation.AppScreenRoute
import com.msoula.noteappclean.core.di.navigation.Navigator
import com.msoula.noteappclean.feature.addnote.domain.use_cases.ValidateDescriptionUseCase
import com.msoula.noteappclean.feature.addnote.domain.use_cases.ValidateTitleUseCase
import com.msoula.noteappclean.feature.addnote.presentation.models.AddNoteFormEvent
import com.msoula.noteappclean.feature.addnote.presentation.models.AddNoteFormUiState
import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel
import com.msoula.noteappclean.feature.notes.domain.use_cases.InsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val insertNoteUseCase: InsertNoteUseCase,
    private val validateTitleUseCase: ValidateTitleUseCase,
    private val validateDescriptionUseCase: ValidateDescriptionUseCase,
    private val resourceProvider: StringResourceProvider,
    private val navigator: Navigator
) : ViewModel() {

    private val _addNoteState = MutableStateFlow(AddNoteFormUiState())
    val addNoteState = _addNoteState.asStateFlow()

    fun onUiEvent(event: AddNoteFormEvent) {
        when (event) {
            is AddNoteFormEvent.OnTitleChanged -> {
                _addNoteState.update { it.copy(noteTitle = event.title) }
                validateInput()
            }

            is AddNoteFormEvent.OnDescriptionChanged -> {
                _addNoteState.update { it.copy(noteDescription = event.description) }
                validateInput()
            }

            AddNoteFormEvent.OnSubmitNote -> {
                saveNote()
            }
        }
    }

    private fun validateInput() {
        val titleResult =
            validateTitleUseCase.execute(
                addNoteState.value.noteTitle,
                resourceProvider.getString(R.string.title_error)
            )
        val descriptionResult =
            validateDescriptionUseCase.execute(
                addNoteState.value.noteDescription,
                resourceProvider.getString(R.string.description_error)
            )

        val error = listOf(titleResult, descriptionResult).any { !it.successful }

        _addNoteState.update { it.copy(enableSubmit = !error) }
    }

    private fun saveNote() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = insertNoteUseCase(
                NoteDomainModel(
                    0,
                    addNoteState.value.noteTitle,
                    addNoteState.value.noteDescription
                )
            )) {
                is Result.Success -> {
                    withContext(Dispatchers.Main) {
                        navigator.navigate(AppScreenRoute)
                    }
                }

                is Result.Failure -> Log.e("NotApp", result.error.message)
            }
        }
    }
}