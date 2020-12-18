package aco_tp2_api;


/**
 * @author LE DOURNER_LE GAL
 */
public interface Subject<V> {
	
	/**
	 * ajoute un nouvel observer depuis la liste des observateurs du sujects
	 * 
	 * @param o
	 */
	public void attach(Observer<V> o);
	/**
	 *  supprimer l'observer depuis la liste des observateurs du sujects
	 * @param o
	 */
	public void detach(Observer<V> o);
	/**
	 *  tester si un observer est abonne au sujet 
	 * @param observer
	 * @return un booleen
	 */
	public boolean isAttached(Observer<V> observer);
	/**
	 *  recuperer la nouvelle configuration
	 * @return la valeur de la configuration 
	 */
	public V getValue();
}
