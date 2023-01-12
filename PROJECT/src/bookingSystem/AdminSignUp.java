package bookingSystem;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminSignUp extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_code;
	private JPasswordField passwordField_pass;
	private JPasswordField passwordField_cPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					AdminSignUp frame = new AdminSignUp();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminSignUp() 
	{
		
		//create the frame design (GUI) for admin sign up page
		setTitle("Admin Sign Up");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 1014, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAdminSignUp = new JLabel("Admin \r\nSign Up Page");
		lblAdminSignUp.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblAdminSignUp.setBounds(325, 0, 360, 70);
		contentPane.add(lblAdminSignUp);
		
		JLabel lblName = new JLabel("Username");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblName.setBounds(109, 104, 150, 41);
		contentPane.add(lblName);
		
		JLabel lblCode = new JLabel("Security Code");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblCode.setBounds(109, 182, 265, 41);
		contentPane.add(lblCode);
		
		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblPass.setBounds(109, 260, 205, 41);
		contentPane.add(lblPass);
		
		JLabel lblConPass = new JLabel("Confirm Password");
		lblConPass.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblConPass.setBounds(109, 338, 273, 41);
		contentPane.add(lblConPass);
		
		JLabel lblNewLabel = new JLabel("Note* Please get the security code from your supervisor.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(109, 419, 429, 27);
		contentPane.add(lblNewLabel);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("Tahoma", Font.PLAIN, 31));
		textField_name.setColumns(10);
		textField_name.setBounds(418, 90, 461, 68);
		contentPane.add(textField_name);
		
		textField_code = new JTextField();
		textField_code.setFont(new Font("Tahoma", Font.PLAIN, 31));
		textField_code.setColumns(10);
		textField_code.setBounds(418, 168, 461, 68);
		contentPane.add(textField_code);
		
		passwordField_pass = new JPasswordField();
		passwordField_pass.setFont(new Font("Tahoma", Font.PLAIN, 31));
		passwordField_pass.setColumns(10);
		passwordField_pass.setBounds(418, 246, 461, 68);
		contentPane.add(passwordField_pass);
		
		passwordField_cPass = new JPasswordField();
		passwordField_cPass.setFont(new Font("Tahoma", Font.PLAIN, 31));
		passwordField_cPass.setColumns(10);
		passwordField_cPass.setBounds(418, 324, 461, 68);
		contentPane.add(passwordField_cPass);
		
		//The button that can be clicked to register an account.
		JButton btnSignUp = new JButton("Click here to sign up");
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnSignUp.setBounds(553, 475, 340, 58);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AdminAcc adm1 = new AdminAcc();
				
				//Get string for name, password, confirmation password and security code.
				adm1.setName(textField_name.getText()); 
				adm1.setPassword(passwordField_pass.getText());
				String code = textField_code.getText();
	            String confirm = passwordField_cPass.getText();
	            
	          //if statement that use to ensure that the username and password entered by the administrator are both longer than 5 characters.
	            if(adm1.getName().length()>=6 && adm1.getPassword().length() >= 6) 
		    	{
	            	 //if statement that use to ensure the security code entered by the admin are equal to the 'uthmExamHall'.
			    	 if(code.equals("uthmExamHall"))
		             {
			    		//Set the security code to 'uthmExamHall'.
						adm1.setSecurityCode("uthmExamHall");
						
						//if statement that use to to ensure that the password and the confirmation password are match.
						if(adm1.getPassword().equals(confirm))
				    	{
				             try 
				             {	 
				            	 System.out.println("The username is " + adm1.getName());	                	
					             Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo",
					                        "root", "Wanqian0101");
					             
					             //PreparedStatement interface that inserts the new admin username and password.      
					             PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into admin (name, password, securityCode) values (?,?,?)");
					             st.setString(1, adm1.getName());
					             st.setString(2, adm1.getPassword());
					             st.setString(3, adm1.getSecurityCode());
					             
					             st.execute();
					             //Display a message indicating that account has been successfully created.
					             JOptionPane.showMessageDialog(null, "Sign up successfully");
					             
					             //After successfully sign up, the admin will go to the admin login page.
					             AdminLogin a = new AdminLogin();
					             //This frame (admin sign up page) will be close.
					             dispose();
					             a.setVisible(true);
				                    
				             } 
				             catch (SQLException sqlException) 
				             {
				            	 sqlException.printStackTrace();
				             }
				    	 }
				    	 else
				    	 {	 
				    		//Display a message indicating that both password and confirmation password are not match.
				    		 JOptionPane.showMessageDialog(null, "Both password do not match! Please re-enter the password");
				    		 passwordField_cPass.setText("");
				    	 }
		               }
		               else
		               {
		            	   //Display a message indicating that the security code entered are incorrect..
		            	   JOptionPane.showMessageDialog(null, "Your security code is incorrect");
		            	   textField_code.setText("");
		               }
		    	 }
		    	 else
		    	 {
		    		 //Display a message indicating that username or password are not enough characters.
		    		 JOptionPane.showMessageDialog(null, "Username or password too short! These should be at least 6 characters");
		    	 }
		    }
            
		});
		;
		
		//The button that can be clicked to return the admin login page.
		JButton btnBack = new JButton("Back to log in");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnBack.setBounds(107, 475, 340, 58);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//return to admin login page.
				AdminLogin al = new AdminLogin();
				//Admin sign up page will be close.
	            dispose();
	            al.setVisible(true);
			}
		});
		
		
	}
}
