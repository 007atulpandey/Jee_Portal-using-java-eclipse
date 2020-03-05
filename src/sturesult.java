 import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.MatteBorder;
import javax.swing.ListSelectionModel;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class sturesult extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sturesult frame = new sturesult();
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
	public sturesult() {
	
		Connection con =dataconnect.getConnection();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table = new JTable();
	
		table.setBorder(new MatteBorder(2, 2, 1, 1, (Color) Color.GRAY));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(10, 71, 414, 160);
		contentPane.add(table);
		
		JLabel lblAllStudentsResult = new JLabel("ALL STUDENTS RESULT");
		lblAllStudentsResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllStudentsResult.setForeground(new Color(188, 143, 143));
		lblAllStudentsResult.setFont(new Font("Gill Sans MT Condensed", Font.BOLD, 15));
		lblAllStudentsResult.setBounds(99, 11, 228, 37);
		contentPane.add(lblAllStudentsResult);
		
		
		 try{
		
		        String sql= "select id,name,maths,physics,chemistry,total,category from student_detail order by total desc";
		   	 PreparedStatement st=con.prepareStatement(sql);
		        ResultSet rs=st.executeQuery();
		        table.setModel(DbUtils.resultSetToTableModel(rs));
		        
		        JLabel lblHome = new JLabel("Home");
		        lblHome.addMouseListener(new MouseAdapter() {
		        	@Override
		        	public void mouseClicked(MouseEvent e) {
		        		front f=new front();
						f.setVisible(true);
		        	}
		        });
		        lblHome.setBounds(378, 251, 46, 14);
		        contentPane.add(lblHome);
		    }catch(Exception e){
		        System.out.println(e);
		    }
	    
	    
	}
}
