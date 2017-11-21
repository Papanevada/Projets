package receiver;

import etats.State;

/**
 * 
 * Interface du manager Defaire/Refaire
 * 
 * @since v3
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public interface Manager {

	void defaire();

	void refaire();

	void setStateCourant(State s);

	State getStateCourant();

}
