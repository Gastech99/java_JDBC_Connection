package com.objis.domaine;

import com.objis.service.IGestionConge;

public class Employe extends Personne implements IGestionConge {
    boolean mEst_directeur;

    public Employe(String nom, String prenom,   boolean est_directeur) {
        super(nom, prenom);
        this.mEst_directeur = est_directeur;
    }

    public boolean ismEst_directeur() {
        return mEst_directeur;
    }

    public void setmEst_directeur(boolean mEst_directeur) {
        this.mEst_directeur = mEst_directeur;
    }

    @Override
    public void afficherInfos() {
        System.out.println("Employé "+ getPrenom() + " "+ getNom() + mEst_directeur);
    }

    @Override
    public void poserConge(Conge conge) {
        System.out.println("L'employé "+ getPrenom() + " "+ getNom() + "emande un conge de "+ conge);
        System.out.println("Il attend la validation du directeur !");
    }
}
