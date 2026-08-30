package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class LectorClasse implements Callable<Classe> {
    private String rutaFitxer;
    //Metode constructor
    public LectorClasse(String ruta){
        this.rutaFitxer = ruta;
    }
    //Metode obligatori de la interficie
    public Classe call(){
        List<Alumne> alumnes = new ArrayList<>();
        //Logica BufferedReader per llegir el document
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFitxer))){
            String linea;
            br.readLine();
            while ((linea=br.readLine()) !=null){
                String[] parts = linea.split(";");
                String nom = parts[0];
                List<Double> notes = new ArrayList<>();

                for (int i = 1; i< parts.length;i++ ){
                    notes.add(Double.parseDouble(parts[i]));
                }
                alumnes.add(new Alumne(nom,notes));
            }
            System.out.println("Procesant: "+rutaFitxer);
        }catch(IOException e ){
            System.err.println("Error al llegir el artxiu "+rutaFitxer);

        }
        //Return per de callable per el Future
        return new Classe(alumnes, rutaFitxer);
    }
}
