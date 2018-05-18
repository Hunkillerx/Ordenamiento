/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Utils.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Ordenamiento
 * Autor: Universidad EAN - Mayo 18, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.tallerordenamiento

import ean.collections.IList

/**
 * Aquí vamos a implementar los diversos algoritmos de Ordenamiento que usaremos para
 * ordenar la lista de empleados
 */
object AlgoritmosOrdenamiento {

    /**
     * Algoritmo de Burbuja. Usar el ordenamiento natural del objeto
     * Complejidad: O(n^2)
     */
    fun <T: Comparable<T>> bubbleSort(a: IList<T>): Unit {
        val n = a.size
        for (i in 1..n) {
            for (j in 0 until n-1) {
                if (a[j] > a[j+1]) {
                    // Haga el swapping
                    val t = a[j]
                    a[j] = a[j+1]
                    a[j+1] = t
                }
            }
        }
    }

    /**
     * Algoritmo de Burbuja. Usar el ordenamiento natural del objeto
     * Complejidad: O(n^2)
     */
    fun <T> bubbleSort(a: IList<T>, c: Comparator<T>): Unit {
        val n = a.size
        for (i in 1..n) {
            for (j in 0 until n-1) {
                if (c.compare(a[j],a[j+1]) > 0) {

                    val t = a[j]
                    a[j] = a[j+1]
                    a[j+1] = t

                }
            }
        }
    }

    fun <T: Comparable<T>> selectionSort(a: IList<T>) {
        // Esta función encuentra la posición del menor, desde pos en adelante
        fun findPositionMinElem(pos: Int): Int {
            return 0
        }
        //-----------------------------------
        for (i in 0 until a.size-1) {
            val m = findPositionMinElem(i)
            if (i != m) {
                TODO("Swap posición i y m de a")
            }
        }
    }

    fun <T> selectionSort(a: IList<T>, c: Comparator<T>) {
        // Esta función encuentra la posición del menor elemento desde pos, hasta el final de la lista
        fun findPositionMinElem(pos: Int): Int {
            return 0
        }
        //-----------------------------------
        for (i in 0 until a.size-1) {
            val m = findPositionMinElem(i)
            if (i != m) {
                TODO("Swap a[i] y a[m]")
            }
        }
    }

    fun <T: Comparable<T>> insertionSort(a: IList<T>) {
        TODO("Por hacer!")
    }

    fun <T> insertionSort(a: IList<T>, c:  Comparator<T>) {
        TODO("Por hacer!")
    }

    fun <T: Comparable<T>> mergeSort(a: IList<T>) {
        /**
         * Obtiene los elementos de la lista ubicados en la mitad inferior de la misma
         * es decir, en las posiciones desde la cero hasta la mitad de la lista
         */
        fun obtenerMitadInferior(lista: IList<T>): IList<T> {
            TODO("Completar")
        }

        /**
         * Obtiene los elementos de la lista ubicados en la mitad superior de la misma
         * es decir, en las posiciones desde la mitad + 1 hasta el final de la lista
         */
        fun obtenerMitadSuperior(lista: IList<T>): IList<T> {
            TODO("Completar")
        }

        /**
         * Retorna la mezcla ordenada de las listas a y b
         */
        fun mezclarListas(a: IList<T>, b: IList<T>): IList<T> {
            TODO("Completar!")
        }

        //------------------------------------------------------------------------------
        // Función Principal del MergeSort
        //------------------------------------------------------------------------------
        if (a.size >= 2) {
            if (a.size == 2) {
                if (a[0] > a[1]) {
                    TODO("Completar: intercambie los elementos a[0] y a[1]")
                }
            }
            else {
                // Algoritmo MergeSort.

                // 1. Particione la lista en dos mitades
                val p: IList<T> = obtenerMitadInferior(a)
                val q: IList<T> = obtenerMitadSuperior(a)

                // 2. ordene cada mitad usando mergesort
                mergeSort(p)
                mergeSort(q)

                // 3. Mezcle las dos listas ordenadas y copielas a la lista de resultado
                val resultado = mezclarListas(p, q)
                a.clear()
                a.addAll(resultado)
            }
        }
    }

    fun <T> mergeSort(a: IList<T>, c: Comparator<T>) {
        TODO("Por hacer!")
    }

    fun <T: Comparable<T>> quickSort(a: IList<T>) {
        /**
         * Obtener los elementos inferiores al pivote de la lista a
         */
        fun menoresAlPivote(a: IList<T>, pivote: T): IList<T> {
            TODO("Completar!!")
        }

        /**
         * Obtener los elementos superiores al pivote en la lista
         */
        fun mayoresAlPivote(a: IList<T>, pivote: T): IList<T> {
            TODO("Completar!!")
        }

        //-----------------------------------------------------------------
        // Función Principal
        //-----------------------------------------------------------------
        if (a.size >= 2) {
            if (a.size == 2) {
                if (a[0] > a[1]) {
                    TODO("Completar: intercambie los elementos a[0] y a[1]")
                }
            }
            else {
                // Algoritmo QuickSort

                // 1. Obtener el pivote, en este caso puede ser el primer elemento
                val pivote = a[0]

                // 2. Obtener los menores y los mayores al pivote
                val mayores = mayoresAlPivote(a, pivote)
                val menores = menoresAlPivote(a, pivote)

                // 3. Ordene estas dos ultimas listas usando el quicksort
                quickSort(mayores)
                quickSort(menores)

                // 4. Ahora pegamos los pedazos junto con el pivote
                a.clear()
                a.addAll(menores)
                a.add(pivote)
                a.addAll(mayores)
            }
        }
    }

    fun <T> quickSort(a: IList<T>, c: Comparator<T>) {
        TODO("Por hacer!")
    }

    /**
     * Obtiene el comparador adecuado al parametro
     * Hay que finalizar el método en cuestión!
     */
    fun obtenerComparador(opcion: Int): Comparator<Empleado>? =
        when (opcion) {
            -1 -> compareByDescending { it.codigo }
            1 -> compareBy { it.nombre }
            3 -> compareBy( { it.apellido }, { it.nombre } )
            else -> null
        }

}
