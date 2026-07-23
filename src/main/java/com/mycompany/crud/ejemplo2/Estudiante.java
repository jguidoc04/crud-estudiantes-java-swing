/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud.ejemplo2;

/**
 *
 * @author USER
 */
public class Estudiante {
 
    private int id;
    private String nombre;
    private String correo;
    private double promedio;
 
    public Estudiante() { }
 
    public Estudiante(String nombre, String correo, double promedio) {
        this.nombre = nombre;
        this.correo = correo;
        this.promedio = promedio;
    }
 
    public Estudiante(int id, String nombre, String correo, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.promedio = promedio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }
    
    
 
    // Getters y setters
    @Override
    public String toString() {
        return String.format("[%d] %s | %s | Promedio: %.2f", id, nombre, correo, promedio);
    }
}