package dao;

import model.Examen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamenDao {
    private Connection connection;

    private PreparedStatement createStatement;
    private PreparedStatement findByCandidatStatement;


    public ExamenDao(Connection connection) {
        this.connection = connection;
        try {
            createStatement = connection.prepareStatement("INSERT INTO examen VALUES (null, ?, ?)");

            findByCandidatStatement = connection.prepareStatement("SELECT * FROM examen WHERE candidat_id =?");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean create(Examen examen){

        try {

            createStatement.setInt(1,examen.getNota());
            createStatement.setInt(2,examen.getCandidatId());
            return  createStatement.executeUpdate() !=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public List<Examen> findByCandidat(int candidatId){
            List<Examen> examene = new ArrayList<>();

        try {
            findByCandidatStatement.setInt(1,candidatId);
            ResultSet rs = findByCandidatStatement.executeQuery();

            while (rs.next()){

                Examen e = new Examen(rs.getInt("id"),
                            rs.getInt("nota"),
                            rs.getInt("candidat_id")
                        );

                examene.add(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return examene;

    }
}
