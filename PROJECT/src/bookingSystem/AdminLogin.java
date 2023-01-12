package bookingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AdminLogin extends JFrame 
{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
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
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminLogin() {
		
		// create the frame design (GUI) for admin login page
		
		setTitle("Admin Login ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 1014, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1.setBounds(200, 208, 150, 41);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
		lblNewLabel_1_1.setBounds(200, 297, 150, 41);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 31));
		textField.setColumns(10);
		textField.setBounds(439, 194, 321, 68);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 31));
		passwordField.setColumns(10);
		passwordField.setBounds(439, 283, 321, 68);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("UTHM EXAMINATION HALL BOOKING SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel.setBounds(10, 0, 980, 93);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Admin Login");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblNewLabel_1_2.setBounds(291, 92, 429, 76);
		contentPane.add(lblNewLabel_1_2);		
		
		// Login button - Click this button to navigate to the admin home page
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnLogin.setBounds(550, 429, 281, 73);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() 
		{
            public void actionPerformed(ActionEvent e) 
            {
            	// call out login() method
            	login();	
            }
        });
		
		// Sign Up button - Click this button to navigate to the admin sign up page
		JButton btnSignUp = new JButton("Click here to Sign Up");
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnSignUp.setBounds(170, 429, 281, 73);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AdminSignUp as = new AdminSignUp();
				dispose();
				as.setVisible(true);
			}
		});
		
	}
	
	// Reads the username and password entered by the administrator and then checks to see if the username and password exist or match.
	public void login()
	{
		//Get string for both name and password.
		AdminAcc admin = new AdminAcc();
    	admin.setName(textField.getText());
    	admin.setPassword(passwordField.getText());
        
        try 
        {
        	//connect with MySQL database
            Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo",
                "root", "Wanqian0101");
            
            // PreparedStatement interface that retrieve the records of a table.
            // SELECT * mean SELECT ALL
            PreparedStatement st = (PreparedStatement) connection
                .prepareStatement("SELECT * FROM admin where name=? and password=?");

            //1 specifies the first parameter in the query i.e. name.
            st.setString(1, admin.getName());
            //2 specifies the second parameter in the query i.e. password.
            st.setString(2, admin.getPassword());
            //used to execute statements that returns tabular data.
            ResultSet rs = st.executeQuery();
            
            //shifts the cursor to the next row of the result set from the database.
            if (rs.next()) 
            {
            	//get admin id.
            	admin.setId(rs.getInt("id"));
            	int adminID = rs.getInt("id");
            	//The current frame will be close.
                dispose();
                
                // If both username and password exist and match, then go to the admin home page.
                AdminHome a1 = new AdminHome(admin.getId());
                a1.setTitle("Admin Home");
                a1.setVisible(true);
                
                //Display a message indicating that the admin has successfully logged in.
                JOptionPane.showMessageDialog(null, "You have successfully logged in");
            } 
            else 
            {
            	//Display a message indicating that username and password entered was wrong.
                JOptionPane.showMessageDialog(null, "Wrong Username & Password");
            }
        } 
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        }
	}
}
