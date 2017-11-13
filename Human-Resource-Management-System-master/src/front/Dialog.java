package front;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Insertemail;
import control.Login;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;

public class Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private int i;
	private static String id="";
	public static void main(String[] args) {
		try {
			Dialog dialog = new Dialog(id);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dialog(String n1) {
		id=n1;
		setBounds(100, 100, 450, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblEmail = new JLabel(" EMAIL : ");
			lblEmail.setBounds(35, 12, 70, 15);
			contentPanel.add(lblEmail);
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
						enterEmail();
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

	public void enterEmail() {
		String str1 = textField.getText();
		for (i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == '@') {
				break;
			}
		}
		String str2 = str1.substring(i + 1);
		System.out.println(str2);
		if (!str2.equals("gmail.com") && !str2.equals("yahoo.com")) {
			JOptionPane.showMessageDialog(null, "Email ID invalid");
		}else{
			Insertemail y = new Insertemail(id,str1);
			if(y.verify()){
				boolean r=y.add();
				if(r){
					JOptionPane.showMessageDialog(null, "Entry successfully added");
				}else{
					JOptionPane.showMessageDialog(null, "Entry cannot be added");
				}
				Check f = new Check(id);
				f.setVisible(true);
				setVisible(false);
			}else{
				JOptionPane.showMessageDialog(null, "Entry is already done");
			}
		}
	}
}