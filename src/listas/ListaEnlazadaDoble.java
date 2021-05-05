/*
 * NodoDoblePrioridado change this license header, choose License Headers in Project Properties.
 * NodoDoblePrioridado change this template file, choose NodoDoblePrioridadools | NodoDoblePrioridademplates
 * and open the template in the editor.
 */
package listas;

import nodos.NodoDoblePrioridad;

/**
 *
 * @author ING-JUANMANodoDoblePrioridadA
 */
public class ListaEnlazadaDoble {

    protected NodoDoblePrioridad ini, fin;

    public ListaEnlazadaDoble() {
        ini = fin = null;
    }

    public boolean insertar(char dato, int prioridad) {
        if (ini == null) {
            ini = fin = new NodoDoblePrioridad(dato, prioridad);
            return true;
        }

        if (ini == fin) {
            fin = new NodoDoblePrioridad(dato, prioridad);
            ini.setSiguiente(fin);
            fin.setAnterior(ini);
            return true;
        }

        fin.setSiguiente(new NodoDoblePrioridad(dato, prioridad));
        fin.getSiguiente().setAnterior(fin);
        fin = fin.getSiguiente();
        return true;
    }

    public boolean eliminar() {
        if (fin == null) {
            return false;
        }

        if (ini == fin) {
            ini = fin = null;
            return true;
        }

        ini = ini.getSiguiente();
        ini.getAnterior().setSiguiente(null);
        ini.setAnterior(fin);
        return true;
    }

    @Override
    public String toString() {
        return mostrar(fin);
    }

    private String mostrar(NodoDoblePrioridad nodo) {
        if (nodo == ini) {
            return String.format("[%s] <- [%s] -> [%s]\n", nodo.getAnterior(), nodo, nodo.getSiguiente());
        }
        return mostrar(nodo.getAnterior()) + String.format("[%s] <- [%s] -> [%s]\n", nodo.getAnterior(), nodo, nodo.getSiguiente());
    }
}
