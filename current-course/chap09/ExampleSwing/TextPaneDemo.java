package ExampleSwing;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Hashtable;
import java.net.*;
import java.applet.*;

import javax.swing.*;
import javax.swing.text.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import javax.swing.border.*;

public class TextPaneDemo extends JApplet {
	JTextPane textPane;
	LimitedStyledDocument lpd;
	AudioClip audioClip;
	String newline;
	static final int MAX_CHARACTERS = 300;
	Hashtable actions;

	// undo helpers
	protected UndoAction undoAction;
	protected RedoAction redoAction;
	protected UndoManager undo = new UndoManager();

	public void init() {

		// Some initial setup
		newline = System.getProperty("line.separator");
		audioClip = getAudioClip(getCodeBase(), "bottle-open.wav");

		// Create the document for the text area
		lpd = new LimitedStyledDocument(MAX_CHARACTERS);

		// Create the text area and configure it
		textPane = new JTextPane();
		textPane.setDocument(lpd);
		textPane.setCaretPosition(0);
		textPane.setMargin(new Insets(5, 5, 5, 5));
		JScrollPane scrollPane = new JScrollPane(textPane);
		scrollPane.setPreferredSize(new Dimension(350, 350));

		// Add the text pane to the frame
		getContentPane().add(scrollPane);

		// Set up the menu bar
		actions = createActionTable(textPane);
		JMenu editMenu = createEditMenu();
		JMenu styleMenu = createStyleMenu();
		JMenuBar mb = new JMenuBar();
		mb.add(editMenu);
		mb.add(styleMenu);
		setJMenuBar(mb);

		// Add some key bindings to the keymap
		addKeymapBindings();

		// Put the initial content into the text pane.
		initDocument();

		// Start watching for undoable edits and caret changes
		lpd.addUndoableEditListener(new MyUndoableEditListener());
	}

	// This one listens for edits that can be undone.
	protected class MyUndoableEditListener implements UndoableEditListener {
		public void undoableEditHappened(UndoableEditEvent e) {
			// Remember the edit and update the menus
			undo.addEdit(e.getEdit());
			undoAction.update();
			redoAction.update();
		}
	}

	// Add a couple of emacs key bindings to the key map for navigation
	protected void addKeymapBindings() {
		// Add a new key map to the keymap hierarchy
		Keymap keymap = textPane.addKeymap("MyEmacsBindings",
				textPane.getKeymap());

		// Ctrl-b to go backward one character
		Action action = getActionByName(StyledEditorKit.backwardAction);
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK);
		keymap.addActionForKeyStroke(key, action);

		// Ctrl-f to go forward one character
		action = getActionByName(StyledEditorKit.forwardAction);
		key = KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK);
		keymap.addActionForKeyStroke(key, action);

		// Ctrl-p to go up one line
		action = getActionByName(StyledEditorKit.upAction);
		key = KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK);
		keymap.addActionForKeyStroke(key, action);

		// Ctrl-n to go down one line
		action = getActionByName(StyledEditorKit.downAction);
		key = KeyStroke.getKeyStroke(KeyEvent.VK_N, Event.CTRL_MASK);
		keymap.addActionForKeyStroke(key, action);

		textPane.setKeymap(keymap);
	}

	// Create the edit menu
	protected JMenu createEditMenu() {
		JMenu menu = new JMenu("Edit");

		// Undo and redo are actions of our own creation
		undoAction = new UndoAction();
		menu.add(undoAction);

		redoAction = new RedoAction();
		menu.add(redoAction);

		menu.addSeparator();

		// These actions come from the default editor kit.
		// Get the ones we want and stick them in the menu.
		menu.add(getActionByName(StyledEditorKit.cutAction));
		menu.add(getActionByName(StyledEditorKit.copyAction));
		menu.add(getActionByName(StyledEditorKit.pasteAction));

		menu.addSeparator();

		menu.add(getActionByName(StyledEditorKit.selectAllAction));
		return menu;
	}

	// Create the style menu
	protected JMenu createStyleMenu() {
		JMenu menu = new JMenu("Style");

		Action action = new StyledEditorKit.BoldAction();
		action.putValue(Action.NAME, "Bold");
		menu.add(action);

		action = new StyledEditorKit.ItalicAction();
		action.putValue(Action.NAME, "Italic");
		menu.add(action);

		action = new StyledEditorKit.UnderlineAction();
		action.putValue(Action.NAME, "Underline");
		menu.add(action);

		menu.addSeparator();

		menu.add(new StyledEditorKit.FontSizeAction("12", 12));
		menu.add(new StyledEditorKit.FontSizeAction("14", 14));
		menu.add(new StyledEditorKit.FontSizeAction("18", 18));

		menu.addSeparator();

		menu.add(new StyledEditorKit.FontFamilyAction("Serif", "Serif"));
		menu.add(new StyledEditorKit.FontFamilyAction("SansSerif", "SansSerif"));

		menu.addSeparator();

		menu.add(new StyledEditorKit.ForegroundAction("Red", Color.red));
		menu.add(new StyledEditorKit.ForegroundAction("Green", Color.green));
		menu.add(new StyledEditorKit.ForegroundAction("Blue", Color.blue));
		menu.add(new StyledEditorKit.ForegroundAction("Black", Color.black));

		return menu;
	}

	protected void initDocument() {
		String initString[] = { "Use the mouse to place the caret.",
				"Use the edit menu to cut, copy, paste, and select text.",
				"Also to undo and redo changes.",
				"Use the style menu to change the style of the text.",
				"Use these emacs key bindings to move the caret:",
				"ctrl-f, ctrl-b, ctrl-n, ctrl-p." };

		String[] styleNames = initStyles();

		try {
			JButton button = new JButton("Click me");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (audioClip == null)
						Toolkit.getDefaultToolkit().beep();
					else
						audioClip.play();
				}
			});
			textPane.insertComponent(button);
			lpd.insertString(lpd.getLength(), newline,
					textPane.getStyle(styleNames[0]));
			textPane.insertIcon(new ImageIcon("ExampleSwing/images/Pig.gif"));
			lpd.insertString(lpd.getLength(), newline,
					textPane.getStyle(styleNames[0]));

			for (int i = 0; i < initString.length; i++) {
				lpd.insertString(lpd.getLength(), initString[i] + newline,
						textPane.getStyle(styleNames[i]));
			}
		} catch (BadLocationException ble) {
			System.err.println("Couldn't insert initial text.");
		}
	}

	protected String[] initStyles() {
		// Initialize some styles
		String styleNames[] = { "default", "bold", "italic", "large", "small",
				"red" };

		Style def = textPane
				.addStyle(styleNames[0], textPane.getLogicalStyle());
		StyleConstants.setFontSize(def, 16);
		StyleConstants.setFontFamily(def, "SansSerif");

		Style s = textPane.addStyle(styleNames[1], def);
		StyleConstants.setBold(s, true);

		s = textPane.addStyle(styleNames[2], def);
		StyleConstants.setItalic(s, true);

		s = textPane.addStyle(styleNames[3], def);
		StyleConstants.setFontSize(s, 20);

		s = textPane.addStyle(styleNames[4], def);
		StyleConstants.setFontSize(s, 12);

		s = textPane.addStyle(styleNames[5], def);
		StyleConstants.setForeground(s, Color.red);

		return styleNames;
	}

	// The following two methods allow us to find an
	// action provided by the editor kit by its name.
	private Hashtable createActionTable(JTextComponent textComponent) {
		Hashtable actions = new Hashtable();
		Action[] actionsArray = textComponent.getActions();
		for (int i = 0; i < actionsArray.length; i++) {
			Action a = actionsArray[i];
			actions.put(a.getValue(Action.NAME), a);
		}
		return actions;
	}

	private Action getActionByName(String name) {
		return (Action) (actions.get(name));
	}

	class UndoAction extends AbstractAction {
		public UndoAction() {
			super("Undo");
			setEnabled(false);
		}

		public void actionPerformed(ActionEvent e) {
			try {
				undo.undo();
			} catch (CannotUndoException ex) {
				System.out.println("Unable to undo: " + ex);
				ex.printStackTrace();
			}
			update();
			redoAction.update();
		}

		protected void update() {
			if (undo.canUndo()) {
				setEnabled(true);
				putValue(Action.NAME, undo.getUndoPresentationName());
			} else {
				setEnabled(false);
				putValue(Action.NAME, "Undo");
			}
		}
	}

	class RedoAction extends AbstractAction {
		public RedoAction() {
			super("Redo");
			setEnabled(false);
		}

		public void actionPerformed(ActionEvent e) {
			try {
				undo.redo();
			} catch (CannotRedoException ex) {
				System.out.println("Unable to redo: " + ex);
				ex.printStackTrace();
			}
			update();
			undoAction.update();
		}

		protected void update() {
			if (undo.canRedo()) {
				setEnabled(true);
				putValue(Action.NAME, undo.getRedoPresentationName());
			} else {
				setEnabled(false);
				putValue(Action.NAME, "Redo");
			}
		}
	}

}
