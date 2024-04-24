package com.msoula.noteappclean.feature.notes.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NoteItem(
    modifier: Modifier = Modifier,
    title: String,
    id: Long,
    openNoteDetail: (id: Long) -> Unit
) {
    Card(
        modifier
            .fillMaxWidth()
            .height(50.dp)
            .clickable {
                openNoteDetail(id)
            }
    ) {
        Text(
            text = title, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )
    }

    Spacer(modifier = modifier.height(16.dp))
}