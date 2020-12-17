package aco_tp2_api;
import aco_tp2_parts.*;
public interface Visitor {

		/**
		 *  on visite l'ensemble des parts dans la configuration passe en param 
		 * @param config
		 */
		public void visitConfiguration(Configuration config);
		
		/**
		 * visite un part de type engine( eg100 etc)
		 * @param egine
		 */
		public void visitEngine(Engine part);
		
		/**
		 * visite un part de type transmission( tm5 etc)
		 * @param egine
		 */
		public void visitTransmission(Transmission part);
		
		/**
		 * visite un part de type interior( in etc)
		 * @param egine
		 */
		public void visitInterior(Interior part);
		
		/**
		 * visite un part de type exterior( xs etc)
		 * @param interior
		 */
		public void visitExterior(Exterior part);
	

}
