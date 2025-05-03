package com.example.challenge_app.commons;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ClienteResponse {

    private String nombre;

    private String apellido;

    private int edad;

    private final Map<String, Object> informacionExtra = new HashMap<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
    private LocalDate fechaNacimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Map<String, Object> getInformacionExtra() {
        return informacionExtra;
    }

    @Override
    public String toString() {
        return "ClienteResponse{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", informacionExtra=" + informacionExtra +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
