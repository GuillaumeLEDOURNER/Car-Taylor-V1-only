import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import aco_tp2_impl.*;
import aco_tp2_api.*;

class TestConfiguration {

	@Test
	void test01_confVide() {
		Configuration conf = new ConfigurationImpl();
		
		assertTrue(conf.getSelectedParts().isEmpty());
	}
	
	@Test
	void test02_confValide() {
		Configuration conf = new ConfigurationImpl();
		Category engine = new CategoryImpl("Engine");
		Category trans = new CategoryImpl("trans");
		Category ext = new CategoryImpl("ext");
		Category inte = new CategoryImpl("interieur");
		
		PartType g100 = new PartTypeImpl("g100", engine);
		PartType tm5 = new PartTypeImpl("tm5", trans);
		PartType xc = new PartTypeImpl("xc", ext);
		PartType in = new PartTypeImpl("in", inte);
		
		conf.selectPart(g100);
		conf.selectPart(tm5);
		conf.selectPart(xc);
		conf.selectPart(in);
		
		for (PartType p : conf.getSelectedParts()) {
			System.out.print(p.getName()+" + ");
		}
		
		assertTrue(conf.isComplete());
	}

}
