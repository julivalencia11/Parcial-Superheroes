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
class NavegacionTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun tocarHeroe_abreSuDetalle_yVolverRegresaALaLista() {
        composeRule.setContent { Aplicacion1Theme { AppNavigation() } }

        // Lista: abrir Iron Man (id 3), que no es el primer elemento
        composeRule.onNode(hasScrollAction()).performScrollToNode(hasText("Iron Man"))
        composeRule.onNodeWithText("Iron Man").performClick()

        // Detalle correcto: encabezado con el id y el perfil derivado
        composeRule.onNodeWithText("Heroe #3").assertExists()
        composeRule.onNodeWithText("Cósmico").assertExists()
        composeRule.onNodeWithText("Resumen tactico").assertExists()

        // Volver a la lista
        composeRule.onNode(hasScrollAction()).performScrollToNode(hasText("Volver a la lista"))
        composeRule.onNodeWithText("Volver a la lista").performClick()

        composeRule.onNodeWithText("Heroe #3").assertDoesNotExist()
        // La lista conserva su posicion de scroll, asi que la card de Iron Man sigue visible
        composeRule.onNodeWithText("ID: 3").assertExists()
    }
}
