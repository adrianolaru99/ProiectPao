package controller;

import dao.AdministratorDao;
import dao.AngajatDao;
import model.Administrator;
import model.Angajat;

import java.util.HashMap;
import java.util.Map;

public class AdministratorController {
    private Map<String,String> paroleUsername = new HashMap<>();
    private static final class SingletonHolder{

        public static final AdministratorController INSTANCE = new AdministratorController();

    } ;
    AdministratorDao administratorDao;
    private AdministratorController(){
        administratorDao = new AdministratorDao(ConnectionManager.getInstance().getConnection());
    }
    public boolean create(Administrator a){
        paroleUsername.put(a.getUsername(),a.getParola());
        return administratorDao.createAdministrator(a);
    }
    public boolean verificareUtilizator(Administrator a){
        if(paroleUsername.get(a.getUsername())==a.getParola()){
            return  true;
        }else {
            return false;
        }
    }
    public static AdministratorController getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
