package com.msoula.noteappclean.feature.addnote.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.msoula.noteappclean.feature.addnote.presentation.models.AddNoteFormEvent
import com.msoula.noteappclean.feature.addnote.presentation.models.AddNoteFormUiState

@Composable
fun AddNoteFormScreen(
    modifier: Modifier = Modifier,
    state: AddNoteFormUiState,
    onUiEvent: (event: AddNoteFormEvent) -> Unit
) {
    Scaffold(modifier = modifier) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = state.noteTitle,
                onValueChange = { onUiEvent(AddNoteFormEvent.OnTitleChanged(it)) },
                placeholder = { Text(text = "Title") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = state.noteDescription,
                onValueChange = { onUiEvent(AddNoteFormEvent.OnDescriptionChanged(it)) },
                placeholder = { Text(text = "Description") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onUiEvent(AddNoteFormEvent.OnSubmitNote) },
                enabled = state.enableSubmit
            ) {
                Text(
                    text = "ADD NOTE",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}