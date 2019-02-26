//XXX: Metalworks is the only desktop-using app I looked at.  This follows
//XXX: its lead.  How will these desktop apps usually be arranged?  Really
//XXX: a menu at the top of the main JFrame?

//XXX: You might think of using a JWindow to house the JDesktopPane, but
//XXX: JWindows behave badly.  They *always* stay in front.  And you can't
//XXX: miniaturize them.
package ExampleSwing;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;

import java.awt.event.*;
import java.awt.*;

public class InternalFrameDemo extends JFrame {

	JDesktopPane desktop;

	public InternalFrameDemo() {
		super("InternalFrameDemo");

		// Make the big window be indented 50 pixels from each edge
		// of the screen.
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height
				- inset * 2);

		// Quit this app when the big window closes.
		addWindowListener(new WindowAdapter() {
			// XXX: Notes for Kathy.
			// XXX: common problem: windowClosing or other event method ignored.
			// XXX: did you add it as a listener? Did you define the method
			// right,
			// XXX: E.g., is it public void, spelled right, and have the right
			// kind
			// XXX: of argument (issue for adapter subclasses).
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// Set up the GUI.
		desktop = new JDesktopPane(); // a specialized layered pane
		createFrame(); // Create first window

		setContentPane(desktop);
		setJMenuBar(createMenuBar());
	}

	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu menu = new JMenu("Document");
		JMenuItem menuItem = new JMenuItem("New");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createFrame();
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);

		return menuBar;
	}

	protected void createFrame() {
		MyInternalFrame frame = new MyInternalFrame();
		desktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e2) {
		}
	}

	public static void main(String[] args) {
		InternalFrameDemo frame = new InternalFrameDemo();
		frame.setVisible(true);
	}
}
