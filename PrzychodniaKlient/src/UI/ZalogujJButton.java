package UI;
import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

class ZalogujJButton extends JButton implements ActionListener {

	private Panel zaloguj;
	String l="sss";
	String h="sss";
	

	ZalogujJButton(Panel panel) {
		super("Zaloguj");
		this.zaloguj = panel;
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
			String login = zaloguj.getTextField0();
			String haslo = zaloguj.getTextField1();
			System.out.println(login);
			System.out.println(haslo);
			if(login==l && haslo==h)
				zaloguj.setTextField2("dziala!");
			else
				{System.out.println("qqqqqqqqqqqqqqqqqq");}
			zaloguj.repaint();
				
	}
}