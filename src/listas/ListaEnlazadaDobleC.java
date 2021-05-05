/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author ING-JUANMATA
 */
public class ListaEnlazadaDobleC extends ListaEnlazadaDoble {

    public ListaEnlazadaDobleC() {
        super();
    }

    @Override
    public boolean insertar(char dato, int prioridad) {
        if (super.insertar(dato, prioridad)) {
            fin.setSiguiente(ini);
            ini.setAnterior(fin);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar() {
        if (super.eliminar() && fin != null) {
            fin.getSiguiente().setAnterior(null);
            fin.setSiguiente(ini);
            return true;
        }

        return false;
    }
}
