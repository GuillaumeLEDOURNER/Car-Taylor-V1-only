package aco_tp2_impl;

import aco_tp2_api.Category;
import aco_tp2_api.PartType;

public class PartTypeImpl implements PartType {

	String name;
	
	public PartTypeImpl(String n) {
		this.name = n;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Category getCategory() {
		// TODO Auto-generated method stub
		return null;
	}

}
