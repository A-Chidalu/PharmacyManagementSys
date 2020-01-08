package Tester;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Client;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ItemEvent;

public class addClientGUI extends JFrame {
	private JTextField Cname_Field;
	private JTextField Cid_Field;
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
		Cname_Field.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Cname_Field.setBounds(338, 94, 320, 36);
		getContentPane().add(Cname_Field);
		Cname_Field.setColumns(10);
		
		JLabel lblClientAdderUi = new JLabel("Client Adder UI");
		lblClientAdderUi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblClientAdderUi.setBounds(240, 13, 228, 47);
		getContentPane().add(lblClientAdderUi);
		
		Cid_Field = new JTextField();
		Cid_Field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Cid_Field.setColumns(10);
		Cid_Field.setEditable(false);
		Cid_Field.setBounds(338, 164, 320, 36);
		getContentPane().add(Cid_Field);
		Cid_Field.setText("ID Automatically Generated on Sumission!");
		
		JLabel lblClient = new JLabel("Client ID:");
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClient.setBounds(98, 152, 228, 57);
		getContentPane().add(lblClient);
		
		JLabel lblClientDrugs = new JLabel("Client Drugs: (Choose 1 or More)");
		lblClientDrugs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientDrugs.setBounds(98, 244, 320, 57);
		getContentPane().add(lblClientDrugs);
		

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("Drugs Going in to the Users Drug Databse:" + "\n");
		textArea_1.setBounds(800, 236, 300, 65);
		getContentPane().add(textArea_1);
		
		
		
		String[] avalibleDrugs = null;
		try {
			Connection con = DB.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT drug_Name FROM drug_table");
			ResultSet rs = ps.executeQuery();
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();
			
			avalibleDrugs = new String[rows];
			int counter = 0;
			while(rs.next()) {
				avalibleDrugs[counter] = rs.getString("drug_name");
				counter++;
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
		
		JComboBox<String> drug_List = new JComboBox<>(avalibleDrugs);
		drug_List.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {
				Object item = event.getItem();
				 if (event.getStateChange() == ItemEvent.SELECTED) {
					 	textArea_1.setText("Drugs Going in to the Users Drug Databse:" + "\n" + item.toString() + " selected.");
	                }

	                if (event.getStateChange() == ItemEvent.DESELECTED) {
	                    textArea_1.setText(item.toString() + " deselected.");
	                }
			}
		});
		
		final JList list = new JList(drug_List.getModel());
		ArrayList<String> selectedItems = new ArrayList<>();
		drug_List.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedItems.add((String)drug_List.getSelectedItem());		
			}
		});
		drug_List.setEditable(true);
		drug_List.setBounds(482, 263, 121, 22);
		getContentPane().add(drug_List);
		
		JLabel lblClientEmail = new JLabel("Client Email:");
		lblClientEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblClientEmail.setBounds(98, 341, 228, 57);
		getContentPane().add(lblClientEmail);
		
		Cemail_Field = new JTextField();
		Cemail_Field.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
				
				try {
					Connection con = DB.getConnection();
					PreparedStatement ps = con.prepareStatement("INSERT INTO drug_table VALUES(?,?,?)");
					ps.setString(1, Cname_Field.getText());
					ps.setString(2, Cemail_Field.getText());
					ps.setInt(3, selectedItems.size());
					
					con.close();
					
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				
				
			}
		});
		btnNewButton.setBounds(257, 411, 211, 56);
		getContentPane().add(btnNewButton);
		

	}
}
