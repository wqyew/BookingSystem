package bookingSystem;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import net.javaguides.swing.ChangePass;
//import net.javaguides.swing.UserLogin;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.SystemColor;

public class AdminHome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableBooking;
	private JScrollPane scrollPane;
	private JButton btnReset;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	
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
					AdminHome frame = new AdminHome();
					frame.setTitle("Admin Home");
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}
	
	Connection connection ;
	PreparedStatement st;
	ResultSet rs;
	
	public AdminHome() 
	{
		
	}
	
	public AdminHome(int adminID) 
	{
		// create the frame design (GUI) for admin home page
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1454, 780);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("List of Booking Details");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(868, 22, 271, 35);
        contentPane.add(lblNewLabel);
         
        JLabel lblNewLabel_1 = new JLabel("Booking ID");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(10, 52, 124, 35);
        contentPane.add(lblNewLabel_1);
         
        JLabel lblNewLabel_1_1 = new JLabel("Name");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(10, 142, 124, 35);
        contentPane.add(lblNewLabel_1_1);
         
        JLabel lblNewLabel_1_2 = new JLabel("Phone Number");
        lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_2.setBounds(10, 187, 124, 35);
        contentPane.add(lblNewLabel_1_2);
         
        JLabel lblNewLabel_1_3 = new JLabel("Staff ID");
        lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_3.setBounds(10, 232, 124, 35);
        contentPane.add(lblNewLabel_1_3);
         
        JLabel lblNewLabel_1_4 = new JLabel("Course Code");
        lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_4.setBounds(10, 277, 124, 35);
        contentPane.add(lblNewLabel_1_4);
         
        JLabel lblNewLabel_1_5 = new JLabel("Course Name");
        lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_5.setBounds(10, 322, 124, 35);
        contentPane.add(lblNewLabel_1_5);
         
        JLabel lblNewLabel_1_6 = new JLabel("Faculty");
        lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_6.setBounds(10, 367, 124, 35);
        contentPane.add(lblNewLabel_1_6);
         
        JLabel lblNewLabel_1_7 = new JLabel("Date");
        lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_7.setBounds(10, 412, 124, 35);
        contentPane.add(lblNewLabel_1_7);
         
        JLabel lblNewLabel_1_10 = new JLabel("Start Time");
        lblNewLabel_1_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_10.setBounds(10, 457, 124, 35);
        contentPane.add(lblNewLabel_1_10);
         
        JLabel lblNewLabel_1_11 = new JLabel("End Time");
        lblNewLabel_1_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_11.setBounds(10, 502, 124, 35);
        contentPane.add(lblNewLabel_1_11);
        
        JLabel lblNewLabel_1_12 = new JLabel("Class Size");
        lblNewLabel_1_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_12.setBounds(10, 547, 124, 35);
        contentPane.add(lblNewLabel_1_12);
         
        JLabel lblNewLabel_1_13 = new JLabel("Venue");
        lblNewLabel_1_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_13.setBounds(10, 592, 124, 35);
        contentPane.add(lblNewLabel_1_13);
         
        JLabel lblNewLabel_1_14 = new JLabel("Status");
        lblNewLabel_1_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_14.setBounds(10, 637, 124, 35);
        contentPane.add(lblNewLabel_1_14);
         
        textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setEditable(false);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField.setBounds(159, 52, 316, 35);
        contentPane.add(textField);
        textField.setColumns(10);
         
        textField_1 = new JTextField();
        textField_1.setBackground(Color.WHITE);
        textField_1.setEditable(false);
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_1.setColumns(10);
        textField_1.setBounds(159, 142, 316, 35);
        contentPane.add(textField_1);
         
        textField_2 = new JTextField();
        textField_2.setBackground(Color.WHITE);
        textField_2.setEditable(false);
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_2.setColumns(10);
        textField_2.setBounds(159, 187, 316, 35);
        contentPane.add(textField_2);
         
        textField_3 = new JTextField();
        textField_3.setBackground(Color.WHITE);
        textField_3.setEditable(false);
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_3.setColumns(10);
        textField_3.setBounds(159, 232, 316, 35);
        contentPane.add(textField_3);
         
        textField_4 = new JTextField();
        textField_4.setBackground(Color.WHITE);
        textField_4.setEditable(false);
        textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_4.setColumns(10);
        textField_4.setBounds(159, 277, 316, 35);
        contentPane.add(textField_4);
        
        textField_5 = new JTextField();
        textField_5.setBackground(Color.WHITE);
        textField_5.setEditable(false);
        textField_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_5.setColumns(10);
        textField_5.setBounds(159, 322, 316, 35);
        contentPane.add(textField_5);
         
        textField_6 = new JTextField();
        textField_6.setBackground(Color.WHITE);
        textField_6.setEditable(false);
        textField_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_6.setColumns(10);
        textField_6.setBounds(159, 367, 316, 35);
        contentPane.add(textField_6);
         
        textField_7 = new JTextField();
        textField_7.setBackground(Color.WHITE);
        textField_7.setEditable(false);
        textField_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_7.setColumns(10);
        textField_7.setBounds(159, 412, 82, 35);
        contentPane.add(textField_7);
         
        textField_8 = new JTextField();
        textField_8.setBackground(Color.WHITE);
        textField_8.setEditable(false);
        textField_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_8.setColumns(10);
        textField_8.setBounds(274, 412, 82, 35);
        contentPane.add(textField_8);
         
        textField_9 = new JTextField();
        textField_9.setBackground(Color.WHITE);
        textField_9.setEditable(false);
        textField_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_9.setColumns(10);
        textField_9.setBounds(393, 412, 82, 35);
        contentPane.add(textField_9);
         
        textField_10 = new JTextField();
        textField_10.setBackground(Color.WHITE);
        textField_10.setEditable(false);
        textField_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_10.setColumns(10);
        textField_10.setBounds(159, 457, 316, 35);
        contentPane.add(textField_10);
         
        textField_11 = new JTextField();
        textField_11.setBackground(Color.WHITE);
        textField_11.setEditable(false);
        textField_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_11.setColumns(10);
        textField_11.setBounds(159, 502, 316, 35);
        contentPane.add(textField_11);
         
        textField_12 = new JTextField();
        textField_12.setBackground(Color.WHITE);
        textField_12.setEditable(false);
        textField_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_12.setColumns(10);
        textField_12.setBounds(159, 547, 316, 35);
        contentPane.add(textField_12);
         
        textField_13 = new JTextField();
        textField_13.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_13.setEditable(false);
        textField_13.setColumns(10);
        textField_13.setBackground(Color.WHITE);
        textField_13.setBounds(159, 592, 316, 35);
        contentPane.add(textField_13);
         
        textField_14 = new JTextField();
        textField_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
        textField_14.setEditable(false);
        textField_14.setColumns(10);
        textField_14.setBackground(Color.WHITE);
        textField_14.setBounds(159, 97, 316, 35);
        contentPane.add(textField_14);
         
        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(SystemColor.inactiveCaption);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Approve", "Reject"}));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
        comboBox.setBounds(159, 638, 316, 32);
        contentPane.add(comboBox);
         
        JLabel lblNewLabel_2 = new JLabel("Booking Details");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_2.setBounds(145, 10, 187, 35);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1_14_1 = new JLabel("UserID");
        lblNewLabel_1_14_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_14_1.setBounds(10, 97, 124, 35);
        contentPane.add(lblNewLabel_1_14_1);
        
        JLabel lblNewLabel_3 = new JLabel("-");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_3.setBounds(251, 417, 26, 23);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("-");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
        lblNewLabel_3_1.setBounds(366, 417, 26, 23);
        contentPane.add(lblNewLabel_3_1);
        
        //Display Data button - click to refresh the table showing the list of booking details. 
        JButton btnShow = new JButton("Display Data");
        btnShow.setBounds(518, 686, 177, 35);
        contentPane.setLayout(null);
        btnShow.setFont(new Font("Tahoma", Font.PLAIN, 18));
        contentPane.add(btnShow);
        btnShow.addActionListener(new ActionListener() 
        {
         	public void actionPerformed(ActionEvent e) 
         	{
         		//call out display data method
         		display();
         	}
        }); 
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(518, 64, 912, 575);
        contentPane.add(scrollPane);
        tableBooking = new JTable();
        scrollPane.setViewportView(tableBooking);
        //Just click on a row in the table and the data for that row will be displayed where it is already prepared.
        scrollPane.addMouseListener(new MouseAdapter() 
        {
         	@Override
         	public void mouseClicked(MouseEvent e) 
         	{
	         	// Call out the displayRow() method.
	    	  	displayRow();
         	}
         });
     
         //Reset Data button - Click to delete the list of all booking details from the database.
         btnReset = new JButton("Reset Data");
         btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
         btnReset.setBounds(760, 686, 177, 35);
         contentPane.add(btnReset);
         btnReset.addActionListener(new ActionListener() 
         {
         	public void actionPerformed(ActionEvent e) 
         	{
         		// Call out the deleteAll() method.
                deleteAll();                       		
         	}
         });         
         
         //Update Status button - Click to update the status whether approve or reject the booking of exam hall.
         JButton btnNewButton = new JButton("Update Status");
         btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
         btnNewButton.setBounds(169, 686, 177, 35);
         contentPane.add(btnNewButton);
         btnNewButton.addActionListener(new ActionListener() 
         {
         	public void actionPerformed(ActionEvent e) 
         	{
         		//get the selected row from the table displayed.
         		int row = tableBooking.getSelectedRow();
         		String selection = tableBooking.getModel().getValueAt(row, 0).toString();
         		
         		// Update the status of the reservation according to the table row selected by the administrator.
         		String query = "UPDATE bookingdetail set "
								+ "Status = '" +comboBox.getSelectedItem()+ "' WHERE bookingID = " + selection;
         		
         		try 
         		{   
         			//connect with MySQL database
         			connection = DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo","root", "Wanqian0101");
         			// PreparedStatement interface that update the status of a booking.
         			st = connection.prepareStatement(query);
         			st.execute();
         			
         			//Display a message indicating that the status has been updated.
         			JOptionPane.showMessageDialog(null, "Data Updated");
         			//call out the display() method to refresh the table.
         			display();
           		}
         		catch(Exception e3)
         		{
         			//Display a message indicating that failed to update status.
         			JOptionPane.showMessageDialog(null, "Failed to update status. Please try again!");
         		}
         	}
         });
         
         //Logout button - Click to logout from the system and will return to admin login page.
         JButton btnLogOut = new JButton("Logout");
         btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 18));
         btnLogOut.setBounds(1253, 686, 177, 35);
         contentPane.add(btnLogOut);
         btnLogOut.addActionListener(new ActionListener() 
         {
         	public void actionPerformed(ActionEvent e) 
         	{
         		//Call out the logout() method.
         		logout();
            }
         });
        
         //Change Password button - Click to change the account password.
         JButton btnChange = new JButton("Change Password"); 
         btnChange.setFont(new Font("Tahoma", Font.PLAIN, 18));
         btnChange.setBounds(1007, 686, 177, 35);
         contentPane.add(btnChange); 
         btnChange.addActionListener(new ActionListener() 
         {
         	public void actionPerformed(ActionEvent e) 
         	{
         		AdminChangePassword cp = new AdminChangePassword(adminID);
                cp.setTitle("Change Password");
                cp.setVisible(true);
         	}
         });
                            
         display();
	}
	
	//method to display all the booking records of the user.
	public void display() 
	{
		try 
 		{
 			connection = DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo","root", "Wanqian0101");
 			// SELECT * mean SELECT ALL
 			String query = "SELECT * FROM bookingdetail";
 			st = connection.prepareStatement(query);
			// rs is use to load the table model
 			rs = st.executeQuery();
 			//converted with the help of this DbUtils class my result set into a model 
 			tableBooking.setModel(DbUtils.resultSetToTableModel(rs));
 			// sorting of the rows on a particular column
 			tableBooking.setAutoCreateRowSorter(true);

 			st.close();
 			rs.close();
 		} 
 		catch (Exception ex) 
 		{
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	
	//method that allows administrators to select rows of a table and display information by clicking on them.
	public void displayRow()
	{
		int row = tableBooking.getSelectedRow();
	  	String selection = tableBooking.getModel().getValueAt(row, 0).toString();
	  	// SELECT * mean SELECT ALL data from database.
	  	//When the bookingID is equal to the bookingID of the selected row, all data of the row is retrieve from the database.
	  	String query = "SELECT * FROM bookingdetail WHERE bookingID = " + selection;
	  	
	  	try
	  	{
	  		// PreparedStatement interface that retrieve the records of a table
	  		st = connection.prepareStatement(query);
	  		//used to execute statements that returns tabular data
	  		rs = st.executeQuery();
	  		
	  		if(rs.next())
	  		{
	  			//Get the data for each column of the selected row from the database.
	  			textField.setText(rs.getString("bookingID"));
	  			textField_1.setText(rs.getString("Name"));
	  			textField_2.setText(rs.getString("PhoneNumber"));
	  			textField_3.setText(rs.getString("StaffId"));
	  			textField_4.setText(rs.getString("CourseCode"));
	  			textField_5.setText(rs.getString("CourseName"));
	  			textField_6.setText(rs.getString("Faculty"));
	  			textField_7.setText(rs.getString("Year"));
	  			textField_8.setText(rs.getString("Month"));
	  			textField_9.setText(rs.getString("Day"));
	  			textField_10.setText(rs.getString("Start"));
	  			textField_11.setText(rs.getString("End"));
	  			textField_12.setText(rs.getString("ClassSize"));
	  			textField_13.setText(rs.getString("Venue"));
	  			textField_14.setText(rs.getString("UserID"));
	  		}
     	}
	  	catch(Exception e1)
	  	{
	  		JOptionPane.showMessageDialog(null, e1);
	  	}
	}
	
	//method to delete all the booking records of the user in the database.
	public void deleteAll()
	{
		// Display a message to re-confirm whether the administrator wants to delete all booking detail records in the database.
 		int a = JOptionPane.showConfirmDialog(null, "Are you sure to reset the data?");
        // If the administrator clicks "Yes", all the booking details records will be deleted.
        if (a == JOptionPane.YES_OPTION) 
        {
            // The admin will return to the admin home page.
            AdminHome obj = new AdminHome();
            obj.setTitle("Admin-Home");
            obj.setVisible(true);
            
            try
            {
            	////connect with MySQL database
     			connection = DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo","root", "Wanqian0101");
     			
     			// PreparedStatement interface that retrieve the records of a table.
     			String query = "DELETE FROM bookingdetail";
         		st = connection.prepareStatement(query);
         		st.execute();
         		
         		//Display a message indicating that all data has been deleted.
         		JOptionPane.showMessageDialog(null, "All Data Deleted");
         		st.close();
         		display();
            }
            catch (Exception e2)
            {
 			e2.printStackTrace();
            }
        }
	}
	
	//method that allows administrators to logout from the system and return to admin login page.
	public void logout()
	{
		//Display a message to re-confirm whether the admin want to logout from the system.
		int a = JOptionPane.showConfirmDialog(null, "Are you sure to log out?");
		//If the administrator clicks "Yes", the administrator will be logged out from the system.
        if (a == JOptionPane.YES_OPTION) 
        {
            dispose();
            // The admin will return to the admin login page.
            AdminLogin obj = new AdminLogin();
            obj.setTitle("Admin-Login");
            obj.setVisible(true);
        }
	}
}
