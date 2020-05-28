package dao;

import com.mysql.cj.jdbc.util.ResultSetUtil;
import model.Candidat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CandidatDao {

    public CandidatDao(Connection connection) {
        this.connection = connection;

        try {
            createStatement = connection.prepareStatement("INSERT INTO candidat VALUES (null, ?)");

            findAllStatement = connection.prepareStatement("SELECT * FROM candidat");

            findByNumeStatement = connection.prepareStatement("SELECT * FROM candidat WHERE nume = ?");

            deleteStatement = connection.prepareStatement("DELETE FROM candidat WHERE id = ?");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    private Connection connection;

    private PreparedStatement createStatement;
    private PreparedStatement findAllStatement;
    private PreparedStatement findByNumeStatement;
    private PreparedStatement deleteStatement;

    public boolean create(Candidat c){

        try {
            createStatement.setString(1,c.getNume());

            return createStatement.executeUpdate() !=0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public List<Candidat> findAll(){
        List<Candidat> candidati = new ArrayList<>();
        try {
           ResultSet rs =  findAllStatement.executeQuery();

           while (rs.next()){
               Candidat c = new Candidat(rs.getInt("id"),rs.getString("nume"));

               candidati.add(c);
           }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return candidati;
    }
    public Optional<Candidat> findByNume(String nume){
        try {
            findByNumeStatement.setString(1,nume);
            ResultSet rs = findByNumeStatement.executeQuery();

            if(rs.next()){
                return Optional.of(
                        new Candidat(rs.getInt("id"),rs.getString("nume")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return Optional.empty();
    }
    public boolean delete(int id){

        try {
            deleteStatement.setInt(1,id);

            return deleteStatement.executeUpdate() != 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
     return false;
    }
}
