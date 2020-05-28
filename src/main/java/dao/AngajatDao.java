package dao;

import model.Angajat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AngajatDao {
    private Connection connection;

    private PreparedStatement updateStatement;
    private PreparedStatement addStatement;
    private PreparedStatement searchStatement;
    public AngajatDao(Connection connection) {
        this.connection = connection;

        try {

            updateStatement = connection.prepareStatement("UPDATE admin SET nume=? where id=?");
            addStatement = connection.prepareStatement("INSERT INTO admin (null,?)");
            searchStatement = connection.prepareStatement("SELECT * FROM admin WHERE nume=?");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean updateAngajat(Angajat angajatNou,Angajat angajatVechi){
        try {
            updateStatement.setString(1,angajatNou.getNume());
            updateStatement.setInt(2,angajatVechi.getId());
            return updateStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    public boolean adaugaAngajat(Angajat a){
        try {
            addStatement.setString(1,a.getNume());

            return addStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;

    }
    public boolean searchStatement(Angajat a){
        try {
            addStatement.setString(1,a.getNume());

            ResultSet rs = addStatement.getResultSet();

            if(rs.next()){
                return true;
            }else {
                return  false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


}
