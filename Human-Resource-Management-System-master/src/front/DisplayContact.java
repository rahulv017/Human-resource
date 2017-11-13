package front;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Insertno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;

public class DisplayContact extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private int i;
	private static String id;
	public static void main(String[] args) {
		try {
			DisplayContact DisplayContact = new DisplayContact(id);
			DisplayContact.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			DisplayContact.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DisplayContact(String n1) {
		id=n1;
		setBounds(100, 100, 450, 100);
		DisplayContact DisplayContact;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblcontact = new JLabel(" Contact No: ");
			lblcontact.setBounds(20, 12, 100, 15);
			contentPanel.add(lblcontact);
		}
		{
			textField = new JTextField();
			textField.setBounds(115, 7, 258, 25);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enterContact();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonPane.add(btnCancel);
			}
		}
	}

	public void enterContact() {
		String str1 = textField.getText();
			if(str1.length()<10 || str1.length()>11 || ((str1.length()==11) && (str1.charAt(0)!='0'))){
				JOptionPane.showMessageDialog(null, "Invalid mobile no");
			}
			else {
				if(str1.length()==10)
					str1 = '0'+str1.substring(0);
				Insertno h= new Insertno(id,str1); 
				if(h.verify()){
					boolean u = h.add();
					if(u){
						JOptionPane.showMessageDialog(null, "Entry successfully done");
					}else{
						JOptionPane.showMessageDialog(null, "Entry cannot be added");
					}
					CheckContact f = new CheckContact(id);
					f.setVisible(true);
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null, "Number is already stored");
				}
			}
			
	}

}