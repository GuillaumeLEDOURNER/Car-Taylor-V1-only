package aco_tp2_impl;

import java.util.*;
import aco_tp2_api.*;

import aco_tp2_api.Category;
import aco_tp2_api.Configuration;
import aco_tp2_api.PartType;

public class ConfigurationImpl implements Configuration {
	
	Set <Part> conf;
	
	public ConfigurationImpl() {
		this.conf = new HashSet<>();
	}

	@Override
	public boolean isValid() {
		Set <PartType> obligatoire = new HashSet<>();
		Set <PartType> interdit = new HashSet<>();
		CompatibilityManagerImpl cm = new CompatibilityManagerImpl();
		Set <PartType> selectedPartType = new HashSet<>();
		for (Part pa : conf) { 
		obligatoire = cm.getRequirements(pa.getType());
				getSelectedParts().forEach( (p) -> selectedPartType.add(p.getType()));
			if(!selectedPartType.containsAll(obligatoire)) {
				return false;
			
			} 
			}
		for (Part pa : conf) { 
		interdit = cm.getIncompatibilities(pa.getType());
		}
			for (PartType p2 : interdit) {
			
				if (selectedPartType.contains(p2)){
					return false;
				}
			}
	
			return true;}
	

	@Override
	public boolean isComplete() {
		ConfiguratorImpl cg = new ConfiguratorImpl();
		Set<Category> setCat = cg.getCategories();
		Set<Category> setCatConf = new HashSet<>();
		for (Part p : conf) {
			setCatConf.add(p.getCategory());
		}
		for (Category c : setCat) {
			if (cg.findByNameCat(setCatConf,c.getName()) == null) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Set<Part> getSelectedParts() {
		Set<Part> copy = conf;
		return copy;
	}

	@Override
	public void selectPart(PartType chosenPart) {
		Objects.requireNonNull(chosenPart, "l'objet utilisé ne dois pas être nul");
		unselectPartType(chosenPart.getCategory());
		PartTypeImpl pt = (PartTypeImpl) chosenPart; 
		conf.add(pt.newInstance());
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
