package Tester;

import Model.Client;

import java.awt.EventQueue;
import Model.Client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PharmacyGUIMain {

	private JFrame frame;
	private JTextField searchClientField;
	private JTextField searchDrugField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PharmacyGUIMain window = new PharmacyGUIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PharmacyGUIMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1318, 719);     
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClientSearch = new JLabel("Client Search");
		lblClientSearch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblClientSearch.setBounds(175, 186, 289, 97);
		frame.getContentPane().add(lblClientSearch);
		
		JLabel lblDrugSearch = new JLabel("Drug Search");
		lblDrugSearch.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDrugSearch.setBounds(868, 186, 289, 97);
		frame.getContentPane().add(lblDrugSearch);
		
		searchClientField = new JTextField();
		searchClientField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		searchClientField.setBounds(40, 312, 247, 44);
		frame.getContentPane().add(searchClientField);
		searchClientField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search Client");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				
			}
		});
		btnNewButton.setBounds(322, 307, 218, 44);
		frame.getContentPane().add(btnNewButton);
		
		searchDrugField = new JTextField();
		searchDrugField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		searchDrugField.setColumns(10);
		searchDrugField.setBounds(690, 312, 247, 44);
		frame.getContentPane().add(searchDrugField);
		
		JButton btnSearchDrug = new JButton("Search Drug");
		btnSearchDrug.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSearchDrug.setBounds(989, 307, 218, 44);
		frame.getContentPane().add(btnSearchDrug);
		
		JButton btnNewButton_1 = new JButton("Add new Client");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClientGUI clientWindow = new addClientGUI();
				 clientWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		            clientWindow.pack();
		            clientWindow.setLocationRelativeTo(null);
		            clientWindow.setVisible(true);
		            clientWindow.setBounds(75, 75, 1000, 600);    
			}
		});
		btnNewButton_1.setBounds(96, 544, 389, 97);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnAddNewDrug = new JButton("Add new Drug");
		btnAddNewDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDrugGUI drugWindow = new addDrugGUI();
				drugWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				drugWindow.pack();
				drugWindow.setLocationRelativeTo(null);
				drugWindow.setVisible(true);
				drugWindow.setBounds(75, 75, 1000, 600);   
			}
		});
		btnAddNewDrug.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAddNewDrug.setBounds(768, 544, 389, 97);
		frame.getContentPane().add(btnAddNewDrug);
		
		JLabel lblNewLabel = new JLabel("Pharmacy Master UI");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(322, 13, 585, 122);
		frame.getContentPane().add(lblNewLabel);
	}
}
