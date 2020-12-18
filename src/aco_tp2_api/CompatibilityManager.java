package aco_tp2_api;

import java.util.Set;

public interface CompatibilityManager extends CompatibilityChecker {

	/**
	 * Ajoute l'incompatibilité entre le PartType reference et l'ensemnle de PartType target
	 * @param reference le PartType auquel on veut ajouter l'incompatibilité
	 * @param target l'ensemble de PartType auquel on veut ajouter l'incompatibilité
	 */
    void addIncompatibilities(PartType reference, Set<PartType> target) throws Exception;

    /**
     * Supprime l'incompatibilité entre le PartType reference et le PartType target
     * @param reference le PartType auquel on veut supprimer l'incompatibilité
     * @param target le 2e  PartType auquel on veut supprimer l'incompatibilité
     */
    void removeIncompatibility(PartType reference, PartType target);

    /**
	 * Ajoute l'obligation entre le PartType reference et l'ensemnle de PartType target
	 * @param reference le PartType auquel on veut ajouter l'obligation
	 * @param target l'ensemble de PartType auquel on veut ajouter l'obligation
	 */
    void addRequirements(PartType reference, Set<PartType> target);

    /**
     * Supprime l'obligation entre le PartType reference et le PartType target
     * @param reference le PartType auquel on veut supprimer l'obligation
     * @param target le 2e  PartType auquel on veut supprimer l'obligation
     */
    void removeRequirement(PartType reference, PartType target);

}
