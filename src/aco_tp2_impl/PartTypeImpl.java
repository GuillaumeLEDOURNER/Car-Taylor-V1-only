package aco_tp2_impl;

import aco_tp2_api.Category;
import aco_tp2_api.PartType;

public class PartTypeImpl implements PartType {

	String name;
	Category cat;
	
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

}
