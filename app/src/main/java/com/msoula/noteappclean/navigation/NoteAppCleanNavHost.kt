package com.msoula.noteappclean.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.msoula.noteappclean.core.di.navigation.AppScreenRoute
import com.msoula.noteappclean.core.di.navigation.Navigator
import com.msoula.noteappclean.core.di.navigation.NoteDetailScreenRoute
import com.msoula.noteappclean.core.di.navigation.NoteFormScreenRoute
import com.msoula.noteappclean.feature.addnote.presentation.AddNoteFormScreen
import com.msoula.noteappclean.feature.addnote.presentation.AddNoteViewModel
import com.msoula.noteappclean.feature.notedetail.presentation.NoteDetailScreen
import com.msoula.noteappclean.feature.notedetail.presentation.NoteDetailViewModel
import com.msoula.noteappclean.presentation.AppScreen
import com.msoula.noteappclean.presentation.AppViewModel

@Stable
@Composable
fun NoteAppCleanNavHost(
    navController: NavHostController,
    navigator: Navigator,
    appViewModel: AppViewModel = hiltViewModel()
) {
    NavHost(navController = navController, startDestination = AppScreenRoute.ROUTE) {
        composable(route = AppScreenRoute.ROUTE) {
            AppScreen(
                openAddNoteScreen = { navigator.navigate(NoteFormScreenRoute) },
                openNoteDetail = { id -> navigator.navigate(NoteDetailScreenRoute(id = id.toString())) }
            )
        }

        composable(route = NoteFormScreenRoute.ROUTE) {
            val addNoteViewModel = hiltViewModel<AddNoteViewModel>()
            val addNoteUiState by addNoteViewModel.addNoteState.collectAsStateWithLifecycle()

            AddNoteFormScreen(state = addNoteUiState, onUiEvent = addNoteViewModel::onUiEvent)
        }

        composable(route = NoteDetailScreenRoute.route) {
            val noteDetailViewModel = hiltViewModel<NoteDetailViewModel>()
            val noteDetailState by noteDetailViewModel.noteDetailState.collectAsStateWithLifecycle()

            NoteDetailScreen(state = noteDetailState)
        }
    }
}