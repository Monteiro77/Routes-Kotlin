package br.senai.sp.jandira.layoutnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.layoutnavigation.screens.login.LoginScreen
import br.senai.sp.jandira.layoutnavigation.screens.menu.MenuScreen
import br.senai.sp.jandira.layoutnavigation.screens.pedidos.PedidosScreen
import br.senai.sp.jandira.layoutnavigation.screens.perfil.PerfilScreen
import br.senai.sp.jandira.layoutnavigation.ui.theme.LayoutNavigationTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutNavigationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberAnimatedNavController()
                    AnimatedNavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            shrinkHorizontally(tween(2000)) +
                                    fadeOut(tween(2000)) +
                                    slideOutOfContainer(AnimatedContentScope.SlideDirection.Down, tween(2000))
                        },
                        enterTransition = {
                            expandVertically(tween(1000))
                        }
                    ){
                        composable(route = "login"){ LoginScreen(navController) }
                        composable(route = "menu"){ MenuScreen(navController) }
                        composable(route = "perfil"){ PerfilScreen(navController) }
                        composable(route = "pedidos"){ PedidosScreen(navController) }
                    }
                }

            }
        }
    }
}



