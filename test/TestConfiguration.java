import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import aco_tp2_impl.*;
import aco_tp2_api.*;
import java.util.*;

class TestConfiguration {
@BeforeEach
	@Test
	@DisplayName("Test de configuration vide")
	void test01_confVide() {
		Configurator conf = new ConfiguratorImpl();

		assertTrue(conf.getConfiguration().getSelectedParts().isEmpty());
	}

	@Test
	@DisplayName("Test fonction clear")
	void test02_confClear() {
		Configurator conf = new ConfiguratorImpl();

		Set<Category> cats = conf.getCategories();
		Category catEng = conf.findByNameCat(cats, "engine");
		Set<PartType> setEngine = conf.getVariants(catEng);
		PartType eg100 = conf.findByNamePart(setEngine, "eg100");
		conf.getConfiguration().selectPart(eg100);

		Category catTrans = conf.findByNameCat(cats, "trans");
		Set<PartType> setTrans = conf.getVariants(catTrans);
		PartType tm5 = conf.findByNamePart(setTrans, "tm5");
		conf.getConfiguration().selectPart(tm5);

		Category catExt = conf.findByNameCat(cats, "ext");
		Set<PartType> setExt = conf.getVariants(catExt);
		PartType xc = conf.findByNamePart(setExt, "xc");
		conf.getConfiguration().selectPart(xc);

		Category catInt = conf.findByNameCat(cats, "interieur");
		Set<PartType> setInt = conf.getVariants(catInt);
		PartType in = conf.findByNamePart(setInt, "in");
		conf.getConfiguration().selectPart(in);

		conf.getConfiguration().clear();

		assertTrue(conf.getConfiguration().getSelectedParts().isEmpty());
	}

	@Test
	@DisplayName("Test de configuration vide")
	void test03_confComplete() {
		Configurator conf = new ConfiguratorImpl();

		Set<Category> cats = conf.getCategories();
		Category catEng = conf.findByNameCat(cats, "engine");
		Set<PartType> setEngine = conf.getVariants(catEng);
		PartType eg100 = conf.findByNamePart(setEngine, "eg100");
		conf.getConfiguration().selectPart(eg100);

		Category catTrans = conf.findByNameCat(cats, "trans");
		Set<PartType> setTrans = conf.getVariants(catTrans);
		PartType tm5 = conf.findByNamePart(setTrans, "tm5");
		conf.getConfiguration().selectPart(tm5);

		Category catExt = conf.findByNameCat(cats, "ext");
		Set<PartType> setExt = conf.getVariants(catExt);
		PartType xc = conf.findByNamePart(setExt, "xc");
		conf.getConfiguration().selectPart(xc);

		Category catInt = conf.findByNameCat(cats, "interieur");
		Set<PartType> setInt = conf.getVariants(catInt);
		PartType in = conf.findByNamePart(setInt, "in");
		conf.getConfiguration().selectPart(in);

		for (PartType p : conf.getConfiguration().getSelectedParts()) {
			System.out.println(p + " + ");
		}

		assertTrue(conf.getConfiguration().isComplete());
		assertEquals(eg100, conf.getConfiguration().getSelectionForCategory(catEng));
		conf.getConfiguration().unselectPartType(catEng);
		assertFalse(conf.getConfiguration().isComplete());
	}

	@Test
	void test04_getSelectionByCategory() {
		Configurator conf = new ConfiguratorImpl();

		Set<Category> cats = conf.getCategories();
		Category catEng = conf.findByNameCat(cats, "engine");
		Set<PartType> setEngine = conf.getVariants(catEng);
		PartType eg100 = conf.findByNamePart(setEngine, "eg100");
		conf.getConfiguration().selectPart(eg100);

		assertEquals(eg100, conf.getConfiguration().getSelectionForCategory(catEng));
	}

	@Test
	void test05_unselect() {
		Configurator conf = new ConfiguratorImpl();

		Set<Category> cats = conf.getCategories();
		Category catEng = conf.findByNameCat(cats, "engine");
		Set<PartType> setEngine = conf.getVariants(catEng);
		PartType eg100 = conf.findByNamePart(setEngine, "eg100");
		conf.getConfiguration().selectPart(eg100);
		conf.getConfiguration().unselectPartType(catEng);

		assertTrue(conf.getConfiguration().getSelectedParts().isEmpty());
	}

}
