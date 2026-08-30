package org.example;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Indica els artxius CSV a analitzar.");
            System.exit(0);
        }

        //Creem un pool amb tans fils com artxius
        ExecutorService executor = Executors.newFixedThreadPool(args.length);
        List<Future<Classe>> futurs = new ArrayList<>();

        for (String artxiu : args){
            futurs.add(executor.submit(new LectorClasse(artxiu)));
        }

        List<Classe> classes = new ArrayList<>();
        for (Future<Classe> futur : futurs){
            try{
                classes.add(futur.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // Genera el fitxer de sortida amb totes les mitjanes
        CalculMitjana.escriureResultats("resultats.csv", classes);

        // Tenca el pool de fils
        executor.shutdown();

        System.out.println("Archivo 'resultats.csv' generado correctamente.");
    }
}
