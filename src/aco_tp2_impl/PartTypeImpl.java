package aco_tp2_impl;


import aco_tp2_api.*;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;

import aco_tp2_api.Category;
import aco_tp2_api.PartType;

public class PartTypeImpl implements PartType {
	private String name;
	private Class<? extends PartImpl> classRef;
	private Category category;
	public PartTypeImpl(String name, Class<? extends PartImpl> classRef, Category category) {
		this.name = name;
		this.classRef = classRef;
		this.category = category;
	}
public PartTypeImpl(String name, Category cat) {
	this.name = name;
	this.category = cat;
	}
public PartImpl newInstance() {
		Constructor<? extends PartImpl> constructor;
		try {
			constructor = classRef.getConstructor();
			return constructor.newInstance();
		} catch (Exception e) {
			Logger.getGlobal().log(Level.SEVERE, "constructor call failed", e);
			System.exit(-1);
		}
		return null;
	}
@Override
public String getName() {
	// TODO Auto-generated method stub
	return this.name;
}
@Override
public Category getCategory() {
	// TODO Auto-generated method stub
	return this.category;
}
}