import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
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


public class getsturesult extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel label_1;
	private JLabel lblCategory;
	private JLabel label;
	private JLabel label_2;
	private  JLabel lblNewLabel;
	private JLabel lblCongratulationYouAre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getsturesult frame = new getsturesult();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String s;
	String cat;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	/**
	 * Create the frame.
	 */
	public getsturesult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("RESULT ");
		lblResult.setFont(new Font("French Script MT", Font.BOLD, 20));
		lblResult.setForeground(new Color(128, 0, 0));
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(136, 11, 144, 42);
		contentPane.add(lblResult);
		
		JLabel lblStudentId = new JLabel("Student ID :");
		lblStudentId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStudentId.setBounds(49, 64, 89, 22);
		contentPane.add(lblStudentId);
		
		textField = new JTextField();
		textField.setBounds(157, 64, 111, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JButton btnGetResult = new JButton("Get Result");
		btnGetResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 s=textField.getText();
				con=dataconnect.getConnection();
				try {
					PreparedStatement q=con.prepareStatement("select *from student_detail order by total desc");
					ResultSet r=q.executeQuery();
					int rank=0;
					while(r.next())
					{rank++;
						if(r.getString("id").equals(s))
						{
							cat=r.getString("category");
							break;
						}
					}
					
					ps =con.prepareStatement("select * from student_detail where id ='"+s+"'");
					rs=ps.executeQuery();
					if(rs.next())
					{
						lblCongratulationYouAre.setText("");
						lblNewLabel_1.setText(rs.getString("name"));
						lblNewLabel_3.setText(rs.getString("dob"));
						
						label.setText(Integer.toString(rs.getInt("total")));
						lblNewLabel.setText(Integer.toString(rank));
						if(rank==1)
						{
						lblCongratulationYouAre.setText("congratulation you are rank 1");
						}
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					PreparedStatement ps=con.prepareStatement("select *from student_detail  where category='"+cat+"' order by total desc");
					ResultSet rs =ps.executeQuery();
					int count=0;
					while(rs.next())
					{count++;
						if(rs.getString("id").equals(s))
						{
							break;
						}
					}
					label_1.setText(cat);
					label_2.setText(Integer.toString(count));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGetResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGetResult.setForeground(new Color(139, 0, 0));
		btnGetResult.setBounds(291, 63, 105, 23);
		contentPane.add(btnGetResult);
		
		JLabel lblRankair = new JLabel("RANK  (AIR ) :");
		lblRankair.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRankair.setBounds(20, 228, 89, 22);
		contentPane.add(lblRankair);
		
		 lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(119, 229, 61, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblTotal = new JLabel("TOTAL :");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotal.setForeground(new Color(0, 128, 0));
		lblTotal.setBounds(236, 209, 55, 14);
		contentPane.add(lblTotal);
		
		 label = new JLabel("");
		label.setBounds(291, 209, 89, 22);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(49, 121, 60, 14);
		contentPane.add(lblName);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(119, 121, 166, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("DOB :");
		lblNewLabel_2.setBounds(49, 146, 60, 20);
		contentPane.add(lblNewLabel_2);
		
		 lblCategory = new JLabel("Category :");
		lblCategory.setBounds(49, 180, 60, 22);
		contentPane.add(lblCategory);
		
		 lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(119, 149, 161, 14);
		contentPane.add(lblNewLabel_3);
	
		label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(136, 184, 144, 14);
		contentPane.add(label_1);
		
		lblCongratulationYouAre = new JLabel("");
		lblCongratulationYouAre.setForeground(new Color(0, 128, 0));
		lblCongratulationYouAre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCongratulationYouAre.setHorizontalAlignment(SwingConstants.CENTER);
		lblCongratulationYouAre.setBounds(190, 236, 234, 14);
		contentPane.add(lblCongratulationYouAre);
		
		JLabel lblGoToHome = new JLabel("Go To  HOME");
		lblGoToHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGoToHome.setForeground(new Color(128, 0, 0));
		lblGoToHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoToHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				front f=new front ();
				f.setVisible(true);
				dispose();
				
				
			}
		});
		lblGoToHome.setBounds(320, 11, 104, 29);
		contentPane.add(lblGoToHome);
		
		JLabel lblCategoryRank = new JLabel("Category Rank  :");
		lblCategoryRank.setBounds(20, 210, 105, 14);
		contentPane.add(lblCategoryRank);
		
		label_2 = new JLabel("");
		label_2.setBounds(106, 209, 46, 20);
		contentPane.add(label_2);
	}
}
