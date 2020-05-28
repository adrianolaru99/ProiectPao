package readwrite.read;

import model.Candidat;

import java.util.*;


public class CandidatReader extends Reader<Candidat>{
    private static List<Candidat> candidatList = new ArrayList<>();

    public static void readData(){
        CandidatReader candidatReader = new CandidatReader();

        candidatList = candidatReader.readAndCreateObjects("/Desktop/ProiectPao/src/main/java/readwrite/resources/Candidat.csv");

        for(Candidat candidat:candidatList){
            System.out.println(candidat);
        }


    }
    public static List<Candidat> getCandidatList(){
        return candidatList;
    }

    @Override
    Candidat createObject(String[] objectDetails) {
        return new Candidat(Integer.parseInt(objectDetails[0]),objectDetails[1]);
    }
}
