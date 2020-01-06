package Tester;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addDrugGUI extends JFrame {
	private JTextField drugName_tf;
	private JTextField drugPrice_tf;
	private JTextField drugQuantity_tf;
	
	public addDrugGUI() {
		getContentPane().setLayout(null);
		
		JLabel add_new_drug = new JLabel("Add New Drug");
		add_new_drug.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add_new_drug.setBounds(368, 11, 234, 47);
		getContentPane().add(add_new_drug);
		
		JLabel drugName_lbl = new JLabel("Drug Name:");
		drugName_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		drugName_lbl.setBounds(70, 72, 136, 34);
		getContentPane().add(drugName_lbl);
		
		JLabel drugPrice_lbl = new JLabel("Drug Price:");
		drugPrice_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		drugPrice_lbl.setBounds(70, 136, 136, 34);
		getContentPane().add(drugPrice_lbl);
		
		JLabel drugQuantity_lbl = new JLabel("Drug Quantity:");
		drugQuantity_lbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		drugQuantity_lbl.setBounds(70, 203, 136, 34);
		getContentPane().add(drugQuantity_lbl);
		
		drugName_tf = new JTextField();
		drugName_tf.setBounds(175, 73, 203, 37);
		getContentPane().add(drugName_tf);
		drugName_tf.setColumns(10);
		
		drugPrice_tf = new JTextField();
		drugPrice_tf.setColumns(10);
		drugPrice_tf.setBounds(175, 136, 203, 37);
		getContentPane().add(drugPrice_tf);
		
		drugQuantity_tf = new JTextField();
		drugQuantity_tf.setColumns(10);
		drugQuantity_tf.setBounds(175, 203, 203, 37);
		getContentPane().add(drugQuantity_tf);
		
		JButton submitDrug = new JButton("Submit New Drug!");
		submitDrug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(drugName_tf.getText().isEmpty() || drugPrice_tf.getText().isEmpty() || drugQuantity_tf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(submitDrug, "Please Enter all Information and try again.");
				}
				String dName = drugName_tf.getText();
				//Casting the user entered price to an int for simplicity
				
				int dPrice = (int) Double.parseDouble(drugPrice_tf.getText());
				int dQuantity = (int) Double.parseDouble(drugQuantity_tf.getText());
				
				//Now Create a new Row in the database for this drug
				int i = AddDrugDBHelper.save(dName, dPrice, dQuantity);
				if(i > 0) {
					JOptionPane.showMessageDialog(submitDrug, "Drug Was Successfully Added to The dataBase!");
				}
				else {
					JOptionPane.showMessageDialog(submitDrug, "Sorry, Drug Was not Sucessfully added to database!");
				}
				
			}
		});
		submitDrug.setFont(new Font("Tahoma", Font.PLAIN, 14));
		submitDrug.setBounds(542, 125, 219, 56);
		getContentPane().add(submitDrug);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
