package com.example.challenge_app.commons;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateClienteRequest {

    @NotBlank(message = "El nombre no puede ser nulo ni vacio")
    private String nombre;

    @NotBlank(message = "El apellido no puede ser nulo ni vacio")
    private String apellido;

    @NotNull(message = "Fecha de nacimiento no puede ser nulo")
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
