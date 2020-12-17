package aco_tp2_parts;

import java.util.*;
import java.util.Set;
import aco_tp2_api.*;
import aco_tp2_impl.*;


public class Interior extends PartImpl {


	// les proprietes qui sont encommun entre tous les part 
	// de type interior
	
	private InteriorType  typeInterior = InteriorType.Standart;

	public String gettypeInterior() {
		return typeInterior.name();
	}


	public void settypeInterior(String type) {
		this.typeInterior=InteriorType.valueOf(type);
	}


	public Interior() {
		Set<String> possibleValues ;
		possibleValues =new HashSet<String>();
		possibleValues.add(InteriorType.Haute_Gamme.name());
		possibleValues.add(InteriorType.Sport.name());
		possibleValues.add(InteriorType.Standart.name());
		
		addProperty("typeInterior", ()->gettypeInterior(), (c)->settypeInterior(c), possibleValues);
	}
	
	public int getPrice() {
		
		switch (typeInterior) {
		
		case Standart: return 399;
			
		case Haute_Gamme: return 650;
	
		case Sport:return 535;

		default: return 0;
			
		}
	}
	
	
	public void accept(Visitor v) {
		v.visitInterior(this);
	}
	
	
	public String getDescription() {
		return "Nos revêtements intérieurs sont cousus main";
	}

}
