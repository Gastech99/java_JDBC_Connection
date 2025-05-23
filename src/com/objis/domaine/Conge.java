package com.objis.domaine;

public class Conge {

    private String dateDebut;
    private String dateFin;

    public Conge(String dateDebut, String dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "Conge{" +
                "dateDebut='" + dateDebut + '\'' +
                ", dateFin='" + dateFin + '\'' +
                '}';
    }
}
