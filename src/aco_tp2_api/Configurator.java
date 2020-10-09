package aco_tp2_api;

import java.util.Set;

public interface Configurator {

	/**
	 * Retourne les categories possibles
	 * @return un ensemble contenant les categories possibles
	 */
    Set<Category> getCategories();

    /**
     * Retourne les PartTypes possibles pour la categorie category
     * @param category la categorie dont on veut recuperer l'ensemble des PartType
     * @return un ensemble de PartType de categorie category
     */
    Set<PartType> getVariants(Category category);

    Configuration getConfiguration();

    CompatibilityChecker getCompatibilityChecker();

}
