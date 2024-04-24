package com.msoula.noteappclean.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.navigation.compose.rememberNavController
import com.msoula.noteappclean.core.di.navigation.Navigator
import com.msoula.noteappclean.navigation.NoteAppCleanNavHost

@Stable
@Composable
fun NoteAppCleanApp(navigator: Navigator) {
    val navController = rememberNavController()

    DisposableEffect(key1 = navController) {
        navigator.setController(navController)
        onDispose {
            navigator.clear()
        }
    }

    NoteAppCleanNavHost(navController = navController, navigator)
}