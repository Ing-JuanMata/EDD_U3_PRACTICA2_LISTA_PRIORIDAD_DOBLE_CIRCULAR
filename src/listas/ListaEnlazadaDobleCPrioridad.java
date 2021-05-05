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
public class ListaEnlazadaDobleCPrioridad extends ListaEnlazadaDobleC {

    public ListaEnlazadaDobleCPrioridad() {
        super();
    }

    @Override
    public boolean insertar(char dato, int prioridad) {
        if (!super.insertar(dato, prioridad)) {
            return false;
        }
        if (fin.getPrioridad() == fin.getAnterior().getPrioridad()) {
            return true;
        }
        if (fin.getPrioridad() > ini.getPrioridad()) {
            fin = fin.getAnterior();
            ini = ini.getAnterior();
            return true;
        }

        NodoDoblePrioridad aux = fin.getAnterior();
        while (fin.getPrioridad() > aux.getPrioridad()) {
            aux = aux.getAnterior();
        }

        fin.setSiguiente(aux.getSiguiente());
        ini.setAnterior(fin.getAnterior());
        fin.getAnterior().setSiguiente(ini);
        fin.setAnterior(aux);
        aux.getSiguiente().setAnterior(fin);
        aux.setSiguiente(fin);
        fin = ini.getAnterior();
        return true;
    }
}
