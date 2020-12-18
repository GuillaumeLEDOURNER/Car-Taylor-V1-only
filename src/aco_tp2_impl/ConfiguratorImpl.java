package aco_tp2_impl;

import java.util.*;

import aco_tp2_api.Category;
import aco_tp2_api.CompatibilityChecker;
import aco_tp2_api.Configuration;
import aco_tp2_api.Configurator;
import aco_tp2_api.PartType;

public class ConfiguratorImpl implements Configurator {
	
	private HashMap <Category,Set<PartType>> map;
	private ConfigurationImpl conf;
	private CompatibilityManagerImpl compMan;
	
	public ConfiguratorImpl() {
		conf = new ConfigurationImpl();
		compMan = new CompatibilityManagerImpl();
		
		initialization();	
	}

	@Override
	public Set<Category> getCategories(){
		return map.keySet();
	}

	@Override
	public Set<PartType> getVariants(Category category) {
		return map.get(category);
	}

	@Override
	public Configuration getConfiguration() {
		return conf;
	}

	@Override
	public CompatibilityChecker getCompatibilityChecker() {
		return compMan;
	}
	
	/**
	 * initialisation des tous les parttype ainsi que de leur requirement et incompatibilities
	 */
	private void initialization() {
		map = new HashMap<>();
		
		//Creation des Category
		Category engine = new CategoryImpl("engine");
		Category trans = new CategoryImpl("trans");
		Category ext = new CategoryImpl("ext");
		Category inte = new CategoryImpl("interieur");
		
		//Creations des PartType engine
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType eg133 = new PartTypeImpl("eg133", engine);
		PartType eg210 = new PartTypeImpl("eg210", engine);
		PartType ed110 = new PartTypeImpl("ed110", engine);
		PartType ed180 = new PartTypeImpl("ed180", engine);
		PartType eh120 = new PartTypeImpl("eh120", engine);
		
		//Creations des PartType transmission
		PartType tm5 = new PartTypeImpl("tm5", trans);
		PartType tm6 = new PartTypeImpl("tm6", trans);
		PartType ta5 = new PartTypeImpl("ta5", trans);
		PartType ts6 = new PartTypeImpl("ts6", trans);
		PartType tsf7 = new PartTypeImpl("tsf7", trans);
		PartType tc120 = new PartTypeImpl("tc120", trans);		
		
		//Creations des PartType exterieur
		PartType xc = new PartTypeImpl("xc", ext);
		PartType xm = new PartTypeImpl("xm", ext);
		PartType xs = new PartTypeImpl("xs", ext);
		
		//Creations des PartType interieur
		PartType in = new PartTypeImpl("in", inte);
		PartType ih = new PartTypeImpl("ih", inte);
		PartType is = new PartTypeImpl("is", inte);
		
		//Creation du Set des PartType engine
		Set<PartType> engines = new HashSet<>();
		engines.add(eg100);
		engines.add(eg133);
		engines.add(eg210);
		engines.add(ed110);
		engines.add(ed180);
		engines.add(eh120);
		
		//Creation du Set des PartType trans
		Set<PartType> transs = new HashSet<>();
		transs.add(tm5);
		transs.add(tm6);
		transs.add(ta5);
		transs.add(ts6);
		transs.add(tsf7);
		transs.add(tc120);
		
		//Creation du Set des PartType trans
		Set<PartType> exts = new HashSet<>();
		exts.add(xc);
		exts.add(xm);
		exts.add(xs);
		
		//Creation du Set des PartType trans
		Set<PartType> ints = new HashSet<>();
		ints.add(in);
		ints.add(ih);
		ints.add(is);
		
		map.put(engine,engines);
		map.put(trans,transs);
		map.put(ext,exts);
		map.put(inte,ints);
		
		Set<PartType> req_eh120 = new HashSet<>();
		req_eh120.add(tc120);
		compMan.addRequirements(eh120, req_eh120);
		
		Set<PartType> incomp_ta5 = new HashSet<>();
		incomp_ta5.add(eg100);
		compMan.addIncompatibilities(ta5, incomp_ta5);
		
		Set<PartType> incomp_tsf7 = new HashSet<>();
		incomp_tsf7.add(eg100);
		incomp_tsf7.add(eg133);
		incomp_tsf7.add(ed110);
		compMan.addIncompatibilities(tsf7, incomp_tsf7);
		
		Set<PartType> req_tc120 = new HashSet<>();
		req_tc120.add(eh120);
		compMan.addRequirements(tc120, req_tc120);
		
		Set<PartType> incomp_xc = new HashSet<>();
		incomp_xc.add(eg210);
		compMan.addIncompatibilities(xc, incomp_xc);
		
		Set<PartType> incomp_xm = new HashSet<>();
		incomp_xm.add(eg100);
		compMan.addIncompatibilities(xm, incomp_xm);
		
		Set<PartType> incomp_xs = new HashSet<>();
		incomp_xs.add(eg100);
		compMan.addIncompatibilities(xs, incomp_xs);
		
		Set<PartType> req_xs = new HashSet<>();
		req_xs.add(is);
		compMan.addRequirements(xs, req_xs);
		
		Set<PartType> incomp_is = new HashSet<>();
		incomp_is.add(eg100);
		incomp_is.add(tm5);
		compMan.addIncompatibilities(is, incomp_is);
		
		Set<PartType> req_is = new HashSet<>();
		req_is.add(xs);
		compMan.addRequirements(is, req_is);
	}
	
	public Category findByNameCat(Set<Category> s,String name) {
		for (Category c : s) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	@Override
	public PartType findByNamePart(Set<PartType> s, String name) {
		for (PartType c : s) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

}