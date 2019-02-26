package ExampleSwing;

import javax.swing.JInternalFrame;

import java.awt.event.*;
import java.awt.*;

//XXX: Note: setVisible(true) has a different implementation than
//XXX: show().  This seems highly bogus -- the setVisible(true)
//XXX: method was supposed to replace show() -- not add another
//XXX: method.
public class MyInternalFrame extends JInternalFrame {

	static int openFrameCount = 0;
	static final int xOffset = 30, yOffset = 30;

	public MyInternalFrame() {
		super("Document #" + (++openFrameCount), true, // resizable
				true, // closable
				true, // maximizable
				true);// iconifiable

		// ...Create the GUI and put it in the window...
		// ...Then set the window size or call pack...
		setSize(300, 300);

		// Set the window's location.
		setLocation(xOffset * openFrameCount, yOffset * openFrameCount);

		// added by suncong
		setVisible(true);
	}
}
