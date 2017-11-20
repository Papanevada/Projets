package command;

import receiver.Enregistreur;

/**
 * 
 * Concrete Command "Demarrer" implementant l'interface Command
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class Demarrer implements CommandGeneral {

	/**
	 * Nouvelle instance de l'interface Enregistreur permettant l'acces aux methodes
	 * de l'enregistreur.
	 * 
	 * @see Enregistreur
	 */
	private Enregistreur enregistreur;

	/**
	 * Constructeur de la classe Demarrer initialisant les attributs
	 * 
	 * @param enregistreur
	 */
	public Demarrer(Enregistreur enregistreur) {
		this.enregistreur = enregistreur;
	}

	/**
	 * Methode execute appelant la methode demarrer() de l'enregistreur
	 */
	public void execute() {
		enregistreur.demarrer();
	}
}
