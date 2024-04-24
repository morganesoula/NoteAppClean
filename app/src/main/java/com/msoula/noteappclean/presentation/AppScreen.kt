package com.msoula.noteappclean.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.msoula.noteappclean.feature.notes.presentation.EmptyNoteScreen
import com.msoula.noteappclean.feature.notes.presentation.NoteScreen
import com.msoula.noteappclean.feature.notes.presentation.NoteViewModel
import com.msoula.noteappclean.feature.notes.presentation.models.NoteUiStateModel

@Composable
fun AppScreen(
    modifier: Modifier = Modifier,
    noteViewModel: NoteViewModel = hiltViewModel(),
    openAddNoteScreen: () -> Unit,
    openNoteDetail: (id: Long) -> Unit
) {
    Scaffold(modifier = modifier, floatingActionButton = {
        FloatingActionButton(onClick = { openAddNoteScreen() }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "add new note FAB")
        }
    }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            val noteState by noteViewModel.noteState.collectAsStateWithLifecycle()

            AppContent(noteState, openNoteDetail)
        }
    }
}

@Composable
fun AppContent(
    noteState: NoteUiStateModel,
    openNoteDetail: (id: Long) -> Unit
) {
    when (noteState) {
        is NoteUiStateModel.Loading -> CircularProgressIndicator()
        is NoteUiStateModel.Empty -> EmptyNoteScreen()
        is NoteUiStateModel.Fetched -> NoteScreen(
            notes = noteState.list,
            openNoteDetail = openNoteDetail
        )
    }
}