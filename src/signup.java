import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class signup extends JFrame {
private  ButtonGroup radioButtonGroup;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JDateChooser dateChooser;
	private JComboBox comboBox ;
	private String cm;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String cat;
	Connection con=null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	/**
	 * Create the frame.
	 */
	public int generate_rollno(){
		int y = 0;
		try {
			String query = "SELECT * FROM student_detail";
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			if(rs.next()){
				do{
					y++;
				}while(rs.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return y;
		
	}
	
	
	public signup() {
	
		con=dataconnect.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/newone.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(24, 60, 138, 171);
		contentPane.add(lblNewLabel);
		
		JLabel lblRegistrationForm = new JLabel("REGISTRATION FORM  ");
		lblRegistrationForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrationForm.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 15));
		lblRegistrationForm.setBounds(95, 22, 365, 27);
		contentPane.add(lblRegistrationForm);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(172, 93, 85, 21);
		contentPane.add(lblName);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setBounds(172, 125, 85, 21);
		contentPane.add(lblContact);
		
		JLabel lblDob = new JLabel("DOB :");
		lblDob.setBounds(172, 167, 85, 14);
		contentPane.add(lblDob);
		
		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setBounds(172, 200, 85, 14);
		contentPane.add(lblGender);
		
		textField = new JTextField();
		textField.setBounds(279, 93, 194, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		 
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(279, 125, 194, 21);
		contentPane.add(textField_2);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(276, 196, 58, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(351, 196, 71, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setBounds(429, 196, 109, 23);
		contentPane.add(rdbtnOthers);
	 radioButtonGroup = new ButtonGroup();
		    radioButtonGroup.add(rdbtnMale);
		    radioButtonGroup.add(rdbtnFemale);
		    radioButtonGroup.add(rdbtnOthers);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(172, 238, 85, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 235, 194, 20);
		contentPane.add(passwordField);
		
		JLabel lblEmail = new JLabel("Email  :");
		lblEmail.setBounds(173, 275, 84, 14);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(279, 272, 194, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	//getting valuess
			@SuppressWarnings("deprecation")
			int countt=0;
			String passw=passwordField.getText();
			String combo = comboBox.getSelectedItem().toString();
				String dob = "";
				String number=textField_2.getText();
				String s=textField.getText().toString();
				
		
			String emaill=textField_1.getText();
			String gender="";
			Enumeration <AbstractButton> bg=radioButtonGroup.getElements();
			JRadioButton jrd=(JRadioButton)bg.nextElement();
			if(jrd.isSelected())
			{
				gender=gender+jrd.getText();
				System.out.println(gender);
			}
			///^[a-zA-Z '.-]*$/    ^[a-zA-Z]+\\.?
				if (!(Pattern.matches("^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)", textField.getText()))) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid character", "Error", JOptionPane.ERROR_MESSAGE);
				   textField.setFocusable(true);
				   countt++;
				    }
				if (!(Pattern.matches("^[0-9]{1  0}$", textField_2.getText()))) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid MOBILE NUMBER", "Error", JOptionPane.ERROR_MESSAGE);
				   textField.setFocusable(true);
				   countt++;
				    }
				if (!(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", textField_1.getText()))) {
				    JOptionPane.showMessageDialog(null, "Please enter a valid email address", "Error", JOptionPane.ERROR_MESSAGE);
				   textField_1.setFocusable(true);
				   countt++;  }
				try
				{
				 dob=dob+(( JTextField ) dateChooser.getDateEditor().getUiComponent()).getText();
			
				String studate[]=dob.split("/");
				
				//combo Box
			cm=(String)comboBox.getSelectedItem();
              System.out.println(cm);
				 
				int year_stu=Integer.parseInt(studate[2]);
			
			 int yearr=2019;
			 int a=yearr-year_stu;
			 if(a>24 ||a<17 )
			 {
				 JOptionPane.showMessageDialog(null, "You are not eligible for registration", "Error", JOptionPane.ERROR_MESSAGE);
				   textField_1.setFocusable(true);
				 
			 }
			 System.out.println(a);}
				catch (Exception e1)
				{
					System.out.println(e1);
				}
			
			 //connection and sql query
				
				System.out.println(combo);System.out.println(dob);
				System.out.println(passw);
				
		
				
					try {
						int no_of_rows = generate_rollno()+1;
						DecimalFormat df = new DecimalFormat("000");
						String roll = "20JM1"+df.format(no_of_rows);
						System.out.println(roll);
				PreparedStatement ps=con.prepareStatement("insert into student_detail(id,name,contact,dob,gender,email,password,maths,physics,chemistry,total,category) values('"+roll+"','"+s+"','"+number+"','"+dob+"','"+gender+"','"+emaill+"','"+passw+"',0,0,0,0,'"+cm+"')");
						 	
				if(countt==0)
						{ps.executeQuery();
						
						JOptionPane.showMessageDialog(null,roll);
						}
				else
				{
					JOptionPane.showMessageDialog(null, "Fill Your Information correctly");
				}
						
					
					} catch (SQLException e2) {
						// TODO Auto-generated catch bloc
						System.out.println(e2);
					}
					
				
		
				
			
				
				
			 
			 front f=new front();
			 f.setVisible(true);
			 dispose();
			}
			
		});
		btnSubmit.setBounds(172, 354, 96, 23);
		contentPane.add(btnSubmit);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front f=new front();
				f.setVisible(true);
			}
		});
		btnHome.setBounds(333, 354, 96, 23);
		contentPane.add(btnHome);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setBounds(172, 311, 85, 14);
		contentPane.add(lblCategory);
		
	 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select any one ", "Gen.", "OBC ", "SC/ST", "PWD"}));
		comboBox.setBounds(279, 308, 194, 20);
		contentPane.add(comboBox);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/mm/yyyy");
		dateChooser.setBounds(279, 161, 194, 20);
		contentPane.add(dateChooser);
	}
}
