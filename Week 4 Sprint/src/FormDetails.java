import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormDetails {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormDetails window = new FormDetails();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormDetails() {
		initialize();
	}

	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Create a variable  for the connection string.
				String connectionUrl = "jdbc:sqlserver://localhost:1433;" + 
				"databaseName= ShaqBumz;integratedSecurity=true;";
				
				// Declare the JDBC Objects.
				Connection con = null;
				Statement stmt = null;
				
				
				try  {
					 // Establish the connection.
					 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					 	con = DriverManager.getConnection(connectionUrl);
					 	
					 	// Get input from user.
					 	
					 	String stdName = (JOptionPane.showInputDialog("Please Enter Student's Name"));

						String stdSurname = (JOptionPane.showInputDialog("Please Enter Student's Surname"));

						String stdDOB = (JOptionPane.showInputDialog("Please Enter Student's DOB (yyyy/mm/dd)"));

						String stdGender = (JOptionPane.showInputDialog("Please Enter Student's Gender"));

						int stdGrade = Integer.parseInt(JOptionPane.showInputDialog("Please Enter Student's Grade"));

						String prtName = (JOptionPane.showInputDialog("Please Enter Parents's Name"));

						String prtSurname = (JOptionPane.showInputDialog("Please Enter Parents's Surname"));

						String prtCell = (JOptionPane.showInputDialog("Please Enter Parents's Cellphone Number"));

						String prtAddress = (JOptionPane.showInputDialog("Please Enter Parents's Address"));

						String prtNumKidsEnrolled = (JOptionPane.showInputDialog("Please Enter No. Parents's Kids Enrolled "));
					 	
					 	// Create and execute an SQL statement that returns some data
						String SQL = "INSERT INTO [dbo].[StudentInfo] ([stdName],[stdSurname],[stdDOB],[stdGender],[stdGrade],[prtName],[prtSurname],[prtCell],[prtAddress],[prtNumKidsEnrolled]) VALUES ('" + stdName + "','" + stdSurname + "','" + stdDOB + "'," + "'"
								+ stdGender + "','" + stdGrade + "','" + prtName + "','" + prtSurname + "','" + prtCell + "','"
								+ prtAddress + "'," + "'" + prtNumKidsEnrolled + "')";
						
					 	stmt = con.createStatement();
					 	stmt.execute(SQL);
					 
					 
					
				}
				
				catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(170, 113, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
