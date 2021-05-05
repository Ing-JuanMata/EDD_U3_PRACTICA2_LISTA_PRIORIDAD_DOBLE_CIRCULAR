/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import nodos.NodoDoblePrioridad;

/**
 *
 * @author ING-JUANMATA
 */
public class ListaEnlazadaDobleCP {

    protected NodoDoblePrioridad ini, fin;

    public ListaEnlazadaDobleCP() {
        ini = fin = null;
    }

    public boolean insertar(char dato, int prioridad) {
        if (ini == null) {
            ini = fin = new NodoDoblePrioridad(dato, prioridad);
            return true;
        }

        if (ini == fin) {
            if (prioridad > ini.getPrioridad()) {
                ini = new NodoDoblePrioridad(dato, prioridad);
            } else {
                fin = new NodoDoblePrioridad(dato, prioridad);
            }
            ini.setSiguiente(fin);
            ini.setAnterior(fin);
            fin.setSiguiente(ini);
            fin.setAnterior(ini);
            return true;
        }

        insertarCentro(dato, prioridad);
        return true;
    }

    private void insertarCentro(char dato, int prioridad) {
        NodoDoblePrioridad t = fin;
        NodoDoblePrioridad nuevo = new NodoDoblePrioridad(dato, prioridad);
        while (prioridad > t.getPrioridad()) {
            if (t.getAnterior() == fin) {
                nuevo.setAnterior(fin);
                nuevo.setSiguiente(ini);
                ini.setAnterior(nuevo);
                fin.setSiguiente(nuevo);
                ini = nuevo;
                return;
            }

            t = t.getAnterior();
        }

        nuevo.setAnterior(t);
        nuevo.setSiguiente(t.getSiguiente());
        t.getSiguiente().setAnterior(nuevo);
        t.setSiguiente(nuevo);
        fin = nuevo.getSiguiente() == ini ? nuevo : fin;
    }

    public boolean eliminar() {
        if (fin == null) {
            return false;
        }

        if (ini == fin) {
            ini = fin = null;
            return true;
        }

        ini.setAnterior(fin.getAnterior());
        fin.getAnterior().setSiguiente(ini);
        fin = fin.getAnterior();
        return true;
    }

    @Override
    public String toString() {
        return mostrar(fin);
    }

    private String mostrar(NodoDoblePrioridad nodo) {
        if (nodo == ini) {
            return ini + "\n";
        }
        return mostrar(nodo.getAnterior()) + nodo + "\n";
    }

}
