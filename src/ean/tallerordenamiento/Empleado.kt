/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Utils.java,v 1.0 2017/02/17 08:09 lacobo Exp $
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas - Facultad de Ingeniería
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Ejercicio: Personas
 * Autor: Luis Cobo - Nov 1, 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package ean.tallerordenamiento

/**
 * Clase que representa la información de los diversos empleados de una empresa
 */
open class Empleado: Comparable<Empleado> {
    //------------------------------------------------------------------------
    // Atributos
    //------------------------------------------------------------------------
    var codigo: Int = 0
    var nombre: String = ""
    var apellido: String = ""
    var departamento: String = ""
    var cargo: String = ""
    var edad: Int = 0
    var sueldo: Double = 0.0

    //-------------------------------------------------------------------------
    // Constructor por defecto
    //-------------------------------------------------------------------------
    constructor()

    /**
     * Comparador que tiene en cuenta el orden natural de los empleados. En este
     * caso el criterio de comparación será el código del empleado
     */
    override fun compareTo(otro: Empleado): Int {
        return compareValues(this.codigo, otro.codigo)
    }
}

/**
 * Este comparador permitirà comparar dos empleados basado en el nombre
 * de los mismos.
 */
object ComparadorPorNombre: Comparator<Empleado> {

    /**
     * Retorna 1 si el nombre de a es mayor que el de b
     * Retorna 0 si ambos nombres son iguales
     * Retorna -1 si el nombre de a es menor que el de b
     */
    override fun compare(a: Empleado?, b: Empleado?): Int {
        if (a != null && b != null) {
            return compareValues(a.nombre, b.nombre)
        }
        return 0  // Son iguales si ambos son null
    }

}