package aco_tp2_impl;

import aco_tp2_api.Category;


public class CategoryImpl implements Category {
	
	@Override
	public String toString() {
		return "cat=" + name;
	}

	private String name;
	
	public CategoryImpl(String n) {
		this.name = n;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Category c) {
		return this.name.equals(c.getName());
	}

	
	
}
