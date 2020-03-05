import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JToggleButton;


public class marks extends JFrame {

	private static final String DISABLE ="DISABLE";
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marks frame = new marks();
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
	public marks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 427, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourMarks = new JLabel("ENTER YOUR MARKS ");
		lblEnterYourMarks.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourMarks.setFont(new Font("Impact", Font.PLAIN, 15));
		lblEnterYourMarks.setBounds(105, 11, 212, 46);
		contentPane.add(lblEnterYourMarks);
		
		JLabel lblPhysics = new JLabel("PHYSICS  :");
		lblPhysics.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPhysics.setBounds(148, 89, 93, 31);
		contentPane.add(lblPhysics);
		
		textField = new JTextField();
		textField.setBounds(286, 95, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblChemistry = new JLabel("CHEMISTRY :");
		lblChemistry.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChemistry.setBounds(148, 128, 96, 20);
		contentPane.add(lblChemistry);
		
		textField_1 = new JTextField();
		textField_1.setBounds(286, 126, 100, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMaths = new JLabel("MATHS :");
		lblMaths.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaths.setBounds(148, 168, 93, 14);
		contentPane.add(lblMaths);
		
		textField_2 = new JTextField();
		textField_2.setBounds(286, 166, 100, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=dataconnect.getConnection();
				int math,phy,chem;
				math=Integer.parseInt(textField_2.getText());
				phy=Integer.parseInt(textField.getText());
				String str=textField_3.getText();
				chem=Integer.parseInt(textField_1.getText());
				ResultSet r=null;
				PreparedStatement p=null;
				try {
					p = con.prepareStatement("select * from student_detail where id='"+str+"'");
					r=p.executeQuery();
					if(r.next())
					{
					try {
						PreparedStatement ps=con.prepareStatement("insert into student_detail select maths,physics,chemistry  values("+math+","+phy+","+chem+") where id='"+str+"'");
					ResultSet rs=ps.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"your marks are submitted");
					}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
					}
					else
						JOptionPane.showMessageDialog(null,"enter valid data");
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			
				
					
				
			}
		});
		btnSubmit.setBounds(232, 226, 106, 23);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("");
		Image img=new ImageIcon(this.getClass().getResource("/exam.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		lblNewLabel.setBounds(0, 38, 128, 103);
		contentPane.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				front f=new front ();
				f.setVisible(true);
			}
		});
		btnHome.setBounds(83, 226, 89, 23);
		contentPane.add(btnHome);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblId.setBounds(148, 56, 93, 31);
		contentPane.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(286, 56, 100, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	
	}
}
