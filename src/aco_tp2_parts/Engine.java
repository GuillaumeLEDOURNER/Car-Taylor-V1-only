package aco_tp2_parts;
import aco_tp2_impl.*;
import aco_tp2_api.*;

import java.util.*;

public class Engine extends PartImpl{
	private String pow;
	private Carburant carb;

	public Engine() {
		
		Set<String>  possibleValues ;

		/*  ajout des carburants */
		possibleValues =new HashSet<String>();
		possibleValues.add(Carburant.Diesel.name());
		possibleValues.add(Carburant.Essence.name());
		possibleValues.add(Carburant.Electrique.name());
		possibleValues.add(Carburant.Hybride.name());
		
		addProperty("carburant", ()->getCarburant(), (c)->setCarburant(c), possibleValues);
		
		/* power */
		possibleValues =new HashSet<String>();
		possibleValues.add("100kw");
		possibleValues.add("133kw");
		possibleValues.add("210kw");
		possibleValues.add("110kw");
		possibleValues.add("180kw");
		possibleValues.add("120kw");
		
		addProperty("pow", ()->getPower(), (c)->setPower(c),  possibleValues);
	
	}
	

	public int getPrice() {
		
		switch (carb) {
				
		case Essence: return 2500;
			
		case Diesel: return  1750;
	
		case Hybride:return 3000;

		case Electrique:return 4500;
		
		default: return 0;
			
		}
	}

 
	public void accept(Visitor v) {
		v.visitEngine(this);
	}
	
	public String getPower() {
		return pow;
	}

	public void setPower(String power) {
		this.pow = power;
	}

	public String getCarburant() {
		return carb.name();
	}

	public void setCarburant(String carburant) {
		
		this.carb = Carburant.valueOf(carburant);
	}

	public String getDescription() {
		return "Nos moteurs sont de bonne facture";
	}




	
}
