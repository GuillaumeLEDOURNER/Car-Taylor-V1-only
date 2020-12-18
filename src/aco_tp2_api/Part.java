package aco_tp2_api;
public interface Part extends PropertyManager {
	default String getName() {
		return this.getClass().getTypeName();
	};
	/**
	 * @return la catégorie du Part
	 */
	Category getCategory();
	
	/**
	 * @return le type de la Part
	 */
	PartType getType();
}
