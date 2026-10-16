package com.ucaldas.aplicacion1

import com.ucaldas.aplicacion1.ui.theme.heroProfile
import org.junit.Assert.assertEquals
import org.junit.Test

class HeroProfileTest {

    @Test
    fun inteligenciaYCombate_esEstratega() {
        assertEquals("Estratega", heroProfile(listOf("Inteligencia superior", "Combate cuerpo a cuerpo")))
    }

    @Test
    fun estrategaTienePrioridadSobreEnergia() {
        assertEquals("Estratega", heroProfile(listOf("Inteligencia", "Combate", "Proyeccion de energia")))
    }

    @Test
    fun energia_esCosmico_conOSinTilde() {
        assertEquals("Cósmico", heroProfile(listOf("Manipulacion de energia")))
        assertEquals("Cósmico", heroProfile(listOf("Manipulación de energía")))
    }

    @Test
    fun velocidad_esVelocista() {
        assertEquals("Velocista", heroProfile(listOf("Super velocidad", "Super fuerza")))
    }

    @Test
    fun inteligenciaSinCombate_noEsEstratega() {
        assertEquals("Velocista", heroProfile(listOf("Inteligencia superior", "Super velocidad")))
    }

    @Test
    fun sinReglas_esTitan() {
        assertEquals("Titán", heroProfile(listOf("Super fuerza", "Regeneracion")))
        assertEquals("Titán", heroProfile(emptyList()))
    }

    @Test
    fun perfilesDeLaListaDePrueba() {
        val perfiles = listaNombres.associate { it.nombre to heroProfile(it.superPoderes) }
        assertEquals("Velocista", perfiles["Superman"])
        assertEquals("Estratega", perfiles["Batman"])
        assertEquals("Cósmico", perfiles["Iron Man"])
        assertEquals("Titán", perfiles["Hulk"])
    }

    @Test
    fun idsSonUnicos() {
        assertEquals(listaNombres.size, listaNombres.map { it.id }.toSet().size)
    }

    @Test
    fun rutaDetalleIncluyeId() {
        assertEquals("detalle/4", Utils.Rutas.detalle(4))
    }
}
