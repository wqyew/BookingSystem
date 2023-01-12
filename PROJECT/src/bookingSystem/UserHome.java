package bookingSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;

//import net.javaguides.swing.UserLogin;
import net.proteanit.sql.DbUtils;

import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.awt.SystemColor;

public class UserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable Jtable_display;
    private JTextField nameField;
    private JTextField staffIdField;
    private JTextField phoneNoField;
    private JTextField codeField;
    private JTextField courseField;
    private JTextField sizeField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public UserHome() {

    }
    
    
    public UserHome(int userID, String userName) {
    	setTitle("User Home page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(50, 50, 1454, 713);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        
        JLabel label = new JLabel("");
        label.setBounds(62, 223, 0, 0);
        JLabel lblNewLabel = new JLabel("Hi "+userName+"! Welcome to UTHM Examiniation Hall Booking System");
        lblNewLabel.setBounds(10, 10, 1430, 37);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
          
        JLabel label_1 = new JLabel("");
        label_1.setBounds(754, 223, 0, 0);
          
          JLabel label_2 = new JLabel("");
          label_2.setBounds(991, 223, 0, 0);
          
          JLabel label_3 = new JLabel("");
          label_3.setBounds(996, 223, 0, 0);
          contentPane.setLayout(null);
          
          JScrollPane scrollPane = new JScrollPane();
          scrollPane.setBounds(579, 98, 824, 410);
          contentPane.add(scrollPane);
          
  
          Jtable_display = new JTable();
          scrollPane.setViewportView(Jtable_display);
          
           Jtable_display.setForeground(Color.BLACK);
           Jtable_display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           Jtable_display.setFillsViewportHeight(true);
           Jtable_display.setBackground(Color.WHITE);
           Jtable_display.setModel(new DefaultTableModel(
           	new Object[][] {
           	},
           	new String[] {
           	}
           ));
          contentPane.add(label);
          contentPane.add(lblNewLabel);
          contentPane.add(label_1);
          contentPane.add(label_2);
          contentPane.add(label_3);
          
          JLabel lblNewLabel_1 = new JLabel("Please fill in booking detail");
          lblNewLabel_1.setBounds(10, 57, 363, 31);
          lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
          lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
          contentPane.add(lblNewLabel_1);
           
           JLabel lblName = new JLabel("Name");
           lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblName.setBounds(10, 110, 107, 25);
           contentPane.add(lblName);
           
           JLabel lblStaffId = new JLabel("Staff ID");
           lblStaffId.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblStaffId.setBounds(10, 155, 107, 25);
           contentPane.add(lblStaffId);
           
           JLabel lblPhoneNumber = new JLabel("Phone No");
           lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblPhoneNumber.setBounds(10, 200, 107, 25);
           contentPane.add(lblPhoneNumber);
           
           JLabel lblCourseCode = new JLabel("Course Code");
           lblCourseCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblCourseCode.setBounds(10, 245, 107, 25);
           contentPane.add(lblCourseCode);
           
           JLabel lblCourseName = new JLabel("Course Name");
           lblCourseName.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblCourseName.setBounds(10, 290, 107, 25);
           contentPane.add(lblCourseName);
           
           JLabel lblFaculty = new JLabel("Faculty");
           lblFaculty.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblFaculty.setBounds(10, 380, 107, 25);
           contentPane.add(lblFaculty);
           
           JLabel lblYear = new JLabel("Date");
           lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblYear.setBounds(10, 470, 107, 25);
           contentPane.add(lblYear);
           
           JComboBox yearField = new JComboBox();
           yearField.setFont(new Font("Tahoma", Font.PLAIN, 18));
           yearField.setModel(new DefaultComboBoxModel(new String[] {"2023", "2024", "2025", "2026"}));
           yearField.setMaximumRowCount(5);
           yearField.setBounds(137, 470, 82, 25);
           contentPane.add(yearField);
           
           JComboBox monthField = new JComboBox();
           monthField.setFont(new Font("Tahoma", Font.PLAIN, 18));
           monthField.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
           monthField.setMaximumRowCount(12);
           monthField.setBounds(251, 470, 56, 25);
           contentPane.add(monthField);
           
           JComboBox dayField = new JComboBox();
           dayField.setFont(new Font("Tahoma", Font.PLAIN, 18));
           dayField.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
           dayField.setMaximumRowCount(10);
           dayField.setBounds(340, 470, 56, 24);
           contentPane.add(dayField);
           
           JComboBox facultyField = new JComboBox();
           facultyField.setFont(new Font("Tahoma", Font.PLAIN, 18));
           facultyField.setMaximumRowCount(11);
           facultyField.setModel(new DefaultComboBoxModel(new String[] {"FSKTM", "FKEE", "FKMP", "FPTP", "FKAAB", "FAST", "FPTV", "FTK", "PPB", "PPD", "PPUK"}));
           facultyField.setBounds(137, 380, 228, 25);
           contentPane.add(facultyField);
           
           JLabel lblStartTime = new JLabel("Start time");
           lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblStartTime.setBounds(10, 515, 107, 25);
           contentPane.add(lblStartTime);
           
           JLabel lblEndTime = new JLabel("End time");
           lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblEndTime.setBounds(235, 515, 82, 25);
           contentPane.add(lblEndTime);
           
           JComboBox startField = new JComboBox();
           startField.setFont(new Font("Tahoma", Font.PLAIN, 18));
           startField.setModel(new DefaultComboBoxModel(new String[] {"8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"}));
           startField.setMaximumRowCount(14);
           startField.setBounds(137, 515, 66, 25);
           contentPane.add(startField);
           
           JComboBox endField = new JComboBox();
           endField.setFont(new Font("Tahoma", Font.PLAIN, 18));
           endField.setModel(new DefaultComboBoxModel(new String[] {"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"}));
           endField.setMaximumRowCount(14);
           endField.setBounds(330, 515, 66, 25);
           contentPane.add(endField);
           
           JLabel lblNewLabel_2 = new JLabel("Ps: 24 Hours Clock");
           lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
           lblNewLabel_2.setBounds(10, 560, 140, 23);
           contentPane.add(lblNewLabel_2);
           
           JLabel lblClassSize = new JLabel("Class size");
           lblClassSize.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblClassSize.setBounds(10, 335, 107, 25);
           contentPane.add(lblClassSize);
           
           nameField = new JTextField();
           nameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
           nameField.setBounds(137, 110, 413, 25);
           contentPane.add(nameField);
           nameField.setColumns(10);
           
           staffIdField = new JTextField();
           staffIdField.setFont(new Font("Tahoma", Font.PLAIN, 15));
           staffIdField.setColumns(10);
           staffIdField.setBounds(137, 155, 413, 25);
           contentPane.add(staffIdField);
           
           phoneNoField = new JTextField();
           phoneNoField.setFont(new Font("Tahoma", Font.PLAIN, 15));
           phoneNoField.setColumns(10);
           phoneNoField.setBounds(137, 200, 413, 25);
           contentPane.add(phoneNoField);
           
           codeField = new JTextField();
           codeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
           codeField.setColumns(10);
           codeField.setBounds(137, 245, 236, 25);
           contentPane.add(codeField);
           
           courseField = new JTextField();
           courseField.setFont(new Font("Tahoma", Font.PLAIN, 15));
           courseField.setColumns(10);
           courseField.setBounds(137, 290, 236, 25);
           contentPane.add(courseField);
           
           sizeField = new JTextField();
           sizeField.setFont(new Font("Tahoma", Font.PLAIN, 15));
           sizeField.setColumns(10);
           sizeField.setBounds(137, 335, 236, 25);
           contentPane.add(sizeField);
           
           JComboBox venueField = new JComboBox();
           venueField.setModel(new DefaultComboBoxModel(new String[] {"F2 ATAS", "F2 BAWAH", "DSI"}));
           venueField.setFont(new Font("Tahoma", Font.PLAIN, 18));
           venueField.setBounds(137, 425, 150, 25);
           contentPane.add(venueField);
           
           JLabel lblVenue = new JLabel("Venue");
           lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 18));
           lblVenue.setBounds(10, 425, 107, 25);
           contentPane.add(lblVenue);
           
           JLabel lblNewLabel_1_1 = new JLabel("Your Booking List");
           lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
           lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
           lblNewLabel_1_1.setBounds(579, 57, 213, 31);
           contentPane.add(lblNewLabel_1_1);
           
           JLabel lblNewLabel_3 = new JLabel("Note: You can always check your booking status here.");
           lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblNewLabel_3.setBounds(802, 57, 363, 31);
           contentPane.add(lblNewLabel_3);
           
           show_user(userID);
           JButton btnNewButton_1 = new JButton("Confirm Booking");
           btnNewButton_1.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           		String name = nameField.getText();
           		String phoneNumber = phoneNoField.getText();
           		String staffID = staffIdField.getText();
           		String courseCode = codeField.getText();
           		String courseName = courseField.getText();
           		String faculty = facultyField.getSelectedItem().toString();
           		String venue = venueField.getSelectedItem().toString();
           		int year = Integer.parseInt(yearField.getSelectedItem().toString());
           		int month = Integer.parseInt(monthField.getSelectedItem().toString());
           		int day = Integer.parseInt(dayField.getSelectedItem().toString());
           		int start = Integer.parseInt(startField.getSelectedItem().toString());
           		int end = Integer.parseInt(endField.getSelectedItem().toString());
           		int classSize = Integer.parseInt(sizeField.getText());
           		int id = userID;
           		int a = JOptionPane.showConfirmDialog(null, "Please confirm all information correct.");
           		// JOptionPane.setRootFrame(null);
           		if (a == JOptionPane.YES_OPTION ) 
           		{
           		String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
           		String specialCharactersStringAndSpace = "!@#$%&*()'+,-./:;<=>?[]^_` {|}";
           		String number = "01234567890";
           		boolean result1 = false, result2 = false, result3 = false,result4 = false,result5 = false;
    	        for (int i=0; i < name.length() ; i++)
    	        {
    	            char ch = name.charAt(i);
    	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
    	            	result1 = true;
    	            	break;
    	            }
    	            else if(i == name.length()-1) { 
    	            	result1 = false;
    	            }
           		}   
    	        
    	        for (int i=0; i < phoneNumber.length() ; i++)
    	        {
    	            char ch = phoneNumber.charAt(i);
    	            int no = phoneNumber.length();
    	            if(no < 10 || no > 11)
    	            {
    	            	result2=true;
    	            	break;
    	            }
    	            else if(specialCharactersStringAndSpace.contains(Character.toString(ch)) || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
    	            	result2 = true;
    	            	break;
    	            }
    	            else if(i == phoneNumber.length()-1 ) {    
    	            	result2 = false;
    	            }
    	            
           		}   
    	        
    	        for (int i=0; i < staffID.length() ; i++)
    	        {
    	            char ch = staffID.charAt(i);
    	            if(specialCharactersStringAndSpace.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
    	            	result3 = true;
    	            	break;
    	            }
    	            else if(i == staffID.length()-1) { 
    	            	result3 = false;
    	            }
           		}   
    	        
    	        
    	        for (int i=0; i < courseCode.length() ; i++)
    	        {
    	            char ch = courseCode.charAt(i);
    	            int no = courseCode.length();
    	            if(specialCharactersStringAndSpace.contains(Character.toString(ch))) {
    	            	result4 = true;
    	            	break;
    	            }
    	            else if(i == courseCode.length()-1) { 
    	            	result4 = false;
    	            }
    	            else if (no != 8)
    	            {
    	            	result4= true;
    	            }
           		}   
    	        
    	        for (int i=0; i < courseName.length() ; i++)
    	        {
    	            char ch = courseName.charAt(i);
    	            if(specialCharactersString.contains(Character.toString(ch)) || number.contains(Character.toString(ch))) {
    	            	result5 = true;
    	            	break;
    	            }
    	            else if(i == courseName.length()-1) { 
    	            	result5 = false;
    	            }
           		} 
  	      
    	        if (result1 == true || result2 == true || result3 == true || result4 == true || result5 == true) 
    	        {
	    	        JOptionPane.showMessageDialog(null, "Error! Please input correct booking info");
           		}	
    	        
    	        else if (start>=end) {
    	        	 JOptionPane.showMessageDialog(null, "Error! Please select correct time and date");
    	        }
    	        else if (year%4 == 0 && month == 2 && day >29 )
    	        {
    	        	JOptionPane.showMessageDialog(null, "Error! Please select correct time and date");
    	        }
    	        else if (year%4 != 0 && month ==2 && day>28)
    	        {
    	        	JOptionPane.showMessageDialog(null, "Error! Please select correct time and date");
    	        }
    	        else if (month ==4 || month == 6 || month == 9 || month == 11 && day>30)
    	        {
    	        	JOptionPane.showMessageDialog(null, "Error! Please select correct time and date");
    	        }  	            	           
    	        else 
    	        {
	             try {

	                 Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo",
	                     "root", "Wanqian0101");
	                
	                 PreparedStatement st = (PreparedStatement) con.prepareStatement("insert into bookingdetail (Name, PhoneNumber, StaffId, CourseCode, CourseName, Faculty, Year, Month, Day, Start, End, ClassSize,userID, venue) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	
	                 st.setString(1, name);
	                 st.setString(2, phoneNumber);
	                 st.setString(3, staffID);
	                 st.setString(4, courseCode);
	                 st.setString(5, courseName);
	                 st.setString(6, faculty);
	                 st.setInt(7, year);
	                 st.setInt(8, month);
	                 st.setInt(9, day);
	                 st.setInt(10, start);
	                 st.setInt(11, end);
	                 st.setInt(12, classSize);
	                 st.setInt(13, id);  
	                 st.setString(14, venue);
	                 st.executeUpdate();
	                 JOptionPane.showMessageDialog(null, "Booking successfully! Your request is processing");   
	                 
	                 UserHome el = new UserHome(userID, userName);
	                 dispose();
	                 el.setVisible(true);
	             	} catch (SQLException sqlException) {
	             			sqlException.printStackTrace();
	             	}
    	        }}
           	}});
           btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
           btnNewButton_1.setBounds(206, 560, 227, 39);
           contentPane.add(btnNewButton_1);
           
           JButton cancelButton = new JButton("Cancel Booking");
           cancelButton.setBackground(UIManager.getColor("Button.background"));
           cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
           cancelButton.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           	 try {
                 Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo",
                     "root", "Wanqian0101");
                 int row = Jtable_display.getSelectedRow();
                 String value =(Jtable_display.getModel().getValueAt(row, 0).toString());
                 int a = JOptionPane.showConfirmDialog(null, "Are you sure to cancel this booking?");
                 // JOptionPane.setRootFrame(null);
                 if (a == JOptionPane.YES_OPTION) {               
                 String query = "DELETE FROM bookingdetail where bookingID = "+value;
                 PreparedStatement st = (PreparedStatement) con.prepareStatement(query);
                 st.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Cancel booking successfully!"); 
                 show_user(userID);
                 }
         	} catch (SQLException sqlException) {
     			sqlException.printStackTrace();
     	}                
           	}});
           cancelButton.setBounds(579, 560, 227, 39);
           contentPane.add(cancelButton);
           
           JButton ChangePassButton = new JButton("Change Password\r\n");
           ChangePassButton.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
                    UserChangePassword bo = new UserChangePassword(userID);
                    bo.setTitle("Change Password");
                    bo.setVisible(true);
           	}
           });
           ChangePassButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
           ChangePassButton.setBackground(UIManager.getColor("Button.background"));
           ChangePassButton.setBounds(882, 560, 227, 39);
           contentPane.add(ChangePassButton);
           
           JButton logOutButton = new JButton("Log Out");
           logOutButton.addActionListener(new ActionListener() {
           	public void actionPerformed(ActionEvent e) {
           		int a = JOptionPane.showConfirmDialog(null, "Are you sure to log out?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    UserLogin obj = new UserLogin();
                    obj.setTitle("Student-Login");
                    obj.setVisible(true);
                }
               
           	}
           });
           logOutButton.setForeground(Color.BLACK);
           logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
           logOutButton.setBackground(UIManager.getColor("Button.background"));
           logOutButton.setBounds(1176, 560, 227, 39);
           contentPane.add(logOutButton);
           
           JLabel lblNewLabel_3_1 = new JLabel("Warning: Please make sure all infomation correct. \r\n");
           lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblNewLabel_3_1.setBounds(45, 609, 466, 31);
           contentPane.add(lblNewLabel_3_1);
           
           JLabel lblNewLabel_3_1_1 = new JLabel("After confirm ,you can't update the information.\r\n");
           lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
           lblNewLabel_3_1_1.setBounds(106, 635, 302, 31);
           contentPane.add(lblNewLabel_3_1_1);
    }
    
 
    
    public void show_user(int userID) {
    	try 
 		{
    		Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3006/swing_demo",
                    "root", "Wanqian0101");
 			// SELECT * mean SELECT ALL    	
 			String query = "SELECT * FROM bookingdetail where UserID= ? ";
 			
 			PreparedStatement st = connection.prepareStatement(query);
			// rs is use to load the table model
 			st.setInt(1, userID);
 			ResultSet rs = st.executeQuery();
 			//converted with the help of this DbUtils class my result set into a model 
 			Jtable_display.setModel(DbUtils.resultSetToTableModel(rs));
 			st.close();
 			rs.close();
 		} 
 		catch (Exception e1) 
 		{
			e1.printStackTrace();
 		}
    }
}