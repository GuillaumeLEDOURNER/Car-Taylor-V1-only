package aco_tp2_api;

public interface PartType {

	/**
	 * Retourne le nom du PartType
	 * @return le nom du PartType
	 */
    String getName();

    /**
     * Retourne la categorie du PartType
     * @return la categorie du PartType
     */
    Category getCategory();

	/**
	 * Retourne vrai si les deux part sont égaux
	 */
	boolean equals(PartType p);
}