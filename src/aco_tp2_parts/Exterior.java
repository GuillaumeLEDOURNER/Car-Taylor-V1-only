package aco_tp2_parts;
import aco_tp2_impl.*;
import aco_tp2_api.*;

import java.util.*;

public class Exterior extends PartImpl {
	
	private Couleur couleurPeinture;


	public Exterior() {
		
		Set<String> valeursPossibles ;
		valeursPossibles = new HashSet<String>();
		valeursPossibles.add(Couleur.Rouge.name());
		valeursPossibles.add(Couleur.Bleu.name());
		valeursPossibles.add(Couleur.Rose.name());
		valeursPossibles.add(Couleur.Turquoise.name());
		valeursPossibles.add(Couleur.Turquoise.name());
		valeursPossibles.add(Couleur.Noir.name());
		valeursPossibles.add(Couleur.Vert.name());
		valeursPossibles.add(Couleur.Gris.name());
		valeursPossibles.add(Couleur.Jaune.name());
		valeursPossibles.add(Couleur.Or.name());
		valeursPossibles.add(Couleur.Argent.name());
		addProperty("color", ()->getCouleur(), (c)->setCouleur(c), valeursPossibles);
	}
	
	public String getCouleur() {
		return couleurPeinture.name();
	}


	public void setCouleur(String couleur) {
		Couleur newCouleur = Couleur.valueOf(couleur);
		this.couleurPeinture = newCouleur;
	}
	
	public int getPrice() {
		if (couleurPeinture == Couleur.Rouge) {
			return 100;
		} else if (couleurPeinture == Couleur.Bleu) {
			return 100;
		} else if (couleurPeinture == Couleur.Rose) {
			return 100;
		} else if (couleurPeinture == Couleur.Turquoise) {
			return 100;
		} else if (couleurPeinture == Couleur.Marron) {
			return 100;
		} else if (couleurPeinture == Couleur.Noir) {
			return 90;
		} else if (couleurPeinture == Couleur.Vert) {
			return 100;
		} else if (couleurPeinture == Couleur.Gris) {
			return 100;
		} else if (couleurPeinture == Couleur.Jaune) {
			return 100;
		} else if (couleurPeinture == Couleur.Or) {
			return 150;
		} else if (couleurPeinture == Couleur.Argent) {
			return 130;
		} else {
			return 0;
		}
	}


	public void accept(Visitor v) {
		v.visitExterior(this);
	}
	
	public String getDescription() {
		return "Chez nous vous trouverez toutes les couleurs de l'arc-en-ciel";
	}
}
