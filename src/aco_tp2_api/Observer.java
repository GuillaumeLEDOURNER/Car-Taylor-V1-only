package aco_tp2_api;

public interface Observer<V> {

	/**
	 * recuperer la nouvelle configuration
	 * @param s : encapsule la configuration 
	 */
	void update(Subject<V> s);

}
