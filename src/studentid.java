import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.SwingConstants;

public class studentid extends JFrame {
	private JPanel contentPane;

	private String id;
	private JLabel label ;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton btnEnterMarks ;
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentid frame = new studentid();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

String name;
String contact,email;
private JTextField textField;
	/**
	 * Create the frame.
	 */

	public studentid() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblName.setBounds(47, 110, 46, 23);
		contentPane.add(lblName);
		
		JLabel lblRollNo = new JLabel("Roll No.:");
		lblRollNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRollNo.setBounds(47, 144, 60, 14);
		contentPane.add(lblRollNo);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContact.setBounds(47, 168, 60, 23);
		contentPane.add(lblContact);
		
		JLabel lblGender = new JLabel("Email :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGender.setBounds(47, 202, 60, 14);
		contentPane.add(lblGender);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		
		lblNewLabel_2.setBounds(286, 93, 96, 113);
		contentPane.add(lblNewLabel_2);
		
		btnEnterMarks = new JButton("Enter Marks");
		btnEnterMarks.setEnabled(false);
		btnEnterMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				entermarks a=new entermarks();
				a.setVisible(true);
				dispose();
			}
		});
		btnEnterMarks.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEnterMarks.setBounds(36, 243, 119, 23);
		contentPane.add(btnEnterMarks);
		
		JButton btnGetYourResult = new JButton("Get Your Result");
		btnGetYourResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getsturesult rst=new getsturesult();
				rst.setVisible(true);
				dispose();
			}
		});
		btnGetYourResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGetYourResult.setBounds(199, 243, 157, 23);
		contentPane.add(btnGetYourResult);
		
		JLabel lblStudentId = new JLabel("Student id :");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStudentId.setBounds(43, 22, 96, 18);
		contentPane.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(163, 20, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id=textField.getText();
System.out.println(id);
				Connection con=dataconnect.getConnection();
				try {
					PreparedStatement ps=con.prepareStatement("select name,id,contact,email from student_detail where id ='"+id+"'");
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
				      name=rs.getString("name");
				      System.out.println(name);
				      contact=rs.getString("contact");
				 
				    email=rs.getString("email");
				     
				    label_2.setText(contact);
				      label.setText(name);
				      label_1.setText(id);
				      label_3.setText(email);
				      btnEnterMarks.setEnabled(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
		        
				
			}
		});
		btnCheck.setForeground(new Color(178, 34, 34));
		btnCheck.setFont(new Font("Stencil", Font.PLAIN, 11));
		btnCheck.setBounds(316, 19, 89, 23);
		contentPane.add(btnCheck);
		
		label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(118, 110, 107, 23);
		contentPane.add(label);
		
		 label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(117, 135, 96, 23);
		contentPane.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(117, 168, 100, 23);
		contentPane.add(label_2);
		
		 label_3 = new JLabel("");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(127, 203, 135, 14);
		contentPane.add(label_3);
		

		
	
		
		
	}
}
