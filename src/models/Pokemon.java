/*
 * Clase Pokemon
 */
package models;

/**
 *
 * @author dmorenoar
 */
public class Pokemon {
    private String nombre;
    private String tipo;
    private double fuerza;
    private Entrenador entrenador;

    public Pokemon() {}

    public Pokemon(String nombre, String tipo, double fuerza, Entrenador entrenador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = fuerza;
        this.entrenador = entrenador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }
    
    
    
}
