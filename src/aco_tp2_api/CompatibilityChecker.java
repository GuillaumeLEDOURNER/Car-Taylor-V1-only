package aco_tp2_api;

import java.util.Set;

public interface CompatibilityChecker {

	/**
	 * Retourne un ensemble de PartType contenant les parties incompatibles avec le parametre reference
	 * @param reference Le PartType dont on veut obtenir l'ensemble des incompatibilités
	 * @return un ensemble de PartType incompatibles avec le parametre reference
	 */
    Set<PartType> getIncompatibilities(PartType reference);

    /**
	 * Retourne un ensemble de PartType contenant les parties obligatoires pour le parametre reference
	 * @param reference Le PartType dont on veut obtenir l'ensemble des partie obligatoire
	 * @return un ensemble de PartType obligatoires pour le parametre reference
	 */
    Set<PartType> getRequirements(PartType reference);

}
