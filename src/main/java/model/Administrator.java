package model;

public class Administrator extends Angajat{
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Administrator(String nume, int id, String username,String parola) {
        super(nume, id);
        this.username = username;
        this.parola = parola;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    private String parola;

}
