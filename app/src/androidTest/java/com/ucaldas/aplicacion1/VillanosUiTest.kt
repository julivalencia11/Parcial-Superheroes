package com.ucaldas.aplicacion1

import androidx.compose.ui.test.hasScrollAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.ucaldas.aplicacion1.ui.theme.Aplicacion1Theme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VillanosUiTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun revelarYOcultarVillanos() {
        val batman = listaNombres.first { it.nombre == "Batman" }
        composeRule.setContent {
            Aplicacion1Theme { DetalleSuperHeroe(hero = batman, onVolver = {}) }
        }

        // Ocultos al entrar
        composeRule.onNodeWithText("Joker").assertDoesNotExist()

        composeRule.onNode(hasScrollAction()).performScrollToNode(hasText("Revelar villanos"))
        composeRule.onNodeWithText("Revelar villanos").performClick()

        composeRule.onNode(hasScrollAction()).performScrollToNode(hasText("Joker"))
        composeRule.onNodeWithText("Joker").assertExists()
        composeRule.onNodeWithText("Bane").assertExists()

        composeRule.onNode(hasScrollAction()).performScrollToNode(hasText("Ocultar villanos"))
        composeRule.onNodeWithText("Ocultar villanos").performClick()
        composeRule.onNodeWithText("Joker").assertDoesNotExist()
    }

    @Test
    fun heroeSinVillanos_muestraEstadoVacio() {
        val sinVillanos = listaNombres.first().copy(villanos = emptyList())
        composeRule.setContent {
            Aplicacion1Theme { DetalleSuperHeroe(hero = sinVillanos, onVolver = {}) }
        }

        composeRule.onNode(hasScrollAction()).performScrollToNode(hasText("Revelar villanos"))
        composeRule.onNodeWithText("Revelar villanos").performClick()

        composeRule.onNode(hasScrollAction())
            .performScrollToNode(hasText("Este heroe no tiene villanos registrados."))
        composeRule.onNodeWithText("Este heroe no tiene villanos registrados.").assertExists()
    }
}
