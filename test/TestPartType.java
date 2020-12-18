import aco_tp2_impl.*;
import aco_tp2_api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class TestPartType {
	
	@Test
	@DisplayName("getName")
	void TestGetName() {
		CategoryImpl engine = new CategoryImpl("Engine");
		CategoryImpl trans = new CategoryImpl("Transmission");
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType eg133 = new PartTypeImpl("eg133", engine);
		PartType tm5 = new PartTypeImpl("tm5", trans);
	
		
		assertFalse(eg100.getName().isEmpty(), "Le nom de la part a bien �t� set, il n'est pas null");
		assertEquals("eg100", eg100.getName(), "Le nom est bien eg100");	
		assertFalse(eg100.getName().equals(tm5.getName()),"Le nom des part bien diff�rent");
		

}
	@Test
	@DisplayName("getCat�gorie")
	void TestGetCat() {
		CategoryImpl engine = new CategoryImpl("Engine");
		CategoryImpl trans = new CategoryImpl("Transmission");
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType eg133 = new PartTypeImpl("eg133", engine);
		PartType tm5 = new PartTypeImpl("tm5", trans);
		
		assertEquals(engine,eg100.getCategory(), "la cat�gorie est bien engine");
		assertEquals(eg133.getCategory(), eg100.getCategory(),"Les deux pi�ces sont bien de la m�me cat�gorie");
		assertFalse(eg133.getCategory().equals(tm5.getCategory()), "les deux pi�ces sont bien de cat�gory diff�rentes");
	}
		
		
}