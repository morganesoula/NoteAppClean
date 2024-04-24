package com.msoula.noteappclean.feature.notes.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msoula.noteappclean.feature.notes.presentation.components.NoteItem
import com.msoula.noteappclean.feature.notes.presentation.models.NoteUiModel

@Composable
fun NoteScreen(
    modifier: Modifier = Modifier,
    notes: List<NoteUiModel>,
    openNoteDetail: (id: Long) -> Unit
) {
    Column(modifier.fillMaxSize()) {
        Text(
            text = "Welcome to NoteApp - Clean Version",
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(
                items = notes
            ) { note ->
                NoteItem(title = note.title, id = note.id, openNoteDetail = openNoteDetail)
            }
        }
    }
}

@Composable
fun EmptyNoteScreen(modifier: Modifier = Modifier) {
    Text(modifier = modifier, text = "No data found")
}