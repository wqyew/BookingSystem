package bookingSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class UserLogin extends JFrame {
	/**
	 * Create the frame.
	 */
	private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
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
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 100, 1014, 598);
        setTitle("Login");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("UTHM EXAMINATION HALL BOOKING SYSTEM");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        lblNewLabel.setBounds(10, 10,980, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 200, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 325, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(216, 200, 193, 68);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(216, 325, 193, 68);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(589, 446, 281, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) { 
            	//Login
            	UserAcc account = new UserAcc();
                account.setName(textField.getText());
                account.setPassword(passwordField.getText());
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo", "root", "Wanqian0101");

                    PreparedStatement st = (PreparedStatement) connection.prepareStatement("Select * from user where name=? and password=?");
                    
                    st.setString(1, account.getName());
                    st.setString(2, account.getPassword());
          
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) {
                    	account.setId(rs.getInt("id")) ;
                        dispose();
                        UserHome ho = new UserHome(account.getId(), account.getName());
                        ho.setVisible(true);
                        JOptionPane.showMessageDialog(null, "You have successfully logged in");
                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Username & Password");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });

        JButton btnNewButton_1 = new JButton("Click here to sign up");
        btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
        btnNewButton_1.setForeground(Color.BLUE);
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton_1.setBounds(138, 446, 281, 73);
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {  //      		
                    UserSignUp el = new UserSignUp();
                    dispose();
                    el.setVisible(true);
        	}
        	});
        
        contentPane.add(btnNewButton);
        contentPane.add(btnNewButton_1);
        
        JLabel lblNewLabel_1 = new JLabel("User Login");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(Color.BLACK);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 35));
        lblNewLabel_1.setBounds(282, 100, 429, 76);
        contentPane.add(lblNewLabel_1);
    }
    

}