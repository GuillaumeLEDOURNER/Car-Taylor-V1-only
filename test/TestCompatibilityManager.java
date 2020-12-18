import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import aco_tp2_impl.*;
import aco_tp2_api.*;
import java.util.*;


public class TestCompatibilityManager {
	CompatibilityManagerImpl manager=new CompatibilityManagerImpl();
	
	@Test
	@DisplayName("getImcomp et addIncomp")
	void TestGetIncomp() {
		CategoryImpl engine = new CategoryImpl("Engine");
		CategoryImpl trans = new CategoryImpl("Transmission");
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType tm5 = new PartTypeImpl("tm5", trans);
		Set<PartType> testincomp=new HashSet<>();
		testincomp.add(tm5);
		assertTrue(manager.getIncompatibilities(eg100).isEmpty(),"La liste des incompatibilités de eg100 est ici vide");
		manager.addIncompatibilities(eg100, testincomp);
		assertFalse(manager.getIncompatibilities(eg100).isEmpty(),"eg100 est maintenant incompatible avec au moins une pièce");
		assertTrue(manager.getIncompatibilities(eg100).contains(tm5),"tm5 est incomp avec eg100");
		assertTrue(manager.getIncompatibilities(tm5).contains(eg100),"et eg100 est incompatible avec tm5");
		assertEquals(1,manager.getIncompatibilities(eg100).size(),"ag100 n'a qu'une incompatibilité");

	}
	@Test
	@DisplayName("removeIncompatibilities")
	void testRemoveIncomp() {
		CategoryImpl engine = new CategoryImpl("Engine");
		CategoryImpl trans = new CategoryImpl("Transmission");
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType tm8 = new PartTypeImpl("tm8", trans);
		Set<PartType> testincomp=new HashSet<>();
		testincomp.add(tm8);
		manager.addIncompatibilities(eg100, testincomp);
		
		manager.removeRequirement(eg100, tm8);
		assertTrue(manager.getIncompatibilities(eg100).isEmpty());
		
	}
	
	@Test
	@DisplayName("addIncompatibilities same type")
	void TestAddSameTypeIncomp() {
		CategoryImpl engine = new CategoryImpl("Engine");
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType eg133 = new PartTypeImpl("eg133", engine);
		Set<PartType> testincomp =new HashSet<>();
		testincomp.add(eg133);
		assertTrue(manager.getIncompatibilities(eg100).isEmpty(),"La liste des Incompatibilities de eg100 est ici vide");
		manager.addIncompatibilities(eg100, testincomp);
		assertTrue(manager.getIncompatibilities(eg100).isEmpty(),"La liste des Incompatibilities de eg100 est ici vide");
		testincomp.remove(eg133);
		testincomp.add(eg100);
		manager.addIncompatibilities(eg100, testincomp);
		assertTrue(manager.getIncompatibilities(eg100).isEmpty(),"La liste des Incompatibilities de eg100 est ici vide");
	}
	
	@Test
	@DisplayName("getRequirements,addRequirements")
	void TestGetRequirements() {
		CategoryImpl engine = new CategoryImpl("Engine");
		CategoryImpl trans = new CategoryImpl("Transmission");
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType tm8 = new PartTypeImpl("tm8", trans);
		Set<PartType> testreq=new HashSet<>();
		testreq.add(tm8);
		assertTrue(manager.getRequirements(eg100).isEmpty(),"La liste des requirements de eg100 est ici vide");
		manager.addRequirements(eg100, testreq);
		assertFalse(manager.getRequirements(eg100).isEmpty(),"eg100 à au moins un requirement");
		assertTrue(manager.getRequirements(eg100).contains(tm8),"tm8 est requis pour eg100");
		assertTrue(manager.getRequirements(tm8).isEmpty(),"mais eg100 n'est pas requis pour utiliser tm8");
		assertEquals(1,manager.getRequirements(eg100).size(),"ag100 n'a qu'un requirement");
		
		
		
	}
	
	@Test
	@DisplayName("removeRequirements")
	void testRemoveReq() {
		CategoryImpl engine = new CategoryImpl("Engine");
		CategoryImpl trans = new CategoryImpl("Transmission");
		PartTypeImpl eg100 = new PartTypeImpl("eg100", engine);
		PartType tm8 = new PartTypeImpl("tm8", trans);
		PartType tm5 = new PartTypeImpl("tm5", trans);
		Set<PartType> testreq=new HashSet<>();
		testreq.add(tm8);
		manager.addRequirements(eg100, testreq);
		assertFalse(manager.getRequirements(eg100).isEmpty());
		manager.removeRequirement(eg100, tm5);
		assertFalse(manager.getRequirements(eg100).isEmpty());
		manager.removeRequirement(eg100, tm8);
		assertTrue(manager.getRequirements(eg100).isEmpty());
		
	}
	
	@Test
	@DisplayName("addRequirements same type")
	void TestAddSameType() {
		CategoryImpl engine = new CategoryImpl("Engine");
		PartType eg100 = new PartTypeImpl("eg100", engine);
		PartType eg133 = new PartTypeImpl("eg133", engine);
		Set<PartType> testreq=new HashSet<>();
		testreq.add(eg133);
		assertTrue(manager.getRequirements(eg100).isEmpty(),"La liste des requirements de eg100 est ici vide");
		manager.addRequirements(eg100, testreq);
		assertEquals(0,manager.getRequirements(eg100).size());
		testreq.remove(eg133);
		testreq.add(eg100);
		manager.addRequirements(eg100, testreq);
		assertEquals(0,manager.getRequirements(eg100).size());
	}
	
}