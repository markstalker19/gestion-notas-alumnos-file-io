package org.example;

import java.util.List;
//Clase Alumne
public class Alumne {
    private String nomAlumne;
    private List<Double> notes;

    //Metode constructor
    public Alumne(String nom,List<Double>notes){
        this.nomAlumne = nom;
        this.notes = notes;

    }

    //Getters
    public String getNomAlumne() {
        return nomAlumne;
    }

    //Metode per calcular la mitjana
    public double calcularMitjana () {
        return  notes.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }
}
