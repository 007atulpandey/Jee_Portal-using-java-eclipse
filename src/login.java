import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;


public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentLoginPage = new JLabel("STUDENT LOGIN PAGE ");
		lblStudentLoginPage.setBackground(new Color(255, 153, 255));
		lblStudentLoginPage.setForeground(Color.GRAY);
		lblStudentLoginPage.setFont(new Font("Book Antiqua", Font.BOLD, 15));
		lblStudentLoginPage.setBounds(182, 27, 207, 33);
		contentPane.add(lblStudentLoginPage);
		
		textField = new JTextField();
		textField.setBounds(375, 93, 150, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stuid=textField.getText();
				String passww=textField_1.getText();
				
				Connection con=dataconnect.getConnection();
				try {
					PreparedStatement ps=con.prepareStatement("select * from STUDENT_DETAIL where id='"+stuid+"'and password='"+passww+"'");
					ResultSet rs=ps.executeQuery();
					
					if(rs.next())
					{

							 JOptionPane.showMessageDialog(null, "YOU R SUCCESSFULLY LOGGED IN", "Message", JOptionPane.INFORMATION_MESSAGE);
							   textField_1.setFocusable(true);

															
								
						
					}
					else
					{

						 JOptionPane.showMessageDialog(null, " register yourself first", "Error", JOptionPane.ERROR_MESSAGE);
						   textField_1.setFocusable(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				studentid id= new studentid();
				id.setVisible(true);
				dispose();
				
				
			}
		});
		btnLogin.setBounds(283, 235, 89, 23);
		contentPane.add(btnLogin);
		
		JLabel lblRollNumber = new JLabel("STU_ID :");
		lblRollNumber.setBounds(252, 96, 102, 17);
		contentPane.add(lblRollNumber);
		
		JLabel lblPassword = new JLabel("PASWORD :");
		lblPassword.setBounds(252, 144, 102, 23);
		contentPane.add(lblPassword);
		
		
		
	
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 63, 214, 225);
		Image img=new ImageIcon(this.getClass().getResource("/JEE-MAIN-2019-2.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		contentPane.add(lblNewLabel_1);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front f=new front();
				f.setVisible(true);
				dispose();
			}
		});
		btnHome.setBounds(410, 235, 89, 23);
		contentPane.add(btnHome);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(375, 145, 150, 20);
		contentPane.add(textField_1);
	}
}
