package aco_tp2_parts;
import aco_tp2_impl.*;
import aco_tp2_api.*;

import java.util.*;

public class Transmission extends PartImpl {
	
	private Trans transmission;
	private String embrayage;

	/**
	 * Constructeur de Transmission
	 **/
	public Transmission() {
		Set<String> possibleValues =new HashSet<String>();
		
		possibleValues.add(Trans.Automatique.name());
		possibleValues.add(Trans.Manuelle.name());
		possibleValues.add(Trans.Convertible.name());
		possibleValues.add(Trans.Sequentielle.name());
		
		addProperty("transmission", ()->getTrans(), (c)->setTrans(c), possibleValues);
	
		possibleValues =new HashSet<String>();
		possibleValues.add("7 gears");
		possibleValues.add("120 kw max");
		possibleValues.add("5 gears");
		possibleValues.add("6 gears");
		addProperty("embrayage", ()->getEmbrayage(), (c)->setEmbrayage(c), possibleValues);
	
	}
	
	public void accept(Visitor v) {
		v.visitTransmission(this);
	}
	
	public String getDescription() {
		return "Nos transmissions sont fabriquées à la main";
	}
	
	/**
	 * Met à jour le nouveau type de transmission
	 **/
	public void setTrans(String trans) {
		Trans newTrans = Trans.valueOf(trans);
		this.transmission = newTrans;
	}

	/**
	 * Met à jour le type d'embrayage
	 **/
	public void setEmbrayage(String emb) {
		this.embrayage=emb;
	}
	
	/**
	 * Retourne l'embrayage de la part
	 **/
	public String getEmbrayage() {
		return embrayage;
	}

	/**
	 * Retourne le type de transmission de la part
	 **/
	public String getTrans() {
		return transmission.name();
	}

	/**
	 * retourne le prix de la transmission, en fonction du type
	 **/
	public int getPrice() {
		if (transmission == Trans.Manuelle){
			return 150;
		} else if (transmission == Trans.Convertible){
			return 200;
		} else if (transmission == Trans.Automatique){
			return 250;
		} else if (transmission == Trans.Sequentielle){
			return 300;
		} else {
			return 0;		
		}
	}

}
