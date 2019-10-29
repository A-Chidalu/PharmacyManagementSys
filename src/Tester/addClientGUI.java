package Tester;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Client;

import javax.swing.JButton;
import javax.swing.JComboBox;

public class addClientGUI extends JFrame {
	private JTextField Cname_Field;
	private JTextField C;
	private JTextField Cemail_Field;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addClientGUI clientWindow = new addClientGUI();
					 clientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			            clientWindow.pack();
			            clientWindow.setLocationRelativeTo(null);
			            clientWindow.setVisible(true);
			            clientWindow.setBounds(100, 100, 1318, 719);    
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public addClientGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setLayout(null);
		
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientName.setBounds(98, 82, 228, 57);
		getContentPane().add(lblClientName);
		
		Cname_Field = new JTextField();
		Cname_Field.setBounds(338, 94, 320, 36);
		getContentPane().add(Cname_Field);
		Cname_Field.setColumns(10);
		
		JLabel lblClientAdderUi = new JLabel("Client Adder UI");
		lblClientAdderUi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblClientAdderUi.setBounds(240, 13, 228, 47);
		getContentPane().add(lblClientAdderUi);
		
		C = new JTextField();
		C.setColumns(10);
		C.setBounds(338, 164, 320, 36);
		getContentPane().add(C);
		
		JLabel lblClient = new JLabel("Client ID:");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClient.setBounds(98, 152, 228, 57);
		getContentPane().add(lblClient);
		
		JLabel lblClientDrugs = new JLabel("Client Drugs:");
		lblClientDrugs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientDrugs.setBounds(98, 244, 228, 57);
		getContentPane().add(lblClientDrugs);
		
		JComboBox drug_List = new JComboBox();
		drug_List.setEditable(true);
		drug_List.setBounds(482, 263, 121, 22);
		getContentPane().add(drug_List);
		
		JLabel lblClientEmail = new JLabel("Client Email:");
		lblClientEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientEmail.setBounds(98, 341, 228, 57);
		getContentPane().add(lblClientEmail);
		
		Cemail_Field = new JTextField();
		Cemail_Field.setColumns(10);
		Cemail_Field.setBounds(338, 353, 320, 36);
		getContentPane().add(Cemail_Field);
		
		JButton btnNewButton = new JButton("Submit Client!");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Cname_Field.getText().isEmpty() || Cemail_Field.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(btnNewButton, "Please Enter all Information and try again.");
				}
				else {
					Client Temp = Client.create(Cname_Field.getText(), Cemail_Field.getText());
					JOptionPane.showMessageDialog(btnNewButton, "You have sucessfully Created a new Client with" + "\n" + "name: " + Temp.getClient() 
					+ "\n" + " And email: " + "\n" +  Temp.getEmail());
				}
				
				
			}
		});
		btnNewButton.setBounds(257, 411, 211, 56);
		getContentPane().add(btnNewButton);
	}
}
