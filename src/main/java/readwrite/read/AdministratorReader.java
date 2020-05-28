package readwrite.read;

import model.Administrator;

import java.util.*;


public class AdministratorReader extends Reader<Administrator>{
    private static List<Administrator> administartorList = new ArrayList<>();

    public static void readData(){
        AdministratorReader administratorReader = new AdministratorReader();

        administartorList = administratorReader.readAndCreateObjects("/Desktop/ProiectPao/src/main/java/readwrite/resources/Administrator.csv");

        for(Administrator candidat:administartorList){
            System.out.println(candidat);
        }


    }
    public static List<Administrator> getAdministratorList(){
        return administartorList;
    }

    @Override
    Administrator createObject(String[] objectDetails) {
        return new Administrator(objectDetails[0],Integer.parseInt(objectDetails[1]),objectDetails[2],objectDetails[3]);
    }
}
