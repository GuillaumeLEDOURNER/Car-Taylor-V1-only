package aco_tp2_api;

public interface Observer<V> {

	/**
	 * Met a jour la configuration
	 * @param s : encapsule la configuration 
	 */
	void update(Subject<V> s);

}
