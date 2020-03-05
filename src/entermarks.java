import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;


public class entermarks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnSubmit;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					entermarks frame = new entermarks();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String s;
	ResultSet rs=null;
	   Connection con=null;
	/**
	 * Create the frame.
	 */
	public entermarks() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Your MARKS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Snap ITC", Font.BOLD, 14));
		lblNewLabel.setBounds(99, 21, 233, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentId = new JLabel("Student ID :");
		lblStudentId.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblStudentId.setBounds(63, 55, 101, 23);
		contentPane.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(185, 56, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JButton btnCheck = new JButton("CHECK");
		btnCheck.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		s=textField.getText();
		
				con=dataconnect.getConnection();
				
				try {
					PreparedStatement ps =con.prepareStatement("select * from student_detail where id ='"+s+"'");
					rs=ps.executeQuery();
					
					if(rs.next())
	   				{
	   					btnSubmit.setEnabled(true);
	   					
	   				
	   				}
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
			
				
				
				
				
				
				
				
			}
		});
		btnCheck.setFont(new Font("Tempus Sans ITC", Font.BOLD, 12));
		btnCheck.setForeground(new Color(139, 69, 19));
		btnCheck.setBounds(195, 87, 89, 23);
		contentPane.add(btnCheck);
		
		JLabel lblMaths = new JLabel("Maths :");
		lblMaths.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblMaths.setBounds(63, 150, 83, 20);
		contentPane.add(lblMaths);
		
		JLabel lblPhysics = new JLabel("Physics :");
		lblPhysics.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblPhysics.setBounds(63, 181, 83, 20);
		contentPane.add(lblPhysics);
		
		JLabel lblChemistry = new JLabel("Chemistry :");
		lblChemistry.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblChemistry.setBounds(63, 215, 83, 20);
		contentPane.add(lblChemistry);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 151, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setEnabled(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m,p,c;
				m=Integer.parseInt(textField_1.getText());
					p=Integer.parseInt(textField_2.getText());
					c=Integer.parseInt(textField_3.getText());
				if(m>120||p>120||c>120)
				{
					JOptionPane.showMessageDialog(null,"enter marks in range");
				}
				else
				{
					PreparedStatement ps;
				try {
					int total=m+p+c;
					
					ps = con.prepareStatement("update student_detail  set maths = "+m+",physics = "+p+",chemistry="+c+",total="+total+" where id='"+s+"'");

					ps.executeQuery();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
		JOptionPane.showMessageDialog(null, "Your marks successfullly entered !!!!!");
				}
		front f=new front();
		f.setVisible(true);
		dispose();
			}
		});
		btnSubmit.setForeground(new Color(0, 100, 0));
		btnSubmit.setFont(new Font("Stencil", Font.BOLD, 12));
		btnSubmit.setBounds(329, 216, 89, 23);
		contentPane.add(btnSubmit);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(185, 182, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(185, 216, 86, 20);
		contentPane.add(textField_3);
		
		lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				front f=new front();
				f.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(410, 11, 46, 23);
		contentPane.add(lblNewLabel_1);
	}
}
