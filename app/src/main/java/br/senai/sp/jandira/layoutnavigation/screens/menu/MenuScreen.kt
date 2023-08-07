package br.senai.sp.jandira.layoutnavigation.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun MenuScreen(navController: NavHostController) {


        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally){


            Text(
                text = "MENU",
                color = Color.White,
                fontSize = 22.sp)
            Button(
                onClick = { navController.navigate("perfil") },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = "PERFIL",
                    color = Color.Black
                )
            }
            Button(
                onClick = { navController.navigate("pedidos")},
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = "PEDIDOS",
                    color = Color.Black)
            }

            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(Color.White)) {
                Text(
                    text = "SAIR",
                    color = Color.Black
                )
            }
        }
    }


