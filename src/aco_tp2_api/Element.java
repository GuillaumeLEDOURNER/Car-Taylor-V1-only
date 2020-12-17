package aco_tp2_api;


public interface Element {

	/**
	 * chaque element doit accepter la visite du visitor
	 * @param v
	 */
	public void accept(Visitor v) ;
	
}
