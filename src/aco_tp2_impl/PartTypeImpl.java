package aco_tp2_impl;

import aco_tp2_api.Category;
import aco_tp2_api.PartType;

public class PartTypeImpl implements PartType {

	private String name;
	private Category cat;
	
	public PartTypeImpl(String n, Category c) {
		this.name = n;
		this.cat = c;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Category getCategory() {
		return cat;
	}
	@Override
	public boolean equals(PartType p) {
	    if (p == this) { 
	        return true; 
	    } 
	    if (!(p instanceof PartType)) { 
	        return false; 
	    } 

	    PartType c = (PartType) p; 

	    return (this.getName()==c.getName() && this.cat.getName()==c.getCategory().getName());
	}

	
	@Override
	public String toString() {
		return "name=" + name + ", "+ cat ;
	}
	
}
