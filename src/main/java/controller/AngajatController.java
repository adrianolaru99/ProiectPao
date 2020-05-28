package controller;

import dao.AngajatDao;
import model.Administrator;
import model.Angajat;



public class AngajatController {
    private static final class SingletonHolder{

        public static final AngajatController INSTANCE = new AngajatController();

    } ;
    AngajatDao angajatDao;
    private AngajatController(){
        angajatDao = new AngajatDao(ConnectionManager.getInstance().getConnection());
    }
    public boolean create(Angajat a){
        return angajatDao.adaugaAngajat(a);
    }
    public boolean update(Angajat angajatNou,Angajat angajatVechi){
        return angajatDao.updateAngajat(angajatNou,angajatVechi);
    }
    public static AngajatController getInstance(){
        return AngajatController.SingletonHolder.INSTANCE;
    }
}
