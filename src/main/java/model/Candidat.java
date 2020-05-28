package model;

import readwrite.write.Writer;

import java.util.Objects;

public class Candidat {
    private int id;

    private String nume;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Candidat{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                '}';
    }

    public Candidat(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return id == candidat.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
