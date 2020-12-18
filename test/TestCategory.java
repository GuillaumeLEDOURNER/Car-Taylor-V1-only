import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aco_tp2_impl.*;
import aco_tp2_api.*;


public class TestCategory {
	
	@Test
	@DisplayName("getName")
	void TestGetName() {
		
		Category engine = new CategoryImpl("Engine");
		CategoryImpl trans = new CategoryImpl("Transmission");
		
		assertFalse(engine.getName().isEmpty(), "Le nom de la catégorie a bien été set, il n'est pas null");
		assertEquals("Engine", engine.getName(), "Le nom est bien engine");
		
		
		
		assertFalse(engine.getName().equals(trans.getName()),"Le nom est bien différent");
		assertEquals("Transmission", trans.getName(),"Le nom Transmission est bien celui de la deuxième catégorie");
	}
	
	
	


}
