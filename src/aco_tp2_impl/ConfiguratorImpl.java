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
	
	private void initialization() {
		map = new HashMap<>();
		
		//Creation des Category
		Category engine = new CategoryImpl("Engine");
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
	}

}
