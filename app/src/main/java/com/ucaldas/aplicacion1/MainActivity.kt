package com.ucaldas.aplicacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ucaldas.aplicacion1.ui.theme.Aplicacion1Theme
import com.ucaldas.aplicacion1.ui.theme.HeroCard
import com.ucaldas.aplicacion1.ui.theme.VillanosSection

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Aplicacion1Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = Utils.Rutas.LISTA,
            modifier = Modifier.safeDrawingPadding()
        ) {
            composable(Utils.Rutas.LISTA) {
                ListaSuperHeroes(
                    superheroes = listaNombres,
                    onVerDetalle = { id ->
                        navController.navigate(Utils.Rutas.detalle(id))
                    }
                )
            }

            composable(
                route = Utils.Rutas.DETALLE,
                arguments = listOf(navArgument("id") { type = NavType.IntType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getInt("id") ?: return@composable
                val hero = listaNombres.firstOrNull { it.id == id } ?: return@composable

                DetalleSuperHeroe(
                    hero = hero,
                    onVolver = { navController.popBackStack() }
                )
            }
        }
    }
}

@Composable
fun ListaSuperHeroes(
    superheroes: List<Nombres>,
    onVerDetalle: (Int) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(superheroes, key = { it.id }) { heroe ->
            HeroCard(
                hero = heroe,
                onClick = { onVerDetalle(heroe.id) }
            )
        }
    }
}

@Composable
fun DetalleSuperHeroe(
    hero: Nombres,
    onVolver: () -> Unit
) {
    var villanosVisibles by rememberSaveable(hero.id) { mutableStateOf(false) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            HeroCard(hero = hero, option = 1)
        }
        item {
            VillanosSection(
                villanos = hero.villanos,
                visibles = villanosVisibles,
                onToggle = { villanosVisibles = !villanosVisibles }
            )
        }
        item {
            Button(
                onClick = onVolver,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver a la lista")
            }
        }
    }
}
