package bookingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class AdminChangePassword extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField CpasswordField;
	private JPasswordField passwordField;

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
	public AdminChangePassword(int adminID) 
	{
		// create the frame design (GUI) for admin change password page.
		
		setResizable(false);
		setBounds(300, 200, 1003, 414);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create your new password.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel.setBounds(282, 10, 445, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(160, 112, 231, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirm Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1_1.setBounds(160, 198, 274, 33);
		contentPane.add(lblNewLabel_1_1);
		
		CpasswordField = new JPasswordField();
		CpasswordField.setFont(new Font("Tahoma", Font.PLAIN, 31));
		CpasswordField.setBounds(480, 191, 329, 48);
		contentPane.add(CpasswordField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 31));
		passwordField.setBounds(480, 98, 329, 48);
		contentPane.add(passwordField);
		
		//Change Password button - Click to change the account password.
		JButton btnCreate = new JButton("Change Password");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 31));
		btnCreate.setBounds(328, 278, 295, 55);
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Get string for both password and confirm password.
				String password = passwordField.getText();
				String confirm = CpasswordField.getText();
				
				//if statement that use to ensure that the password and confirmation password entered by the administrator are both longer than 5 characters.
				if(password.length()>=6 && confirm.length()>=6)
				{
					try 
					{
						//connect with MySQL database
                        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo",
                        "root", "Wanqian0101");
                        
                        //if statement that use to to ensure that the password and the confirmation password are match. 
                        if(password.equals(confirm))
	                    {
                        	//PreparedStatement interface that updates the password for admin account.
	                  	    PreparedStatement st = (PreparedStatement) connection
	     	                        .prepareStatement("Update admin set password=? where id=?");
	                  	   
	                  	    st.setString(1, password);
		                    st.setInt(2, adminID);
		                    //used to execute the update of the administrative password..
		                    st.executeUpdate();
		                    
		                    //Display a message indicating that the password has been successfully changed.
		                    JOptionPane.showMessageDialog(null, "Password has been successfully changed");
		                    //The current frame will be close.
		                    dispose();
		                   	                  	   
	                     }
	                     else
	                     {
	                    	//Display a message indicating that the password and confirmation password are not match.
	                    	//Ask admin to re-enter the confirmation password.
	                  	    JOptionPane.showMessageDialog(null, "Both of your passwords do not match. Please re-enter your password!");
	                  	    CpasswordField.setText("");
	                     }
                 
					} 
					catch (SQLException sqlException) 
					{
                    sqlException.printStackTrace();
					}
				}
				else
                {
                	JOptionPane.showMessageDialog(null, "New password too short! Please make sure the password is at least 6 character");
                	passwordField.setText("");
                	CpasswordField.setText("");
                }
                
			}
		});
		
	}
}
