package utils;

import javax.swing.JOptionPane;

public abstract class Display {
	public static String dialogueInput(String prompt) {
		return JOptionPane.showInputDialog(prompt);
	}

	public static void messageBox(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static boolean confirmBox(String message) {
		return 1 == JOptionPane.showConfirmDialog(null, message);
	}
}
