package aco_tp2_impl;

import java.util.*;

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
		Objects.requireNonNull(reference,"L'objet ne doit pas etre null");
		Set<PartType> concernedPart = require.get(reference);
		if (concernedPart == null) {
			return Collections.emptySet();
		}
		return concernedPart;
	}
	
	
	@Override
	public void addIncompatibilities(PartType reference, Set<PartType> target) {
		Objects.requireNonNull(reference, "L'objet ne doit pas �tre null");
		Objects.requireNonNull(target, "l'objet ne doit pas �tre nul");
		target.remove(reference); //evite de mettre un incompatibilities entre un element et lui-meme
		if (target.size() > 0 ) {
			Set<PartType> ancien = incomp.get(reference);
			if(ancien == (null)) { ancien = new HashSet<>();}
			ancien.addAll(target);
			incomp.put(reference, ancien);
			for (PartType p : ancien) {
				if(p.getCategory() != reference.getCategory()) {
				addIncompatibilities(reference,incomp.get(p));
			}
			}
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
		target.remove(reference); //evite de mettre un requierement entre un element et lui-meme
		if (target.size() > 0) {
			require.put(reference,target);
		}
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
}