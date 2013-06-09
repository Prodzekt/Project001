package UI;
import java.awt.EventQueue;
import java.awt.SystemColor;


import javax.swing.*;

public class Trigger extends JFrame {

	public Trigger() {
		//super("Java");
		this.setLayout(null);
		this.setBounds(100, 100, 500, 500);
		this.setTitle("Java Przychodnia");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBackground(SystemColor.inactiveCaptionText);
		
		JPanel buttonPanel;
		buttonPanel = new Panel();
		setResizable(false);
		buttonPanel.setBounds(0, 0, 500, 500);
		setResizable(false);
		
		
		add(buttonPanel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack();
		//setVisible(true);
	}
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Trigger().setVisible(true);
            }
        });
    }
}