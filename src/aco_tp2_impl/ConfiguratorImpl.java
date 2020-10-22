package aco_tp2_impl;

import java.util.HashSet;
import java.util.Set;

import aco_tp2_api.Category;
import aco_tp2_api.CompatibilityChecker;
import aco_tp2_api.Configuration;
import aco_tp2_api.Configurator;
import aco_tp2_api.PartType;

public class ConfiguratorImpl implements Configurator {
	
	Set <Category> categories;
	
	public ConfiguratorImpl() {
		this.categories = new HashSet<>();
	}

	@Override
	public Set<Category> getCategories() {
		Set<Category> copy = categories;
		return copy;
	}

	@Override
	public Set<PartType> getVariants(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Configuration getConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompatibilityChecker getCompatibilityChecker() {
		// TODO Auto-generated method stub
		return null;
	}

}
