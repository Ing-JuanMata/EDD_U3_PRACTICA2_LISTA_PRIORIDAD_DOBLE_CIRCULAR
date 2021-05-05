/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author ING-JUANMATA
 */
public class NodoDoblePrioridad {

    private NodoDoblePrioridad anterior;
    private NodoDoblePrioridad siguiente;
    private char dato;
    private int prioridad;

    public NodoDoblePrioridad(char dato, int prioridad) {
        this.anterior = this.siguiente = null;
        this.dato = dato;
        this.prioridad = prioridad;
    }

    public NodoDoblePrioridad getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoblePrioridad anterior) {
        this.anterior = anterior;
    }

    public NodoDoblePrioridad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoblePrioridad siguiente) {
        this.siguiente = siguiente;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "dato=" + dato + ", prioridad=" + prioridad;
    }

    
}
