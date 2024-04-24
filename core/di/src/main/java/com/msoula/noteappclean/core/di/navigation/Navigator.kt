package com.msoula.noteappclean.core.di.navigation

import androidx.navigation.NavController

interface Navigator {
    fun setController(navController: NavController)
    fun navigate(route: NavigationRoute)
    fun popBackStack()
    fun clear()
}