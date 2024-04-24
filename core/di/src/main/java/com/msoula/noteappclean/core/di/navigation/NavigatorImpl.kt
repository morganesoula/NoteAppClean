package com.msoula.noteappclean.core.di.navigation

import androidx.navigation.NavController
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : Navigator {
    private var navController: NavController? = null

    override fun setController(navController: NavController) {
        this.navController = navController
    }

    override fun navigate(route: NavigationRoute) {
        navController?.navigate(route.buildRoute())
    }

    override fun popBackStack() {
        navController?.popBackStack()
    }

    override fun clear() {
        navController = null
    }
}