package aco_tp2_impl;

import aco_tp2_api.Category;

public class CategoryImpl implements Category {
	
	private String name;
	
	public CategoryImpl(String n) {
		this.name = n;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
