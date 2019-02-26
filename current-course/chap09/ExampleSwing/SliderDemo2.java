package ExampleSwing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Dictionary;
import java.util.Hashtable;

public class SliderDemo2 extends JFrame implements ActionListener {

	// Set up animation parameters
	static final int FPS_INIT = 5; // initial frames per second
	int frameNumber = 0;
	int delay;
	Timer timer;
	boolean frozen = false;

	// This label uses ImageIcon to show the burger pictures.
	JLabel picture;

	// The burger filename extensions listed
	// in the order they are shown.
	String[] extensions = { "----", "l---", "lt--", "ltc-", "-tc-", "-t--",
			"-t-o", "-tco", "ltco", "lt-o", "l--o", "l-co", "l-c-", "--c-",
			"--co", "---o" };

	SliderDemo2(String windowTitle) {
		super(windowTitle);
		delay = 1000 / FPS_INIT;

		// Create the slider
		JSlider framesPerSecond = new JSlider(JSlider.VERTICAL, 0, 30, FPS_INIT);
		framesPerSecond.addChangeListener(new SliderListener());
		framesPerSecond.setMajorTickSpacing(10);
		framesPerSecond.setPaintTicks(true);

		// Create the label table
		Dictionary labelTable = new Hashtable();

		// PENDING: could use images, but we don't have any good ones
		labelTable.put(new Integer(0), new JLabel("Stop"));
		// new JLabel(new ImageIcon("images/stop.gif")) );
		labelTable.put(new Integer(3), new JLabel("Slow"));
		// new JLabel(new ImageIcon("images/slow.gif")) );
		labelTable.put(new Integer(30), new JLabel("Fast"));
		// new JLabel(new ImageIcon("images/fast.gif")) );
		framesPerSecond.setLabelTable(labelTable);

		framesPerSecond.setPaintLabels(true);
		framesPerSecond.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));

		// Create the label for the animation
		picture = new JLabel(new ImageIcon("ExampleSwing/images/burger-"
				+ extensions[frameNumber] + ".gif"), JLabel.CENTER);
		picture.setAlignmentX(Component.CENTER_ALIGNMENT);
		picture.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLoweredBevelBorder(),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));

		// Put everything in the content pane
		JPanel contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(framesPerSecond, BorderLayout.WEST);
		contentPane.add(picture, BorderLayout.CENTER);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);

		// Set up a timer that calls this object's action handler.
		timer = new Timer(delay, this);
		timer.setInitialDelay(3000); // delay for 3 seconds before beginning
										// animation
		timer.setCoalesce(true);

		// Add a listener for window events
		addWindowListener(new WindowAdapter() {
			public void windowIconified(WindowEvent e) {
				stopAnimation();
			}

			public void windowDeiconified(WindowEvent e) {
				startAnimation();
			}

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	/** Listens to the slider. */
	class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			if (!source.getValueIsAdjusting()) {
				int fps = (int) ((JSlider) e.getSource()).getValue();
				if (fps == 0) {
					if (!frozen)
						stopAnimation();
				} else {
					delay = 1000 / fps;
					timer.setDelay(delay);
					if (frozen)
						startAnimation();
				}
			}
		}
	}

	public void startAnimation() {
		// Start (or restart) animating!
		timer.start();
		frozen = false;
	}

	public void stopAnimation() {
		// Stop the animating thread.
		timer.stop();
		frozen = true;
	}

	// Called when the Timer fires
	public void actionPerformed(ActionEvent e) {
		// Advance the animation frame.
		if (frameNumber == (extensions.length - 1))
			frameNumber = 0;
		else
			frameNumber++;
		picture.setIcon(new ImageIcon("ExampleSwing/images/burger-"
				+ extensions[frameNumber] + ".gif"));
	}

	public static void main(String args[]) {
		SliderDemo2 animator = new SliderDemo2("Indecision");
		animator.pack();
		animator.setVisible(true);
		animator.startAnimation();
	}
}
