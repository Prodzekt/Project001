package UI;
import javax.swing.*;

public class Trigger extends JFrame {

	public Trigger() {
		super("Java");

		JPanel buttonPanel = new Panel();
		add(buttonPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}