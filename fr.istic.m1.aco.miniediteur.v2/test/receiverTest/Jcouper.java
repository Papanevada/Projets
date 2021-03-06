package receiverTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import command.Coller;
import command.Command;
import command.CommandGeneral;
import command.Couper;
import receiver.EnregistrerImpl;
import receiver.Enregistreur;
import receiver.Moteur;
import receiver.MoteurImpl;
import state.Buffer;
import state.ClipBoard;
import state.ClipboardImpl;
import state.Selection;

/**
 * Fichier Test Couper
 * 
 * @author Alexis LE MASLE et Fanny PRIEUR
 * 
 */

public class Jcouper {

	/**
	 * 
	 * 
	 *
	 */

	// TODO
	@Test
	public void testCouper() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		selection.setDebut(3);
		selection.setFin(3);
		Command couper = new Couper(moteur, enregistreur);
		couper.execute();

		assertTrue(("").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("couper").compareTo(buffer.getBuffer().toString()) == 0);
	}

	/**
	 * test le stringBuffer apr�s s�lection des caract�res de 0 � 6 soit "couper"
	 * test en assertTrue que "couper" est bien dans le presse papier et est
	 * supprim� du buffer
	 *
	 */
	@Test
	public void testCouper2() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(0);
		selection.setFin(6);
		Command couper = new Couper(moteur, enregistreur);
		couper.execute();

		assertTrue(("couper").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("").compareTo(buffer.getBuffer().toString()) == 0);

	}

	@Test
	public void testSetMemento() {
		// pas d'action
	}

	@Test
	public void testGetMemento() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		CommandGeneral couper = new Couper(moteur, enregistreur);
		CommandGeneral coller = new Coller(moteur, enregistreur);

		buffer.setBuffer(stringBuffer);

		enregistreur.demarrer();
		selection.setDebut(0);
		selection.setFin(3);
		couper.execute();
		selection.setDebut(3);
		selection.setFin(3);
		coller.execute();

		enregistreur.stopper();

		assertTrue(("cou").compareTo(pressePapier.getClip()) == 0);
		assertTrue("percou".compareTo(buffer.getBuffer().toString()) == 0);
	}

	/**
	 * test le stringBuffer apr�s s�lection des caract�res de 2 � 5 soit "upe" que
	 * l'on coupe du pressepapier et il reste donc les caract�res "cor" dans le
	 * buffer
	 *
	 */
	@Test
	public void testCouper3() {
		StringBuffer stringBuffer = new StringBuffer("couper");
		Buffer buffer = new Buffer();
		Selection selection = new Selection();
		ClipBoard pressePapier = new ClipboardImpl();
		Enregistreur enregistreur = new EnregistrerImpl();
		Moteur moteur = new MoteurImpl(buffer, pressePapier, selection);

		buffer.setBuffer(stringBuffer);
		enregistreur.stopper();
		selection.setDebut(2);
		selection.setFin(5);
		Command couper = new Couper(moteur, enregistreur);
		couper.execute();

		assertTrue(("upe").compareTo(pressePapier.getClip()) == 0);
		assertTrue(("cor").compareTo(buffer.getBuffer().toString()) == 0);

	}
}
