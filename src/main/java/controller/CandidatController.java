package controller;

import dao.CandidatDao;
import model.Candidat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CandidatController {

    private static final class SingletonHoder{

        public static final CandidatController INSTANCE = new CandidatController();
    }

    private CandidatDao candidatDao;
    private CandidatController(){
        candidatDao = new CandidatDao(ConnectionManager.getInstance().getConnection());
    }
    public static CandidatController getInstance(){

        return SingletonHoder.INSTANCE;
    }
    public List<Candidat> findAll(){
        return candidatDao.findAll();
    }
    public  boolean delete(int id){
        return  candidatDao.delete(id);
    }

    public boolean create(Candidat c){
        Optional<Candidat> candidatOptional = candidatDao.findByNume(c.getNume());

        if(candidatOptional.isEmpty()){
            return candidatDao.create(c);
        }else {
            return false;
        }
    }

}