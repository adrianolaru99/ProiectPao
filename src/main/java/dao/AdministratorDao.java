package dao;

import model.Administrator;
import model.Angajat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdministratorDao {
    private Connection connection;

    private PreparedStatement createStatement;
    public AdministratorDao(Connection connection) {
        this.connection = connection;

        try {

            createStatement = connection.prepareStatement("INSERT INTO admin VALUES (null,?,?,?)");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public boolean createAdministrator(Administrator a){
        try {

            createStatement.setString(1,a.getNume());
            createStatement.setString(2,a.getUsername());
            createStatement.setString(3,a.getParola());
            return createStatement.executeUpdate()!=0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
