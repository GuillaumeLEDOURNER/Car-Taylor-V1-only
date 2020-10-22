import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aco_tp2_impl.*;
import aco_tp2_api.*;
import java.util.*;

class TestConfiguration {

	@Test
	void test01_confVide() {
		Configurator conf = new ConfiguratorImpl();
		
		assertTrue(conf.getConfiguration().getSelectedParts().isEmpty());
	}
	
	@Test
	void test02_confClear() {
		Configurator conf = new ConfiguratorImpl();
		
		conf.getConfiguration().clear();
		
		assertTrue(conf.getConfiguration().getSelectedParts().isEmpty());
	}
	
	@Test
	void test03_confValide() {
		Configurator conf = new ConfiguratorImpl();
		
		/*Set<Category> cats = conf.getCategories();
		Category c = 	
		Set<PartType> engines = conf.getVariants(c);*/
		
		for (PartType p : conf.getConfiguration().getSelectedParts()) {
			System.out.print(p.getName()+" + ");
		}
		
		assertTrue(conf.getConfiguration().isComplete());
	}

}
