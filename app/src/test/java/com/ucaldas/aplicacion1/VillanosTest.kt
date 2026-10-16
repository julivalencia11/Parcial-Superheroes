package com.ucaldas.aplicacion1

import org.junit.Assert.assertTrue
import org.junit.Test

class VillanosTest {

    @Test
    fun cadaHeroeTieneEntreDosYTresVillanos() {
        listaNombres.forEach { heroe ->
            assertTrue("${heroe.nombre}: ${heroe.villanos.size}", heroe.villanos.size in 2..3)
        }
    }

    @Test
    fun villanosSinTextosVacios() {
        listaNombres.flatMap { it.villanos }.forEach { villano ->
            assertTrue(villano.nombre.isNotBlank())
            assertTrue(villano.alias.isNotBlank())
            assertTrue(villano.descripcion.isNotBlank())
        }
    }

    @Test
    fun heroeSinVillanos_usaListaVaciaPorDefecto() {
        val heroe = Nombres(99, "Prueba", "", "Sin villanos", listOf("Vuelo"))
        assertTrue(heroe.villanos.isEmpty())
    }
}
