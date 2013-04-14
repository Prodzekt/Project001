package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import wspolne.IPrzychodniaSerwis;

public class Panel extends JPanel {
	private JTextField textField;
	
	public String getTextField0() {
		return textField.getText();
	}
	public String getTextField1() {
		return textField_2.getText();
	}

	public void setTextField(String t) {
		this.textField.setText(t);
	}
	public void setTextField2(String t) {
		this.textField_1.setText(t);
	}


	private JTextField textField_1;
	private JTextField textField_2;

	public String wyswietl(String a)
	{
		return a;
	}
	/**p
	 * Create the panel.
	 */
	public Panel() 
	{
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton();
		btnNewButton.setText("Zaloguj");
		btnNewButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				String login = getTextField0();
				String haslo = getTextField1();
				System.out.println(login);
				System.out.println(haslo);
				//if(login==l && haslo==h)
					setTextField2("dziala!");
				//else
					//{System.out.println("qqqqqqqqqqqqqqqqqq");}
					int registryPort = 8000;
					IPrzychodniaSerwis ps=null;
					 try {
						ps = (IPrzychodniaSerwis)Naming.lookup("//localhost:"+registryPort+"/dServer");
					} catch (MalformedURLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NotBoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						ps.login(login, haslo);
						System.out.println(ps.getDesc());
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					repaint();
		
			}
			
		});

		
		
		JTextPane txtpnLogin = new JTextPane();
		txtpnLogin.setEditable(false);
		txtpnLogin.setText("Login");
		
		JTextPane txtpnHaslo = new JTextPane();
		txtpnHaslo.setEditable(false);
		txtpnHaslo.setText("Haslo");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(189)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtpnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnHaslo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textField_2)
						.addComponent(textField)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(161, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(193)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtpnHaslo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(201, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
