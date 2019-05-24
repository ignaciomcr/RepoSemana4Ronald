package com.example.reposemana4ronald.Models;

import java.io.Serializable;

//Serializable nos permite enviar estos objetos entre fragments.
public class Persona implements Serializable {
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;

    //Constructores. Ojo, clic de derecho en nombre de la clase / Generation / Constructor
    public Persona(String name, String lastName, String email, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    //Clic derecho en Clase / Generar / Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}





