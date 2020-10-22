package aco_tp2_impl;

import java.util.*;

import aco_tp2_api.Category;
import aco_tp2_api.Configuration;
import aco_tp2_api.PartType;

public class ConfigurationImpl implements Configuration {
	
	Set <PartType> conf;

	@Override
	public boolean isValid() {
		Set <PartType> obligatoire;
		CompatibilityManagerImpl cm = new CompatibilityManagerImpl();
		for (PartType p : conf) {
			obligatoire = cm.getRequirements(p);
			if(!conf.containsAll(obligatoire)) {
				return false;
			}
		}
		Set <PartType> interdit;
		for(PartType p : conf) {
			interdit = cm.getIncompatibilities(p);
			for (PartType p2 : interdit) {
				if (conf.contains(p2)){
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean isComplete() {
		ConfiguratorImpl cg = new ConfiguratorImpl();
		Set<Category> setCat = cg.getCategories();
		Set<Category> setCatConf = new HashSet<>();
		for (PartType p : conf) {
			setCatConf.add(p.getCategory());
		}
		return setCatConf.equals(setCat);
	}

	@Override
	public Set<PartType> getSelectedParts() {
		Set<PartType> copy = conf;
		return copy;
	}

	@Override
	public void selectPart(PartType chosenPart) {
		conf.add(chosenPart);
	}

	@Override
	public PartType getSelectionForCategory(Category category) {
		for (PartType p : conf) {
			if (p.getCategory().getName().equals(category.getName())) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void unselectPartType(Category categoryToClear) {
		for (PartType p : conf) {
			if (p.getCategory().getName().equals(categoryToClear.getName())) {
				conf.remove(p);
			}
		}
	}

	@Override
	public void clear() {
		conf.clear();
	}

}
