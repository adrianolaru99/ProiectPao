package readwrite.read;


import model.Examen;

import java.util.ArrayList;
import java.util.List;

public class ExamenReader extends Reader<Examen> {
    private static List<Examen> examenList = new ArrayList<>();

    private static void readData(){
        ExamenReader examenReader = new ExamenReader();

        examenList = examenReader.readAndCreateObjects("/Desktop/ProiectPao/src/main/java/readwrite/resources/Examen.csv");

        for(Examen examen:examenList) {
            System.out.println(examen);
        }
    }
    public static List<Examen> getExamenList(){
        return examenList;
    }
    @Override
    Examen createObject(String[] objectDetails) {
        return new Examen(Integer.parseInt(objectDetails[0]),Integer.parseInt(objectDetails[1]),Integer.parseInt(objectDetails[2]));
    }
}
