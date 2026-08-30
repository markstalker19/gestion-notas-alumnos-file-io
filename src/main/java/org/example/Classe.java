package org.example;

import java.util.List;
//Clase classe
public class Classe {
    private List<Alumne> alumnes;
    private double notaMitjana;
    private String nomClasse;
    //Metode constructor
    public Classe(List<Alumne>alumnes,String nomClasse){
        this.alumnes=alumnes;
        this.nomClasse = nomClasse;
        this.notaMitjana = calculMitjaClase();
    }
    //Metode calcul nota mitjana per classe
    public double calculMitjaClase (){
        return alumnes.stream().mapToDouble(Alumne::calcularMitjana).average().orElse(0.0);
    }
    //Metodes getters
    public List<Alumne> getAlumnes() {
        return alumnes;
    }

    public double getNotaMitjana() {
        return notaMitjana;
    }

    public String getNomClasse() {
        return nomClasse;
    }

}
