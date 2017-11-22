package etats;

import java.util.ArrayList;
import java.util.List;

import command.Command;
import memento.Memento;
import receiver.Manager;
import state.Buffer;
import state.Selection;

/**
 * 
 * Class State, representation d'une sauvegarde d'etat
 * 
 * @since v3
 * @author Alexis LE MASLE et Fanny PRIEUR
 *
 */
public class State {

	/**
	 * Buffer a sauvegarder dans le State courant.
	 */
	private Buffer buf;

	/**
	 * Selection a sauvegarder dans le State courant.
	 */
	private Selection selection;

	/**
	 * Le manager pour sauvegarder un State
	 */
	private Manager manager;

	/**
	 * Liste des commandes a sauvegarder dans le State courant liees aux mementos
	 */
	private List<Command> lcmd = new ArrayList<Command>();

	/**
	 * Liste des mementos a sauvegarder dans le State courant lies aux commandes
	 * enregistree.
	 */
	private List<Memento<?>> lmem = new ArrayList<Memento<?>>();

	/**
	 * Constructeur de State
	 * 
	 * @param manager
	 */
	public State(Manager manager) {
		this.manager = manager;
	}

	/**
	 * Permet d'ajouter cmd dans la liste des commandes lcmd
	 * 
	 * @param cmd
	 *            la commande a ajouter
	 */
	public void addCmd(Command cmd) {
		if (lcmd.size() < 5) {
			lcmd.add(cmd);
		} else {
			State newState = new State(manager);
			Buffer b = new Buffer();
			b = buf;
			List<Command> lc = new ArrayList<Command>();
			lc = lcmd;
			List<Memento<?>> lm = new ArrayList<Memento<?>>();
			lm = lmem;
			newState.setBuf(b);
			newState.setLcmd(lc);
			newState.setLmem(lm);
			newState.setSelection(selection);
			manager.setStateCourant(newState);
			lcmd = new ArrayList<Command>();
			lmem = new ArrayList<Memento<?>>();
			System.out.println("New state saved");
		}
	}

	/**
	 * Permet d'ajouter mem dans la liste des mementos lmem
	 * 
	 * @param mem
	 *            le memento a ajouter
	 */
	public void addMemento(Memento<?> mem) {
		if (lmem.size() < 5) {
			lmem.add(mem);
		} else {
			State newState = new State(manager);
			Buffer b = new Buffer();
			b = buf;
			List<Command> lc = new ArrayList<Command>();
			lc = lcmd;
			List<Memento<?>> lm = new ArrayList<Memento<?>>();
			lm = lmem;
			newState.setBuf(b);
			newState.setLcmd(lc);
			newState.setLmem(lm);
			newState.setSelection(selection);
			manager.setStateCourant(newState);
			lcmd = new ArrayList<Command>();
			lmem = new ArrayList<Memento<?>>();
			System.out.println("New state saved");
		}
	}

	////////////////////////////////////////////////////////

	// Getter et Setter de tous les attributs de la classe State

	public Buffer getBuf() {
		return buf;
	}

	public void setBuf(Buffer buf) {
		this.buf = buf;
	}

	public List<Command> getLcmd() {
		return lcmd;
	}

	public void setLcmd(List<Command> lcmd) {
		this.lcmd = lcmd;
	}

	public List<Memento<?>> getLmem() {
		return lmem;
	}

	public void setLmem(List<Memento<?>> lmem) {
		this.lmem = lmem;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

}