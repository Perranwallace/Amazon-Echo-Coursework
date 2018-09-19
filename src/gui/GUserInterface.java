package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import main.Main;
import main.Main.Mode;

/**
 * 
 * @Author 650024818, 640022156
 */
@SuppressWarnings("serial")
public class GUserInterface extends JFrame {

	final onOff onOffBtn = new onOff();

	/**
	 * <h1>GUserInterface</h1> Creates a new GUI with the following attributes :
	 * <p>
	 * Title = "Echo", Size (195, 465), Not Re-sizable, Is visible, Null layout.
	 * <p>
	 * It also adds a Jbutton which is edited in onOff(), a new GUserInterface
	 * is created inside main.java
	 * 
	 * @author 650024818
	 * @since 22.02.2017
	 * @version 1.3
	 * 
	 * 
	 * 
	 */
	public GUserInterface() {
		setTitle("Echo");
		setLocationRelativeTo(null);
		setSize(195, 465); // Title Bar
		setResizable(false);
		setVisible(true);
		setLayout(null);
		onOffBtn.setBounds(60, 10, 60, 60);
		add(onOffBtn);

	}

	/**
	 * Edits the onOffBtn Created in GUserInterface() at location 60,10 with
	 * size 60,60.
	 * <p>
	 * Takes image stored at "resources/buttonIcon.png", scales it down to the
	 * same size as the button, and uses it as a skin. As there are transparent
	 * parts on the image, setting the background colour allows the button to
	 * glow. This will be used to mimic lights.
	 * <p>
	 * When clicked upon with a mouse, an event occurs which checks if the Mode
	 * is ONOFF, and if so, calls listenMode(). If not, nothing occurs.
	 * 
	 * 
	 * @author 650024818, 640022156
	 * @version 1.6
	 * @since 23.02.2017
	 *
	 */
	@SuppressWarnings("serial")
	private class onOff extends JButton {

		onOff() {
			ImageIcon icon = new ImageIcon("resources/buttonIcon.png");
			Image img = icon.getImage();
			Image newimg = img.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(newimg));
			setBorder(null);
			setBackground(Color.GREEN);
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {
					if (Main.mode == Mode.ONOFF) {
						main.Main.listenMode();
					}
				}
			});
		}
	}

}
