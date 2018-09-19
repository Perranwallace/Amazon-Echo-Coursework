package main;

import javax.swing.JFrame;

import gui.GUserInterface;

import recordSound.RecordSound;

import speechToText.SpeechToText;


/**
 * <h1>Main</h1> Main creates a Graphical User interface for an amazon echo
 * replica program. It will start in an ONOFF mode, after the on Button is
 * pressed, the transfer into listening mode.
 * <p>
 * 
 * In this mode, the echo will currently record the sound and translate it into
 * text, before printing it, if possible, to the command line.
 * <p>
 * 
 * In future, after changing the speech into text, it will transform into
 * research mode, and input the text into the wolfram alpha query, and receive
 * an answer in text mode.
 * 
 * @author 650024818
 * @since 22.02.2017
 * @version 1.00
 */
public class Main {

	static RecordSound rs = new RecordSound();

	/**
	 * Special variable type to track what mode the device is in. As there is
	 * one device, it does not need to be instantiated in objects, and can
	 * remain static upon instantiation.
	 * 
	 * @author 650024818
	 *
	 */
	public enum Mode {
		ONOFF, LISTEN, RESEARCH, ANSWER
	}

	public static Mode mode;

	/**
	 * <h1>OnOffMode()</h1> The mode which the ECHO starts in when it is first
	 * run. Pressing the ONOFF button whilst Mode = ONOFF will call
	 * listenMode(). Public as it is required in other packages (GUI), void as
	 * it does not return any type.
	 * <p>
	 * 
	 * Mode is required so if two clicks are made of the button, whilst the ECHO
	 * is in another Mode, would cause either bugs or cause the ECHO to start
	 * over.
	 * <p>
	 * 
	 * Whilst in onOffMode(), the GUI will have a unique appearance.
	 * 
	 * @author 650024818
	 * @since 22/02/2017
	 * @version 1.0
	 */
	public static void onOffMode() {
		mode = Mode.ONOFF;
		System.out.println("Sleeping");
	}

	/**
	 * <h1>listenMode()</h1> The mode which the ECHO changes to if the onOff
	 * button is pressed, whilst Mode = Mode.ONOFF This mode will listen for 10
	 * seconds and record the sound from a microphone. It will then convert the
	 * recording to a string, which is then used as input for researchMode().
	 * <p>
	 *  
	 * Currently the speech to text function isn't working correctly, and has
	 * hence been left in comments. This also means researchMode() and
	 * answerMode() aren't executed.
	 * <p>
	 * 
	 * In future, whilst in listenMode(), the GUI will have a unique appearance.
	 * 
	 * @author 650024818
	 * @since 22/02/2017
	 * @version 1.0
	 * 
	 */
	public static void listenMode() {
		mode = Mode.LISTEN;
		System.out.println("Listening");
		rs.recordSoundButton();
		answerMode(researchMode(SpeechToText.convertStT()));
		// Currently an error : java.io.IOException:Server returned HTTP
		// response code: 401 for URL:
		// https://api.cognitive.microsoft.com/sts/v1.0/issueToken
	}

	/**
	 * <h1>researchMode() <\h1> This function is called in order to send off a
	 * string s, to wolfram alpha in order to receive an answer to a question.
	 * It has not been implemented as of the first sprint.
	 * 
	 * @param String 
	 * @return String which is the response from wolfram, and will be used as input for answerMode().
	 * @since 22/02/2017
	 * @version 1.0
	 * @author 650024818
	 */
	public static String researchMode(String query) {
		mode = Mode.RESEARCH;
		return "I'm sorry, I cannot answer that question"; // Reply if answer
															// could not be
															// found

	}

	/**
	 * <h1>answerMode</h1> This function is called in listenMode(), it takes as
	 * input the string from listenMode(), and will convert that text back into
	 * speech and save it as a sound file. It will then play the sound file &
	 * set mode back to ONOFF.
	 * <p>
	 * 
	 * As of the first sprint, this has not yet been implemented.
	 * 
	 * @param String
	 * @author 650024818
	 * @since 22.02.2017
	 * @version 1.0
	 * 
	 */
	public static void answerMode(String Answer) {
		mode = Mode.ANSWER;
		onOffMode();
	}
	/**
	 * <h1> Main </h1>  Main method of the program. Sets Mode to ONOFF, and creates the interface for the user.
	 * 
	 * @param args
	 * @author 650024818
	 * @since 22.02.2017
	 * @version 1.2
	 */
	public static void main(String[] args) {
		mode = Mode.ONOFF;
		JFrame frame = new GUserInterface();

	}

}
