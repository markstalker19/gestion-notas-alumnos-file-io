package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class CalculMitjana {

    private static final DecimalFormat formate = new DecimalFormat("0.00");
    //Metode per donar el format corresponent als numeros
    private static String formatCorresponent(double numero){
        return formate.format(numero);
    }

    public static void escriureResultats(String ruta, List<Classe> clases){
        double suma = 0;
        int contador = 0;
        //Logica bufferedWriter per escriure el document amb el format desitjat
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))){
            bw.write("Classe;Alumne;Mitjana Alumne\n");

            for(Classe c : clases){
                for (Alumne a : c.getAlumnes()){
                    bw.write(c.getNomClasse()+ ";" +
                            a.getNomAlumne()+ ";" +
                            formatCorresponent(a.calcularMitjana())+ "\n");
                }
                bw.write(c.getNomClasse() + ";MITJANA CLASSE;" +
                        formatCorresponent(c.getNotaMitjana()) + "\n\n");

                //Acumulem per calcular la mitjana
                suma+=c.getNotaMitjana();
                contador++;
            }
            double mitjanaCentre = suma / contador;
            bw.write("TOTAL;MITJANA CENTRE;" + formatCorresponent(mitjanaCentre)+ "\n");
        } catch (IOException e) {
            System.err.println("ERROR AL ESCRIURE");
        }
    }
}
