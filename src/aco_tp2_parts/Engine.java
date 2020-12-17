package aco_tp2_parts;
import aco_tp2_impl.*;

import java.util.*;

public class Engine extends PartImpl{
	private String power;
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
		
		addProperty("power", ()->getPower(), (c)->setPower(c),  possibleValues);
	
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

 
	@Override
	public void accept(Visitor v) {
		v.visitEngine(this);
	}
	
	@Override
	public String getDescription() {
		return "Notre moteur est parmi les plus puissant  travers le monde";
	}


	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getCarburant() {
		return carburant.name();
	}

	public void setCarburant(String carburant) {
		
		this.carburant = Carburant.valueOf(carburant);
	}

	
}
