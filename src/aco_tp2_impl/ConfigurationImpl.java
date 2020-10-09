package aco_tp2_impl;

import java.util.Set;

import aco_tp2_api.Category;
import aco_tp2_api.Configuration;
import aco_tp2_api.PartType;

public class ConfigurationImpl implements Configuration {

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<PartType> getSelectedParts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectPart(PartType chosenPart) {
		// TODO Auto-generated method stub

	}

	@Override
	public PartType getSelectionForCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unselectPartType(Category categoryToClear) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
