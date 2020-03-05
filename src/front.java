import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.BevelBorder;


public class front extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					front frame = new front();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public front() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.BLACK);
		Image img=new ImageIcon(this.getClass().getResource("/JEE-MAIN-2019-2.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(10, 11, 552, 210);
		contentPane.add(label);
		
		JButton btnRegistration = new JButton("CLICK TO REGISTER");
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup signu=new signup();
				signu.setVisible(true);
				dispose();
			}
		});
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistration.setForeground(Color.WHITE);
		btnRegistration.setBackground(Color.GRAY);
		btnRegistration.setBounds(235, 148, 342, 35);
		contentPane.add(btnRegistration);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login n=new login();
				n.setVisible(true);
				dispose();

			}
		});
		btnLogin.setBounds(235, 211, 342, 33);
		contentPane.add(btnLogin);
		
		JButton btnGetResult = new JButton("GET RESULT");
		btnGetResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				sturesult s=new sturesult();
				s.setVisible(true);
				
			}
		});
		btnGetResult.setBounds(235, 275, 342, 35);
		contentPane.add(btnGetResult);
	
	}
}
