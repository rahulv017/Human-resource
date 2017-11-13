package front;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Check extends JFrame {
	private static String id="";
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Check frame = new Check(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Check(String n1) {
		id=n1;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDoYouWant = new JLabel("Do You Want To Continue !!");
		lblDoYouWant.setBounds(101, 49, 321, 53);
		contentPane.add(lblDoYouWant);

		JButton btnYes = new JButton(" YES ");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Dialog dialog = new Dialog(id);
					dialog.setVisible(true);
					setVisible(false);
				} catch (Exception et) {
					et.printStackTrace();
				}
			}
		});
		btnYes.setBounds(80, 125, 117, 25);
		contentPane.add(btnYes);

		JButton btnNo = new JButton(" NO ");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				setVisible(false);
			}
		});
		btnNo.setBounds(209, 125, 117, 25);
		contentPane.add(btnNo);
	}
}
