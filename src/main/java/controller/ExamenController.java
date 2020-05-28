package controller;

import dao.ExamenDao;
import model.Examen;

import java.util.List;

public class ExamenController {

    private static final class SingletonHolder {

        public static final ExamenController INSTANCE = new ExamenController();
    }
    private ExamenDao examenDao;
    private ExamenController(){
        examenDao = new ExamenDao(ConnectionManager.getInstance().getConnection());

    }

    public static ExamenController getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public List<Examen> findByCandidat(int candidatId){
        return examenDao.findByCandidat(candidatId);
    }

    public boolean create(Examen examen){
        return  examenDao.create(examen);
    }
}
