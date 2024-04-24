package com.msoula.noteappclean.feature.notedetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.msoula.noteappclean.feature.notedetail.presentation.models.NoteDetailUiState

@Composable
fun NoteDetailScreen(modifier: Modifier = Modifier, state: NoteDetailUiState) {
    Column(modifier = modifier) {
        Text(text = state.title, fontSize = 40.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = state.description, fontSize = 16.sp)
    }
}