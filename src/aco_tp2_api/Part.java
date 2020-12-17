import aco_tp2_api.*;
public interface Part extends PropertyManager {
	default String getName() {
		return this.getClass().getTypeName();
	};
	/**
	 * Retourne la catégorie du Part
	 * @return la catégorie du Part
	 */
	Category getCategory();
	
	/**
	 * Retourne le type de la Part
	 */
	PartType getType();
}
