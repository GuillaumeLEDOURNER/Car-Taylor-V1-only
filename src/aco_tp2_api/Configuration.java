package aco_tp2_api;

import java.util.Set;

public interface Configuration {

	/**
	 * Defini si une configuration est valide
	 * Une configuration est valide si elle respecte les regles d'incompatibilites et d'obligation
	 * Une configuration n'a pas besoin d'etre complete pour etre valide
	 * @return true si la configuration est valide
	 */
    boolean isValid();

    /**
     * Defini si une configuration est complete
     * Une configuration est complete si elle contient un element de chaque categories
     * Une configuration n'a pas besoin d'etre valide pour etre complete
     * @return true si la configuration est complete
     */
    boolean isComplete();

    /**
     * Retourne l'ensemble non-modifiable des PartType selectionnes
     * @return l'ensemble non-modifiable des PartType selectionnes
     */
    Set<PartType> getSelectedParts();

    /**
     * Ajoute le PartType chosenPart a l'ensemble selectedParts
     * @param chosenPart le PartType a ajouter
     */
    void selectPart(PartType chosenPart);

    /**
     * Retourne le PartType choisi pour une categorie category
     * @param category La categorie dont on veut avoir le PartType
     * @return Le PartType choisi pour la categorie category
     */
    PartType getSelectionForCategory(Category category);

    void unselectPartType(Category categoryToClear);

    void clear();

}
