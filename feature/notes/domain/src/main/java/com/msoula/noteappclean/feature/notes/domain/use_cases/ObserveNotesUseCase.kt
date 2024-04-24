package com.msoula.noteappclean.feature.notes.domain.use_cases

import com.msoula.noteappclean.feature.notes.domain.models.NoteDomainModel
import com.msoula.noteappclean.feature.notes.domain.repositories.NoteRepository
import kotlinx.coroutines.flow.Flow

class ObserveNotesUseCase(
    private val noteRepository: NoteRepository
) {
    operator fun invoke(): Flow<List<NoteDomainModel>> {
        return noteRepository.observeNotes()
    }
}