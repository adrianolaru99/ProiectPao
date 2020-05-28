package model;

import java.util.Objects;

public class Examen {
    private int id;

    private int nota;

    private int candidatId;

    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", nota=" + nota +
                ", candidatId=" + candidatId +
                '}';
    }

    public Examen(int id, int nota, int candidatId) {
        this.id = id;
        this.nota = nota;
        this.candidatId = candidatId;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examen examen = (Examen) o;
        return id == examen.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(int candidatId) {
        this.candidatId = candidatId;
    }
}
