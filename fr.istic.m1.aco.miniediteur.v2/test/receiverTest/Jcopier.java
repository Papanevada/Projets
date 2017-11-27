package receiverTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import command.Ajouter;
import command.Coller;
import command.Command;
import command.Copier;
import command.Copier.CopierMemento;
import memento.Memento;
import receiver.EnregistrerImpl;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;

/**
 * Fichier Test Copier
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jcopier {

	/**
	 * 
	 *
	 */
	@Test
	public void testCopier() {

		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		selection.setDebut(3);
		selection.setFin(3);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("").compareTo(pressePapier.getClip()) == 0);

	}

	/**
	 * test le stringBuffer apr�s s�lection des caract�res de 0 � 6 soit "copier"
	 * test en assertTrue que "copier" est bien dans le presse papier
	 *
	 */
	@Test
	public void testCopie2() {
		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(0);
		selection.setFin(6);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("copier").compareTo(pressePapier.getClip()) == 0);

	}

	/**
	 * test le stringBuffer apr�s s�lection des caract�res de 4 � 6 soit "er" test
	 * en assertTrue que "er" est bien dans le presse papier
	 *
	 */
	@Test
	public void testCopie3() {
		StringBuffer stringBuffer = new StringBuffer("copier");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);

		selection.setDebut(4);
		selection.setFin(6);
		Command copier = new Copier(moteur, enregistreur);
		copier.execute();

		assertTrue(("er").compareTo(pressePapier.getClip()) == 0);

	}

	@Test
	public void testGetMemento() {
		StringBuffer stringBuffer = new StringBuffer("abcdef");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		Command copier = new Copier(moteur, enregistreur);
		Command coller = new Coller(moteur, enregistreur);

		buffer.setBuffer(stringBuffer);
		selection.setDebut(0);
		selection.setFin(6);

		copier.execute();
		coller.execute();
		coller.execute();

		selection.setDebut(2);
		selection.setFin(3);

		enregistreur.demarrer();
		selection.setDebut(0);
		selection.setFin(6);
		copier.execute();
		enregistreur.stopper();

		enregistreur.rejouer();

		System.out.println(pressePapier.getClip());
		assertTrue("abcdef".compareTo(pressePapier.getClip()) == 0);

	}

}
