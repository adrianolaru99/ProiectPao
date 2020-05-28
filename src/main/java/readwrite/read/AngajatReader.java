package readwrite.read;

import model.Angajat;


import java.util.ArrayList;
import java.util.List;

public class AngajatReader  extends Reader<Angajat>{
    private static List<Angajat> angajatList = new ArrayList<>();

    public static void readData(){
        AngajatReader angajatReader = new AngajatReader();

        angajatList = angajatReader.readAndCreateObjects("Desktop/ProiectPao/src/main/java/readwrite/resources/Angajat.csv");
    }
    public static List<Angajat> getAngajatList(){
        return angajatList;
    }
    @Override
    Angajat createObject(String[] objectDetails) {
        return new Angajat(objectDetails[0],Integer.parseInt(objectDetails[1]));
    }
}
