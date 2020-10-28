package aco_tp2_impl;

import java.util.*;
import java.util.Set;

import aco_tp2_api.CompatibilityManager;
import aco_tp2_api.PartType;

public class CompatibilityManagerImpl implements CompatibilityManager {
	
	Map<PartType,Set<PartType>> incomp;
	Map<PartType,Set<PartType>> require;
	
	public CompatibilityManagerImpl() {
		incomp = new HashMap<>();
		require = new HashMap<>();
	}
	@Override
	public Set<PartType> getIncompatibilities(PartType reference) {
		return incomp.get(reference);


	}

	@Override
	public Set<PartType> getRequirements(PartType reference) {
		Set<PartType> concernedPart = require.get(reference);
		getRequirementsAux(concernedPart);
	 // faire une auxiliaire qui fait la boucle
		for(PartType p : concernedPart) {
			if(concernedPart.addAll(require.get(p))) {
				
				getRequirements(require.get(p));
			}
		}
		
		
		return null;
		
	}

	
	public Set<PartType> getRequirementsAux(Set<PartType> concerned){
		for (PartType p : concerned) {
			if(concernedPart.addAll(require.get(p))) {
				getRequirementAux(require.get(p))
			}
		}
	}
	@Override
	public void addIncompatibilities(PartType reference, Set<PartType> target) {
		Set<PartType> ancien = incomp.get(reference);
		ancien.addAll(target);
		incomp.put(reference, ancien);
		
		for (PartType p : ancien) {
			addIncompatibilities(reference,incomp.get(p));
		}		
	}

	@Override
	public void removeIncompatibility(PartType reference, PartType target) {
		Set<PartType> concernedPart = incomp.get(reference);
		Set<PartType> otherPart = incomp.get(target);
		for (PartType p : concernedPart) {
			if (p.getName().equals(target.getName())) {
				concernedPart.remove(target);
				otherPart.remove(reference);				
			}
		}
		incomp.put(reference,concernedPart);
		incomp.put(target,otherPart);
	}

	@Override
	public void addRequirements(PartType reference, Set<PartType> target) {
		require.put(reference,target);

	}

	@Override
	public void removeRequirement(PartType reference, PartType target) {
		Set<PartType> concernedPart = require.get(reference);
		for (PartType p : concernedPart) {
			if (p.getName().equals(target.getName())) {
				concernedPart.remove(target);
			}
		}
		require.put(reference,concernedPart);
	}

	

}}}
}