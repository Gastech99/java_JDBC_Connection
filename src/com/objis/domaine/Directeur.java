package com.objis.domaine;

import com.objis.service.IGestionConge;

import java.util.List;

public class Directeur extends Personne implements IGestionConge {

    private List<Employe> listEmploye;

    public Directeur(String nom, String prenom, List<Employe> listEmploye) {
        super(nom, prenom);
        this.listEmploye = listEmploye;
    }

    public void ajouterEmploye(Employe e){
        listEmploye.add(e);
    }

    public List<Employe> getListEmploye() {
        return listEmploye;
    }

    @Override
    public void afficherInfos() {
        System.out.println("Directeur "+ getPrenom()+ " "+ getNom());
        System.out.println("Liste des employé");
        for (Employe e: listEmploye){
            System.out.println("Employe "+ e.getPrenom()+ " "+ e.getNom());
        }
    }

    @Override
    public void poserConge(Conge conge) {
        System.out.println("Le directeur "+ getPrenom()+ " "+ getNom()+ "prend un conge "+ conge);
        System.out.println("Le congé est automatiquement validé!");
    }
}
