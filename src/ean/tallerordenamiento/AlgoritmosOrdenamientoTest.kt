package ean.tallerordenamiento

import ean.collections.asLinkedList
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class AlgoritmosOrdenamientoTest {
    @Test
    fun mergeSort() {
        var lista = asLinkedList(5, 3, 11, 8, 70, 9, 4, 6)
        AlgoritmosOrdenamiento.bubbleSort(lista)
        println("Lista ordenada: ${lista}")
    }

}