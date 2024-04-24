package com.msoula.noteappclean

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.msoula.noteappclean.app.NoteAppCleanApp
import com.msoula.noteappclean.core.di.navigation.Navigator
import com.msoula.noteappclean.ui.theme.NoteAppCleanTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppCleanTheme {
                NoteAppCleanApp(navigator)
            }
        }
    }
}