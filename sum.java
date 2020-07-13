import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class sum implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JRadioButton rb1,rb2;
	JComboBox cb1;
	JButton b1;
	ButtonGroup bg = new ButtonGroup();
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.postgresql.Driver";  
	static final String DB_URL = "jdbc:postgresql://localhost:5433/Government Funds";

	//  Database credentials
	static final String USER = "postgres";
	static final String PASS = "Shravan@123";
	
	
	Connection conn = null;
	Statement stmt = null;

	public void actionPerformed(ActionEvent ae){
		try{
			//STEP 2: Register JDBC driver
			Class.forName("org.postgresql.Driver");

			//STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			
			//STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			
			String sql = "INSERT INTO staff " +
						"VALUES (8,'"+t1.getText()+"','"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+t5.getText()+"','"+t6.getText()+"','"+t8.getText()+"','25','2','Senior','21565')";
			stmt.executeUpdate(sql);
			
			System.out.println("Inserted records into the table...");

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					conn.close();
			}catch(SQLException se){
			}// do nothing
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}
	
	public sum(){
		JFrame f = new JFrame("ADD STAFF");
		f.setSize(600,500);
		f.setLocationRelativeTo(null);  
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setResizable(false);

		//Top Label
		l1 = new JLabel("ADD STAFF");
		l1.setBounds(210, 10, 250, 50);
		l1.setFont(new Font("Serif", Font.PLAIN, 20));

		//Name Part
		l2 = new JLabel("First Name:");
		l2.setBounds(5, 70, 70, 25);
		t1 = new JTextField();
		t1.setBounds(120,70,150,25);
		l3 = new JLabel("Last Name:");
		l3.setBounds(280, 70, 70, 25);
		t2 = new JTextField();
		t2.setBounds(390,70,150,25);

		//email part
		l4 = new JLabel("Email:");
		l4.setBounds(5, 105, 70, 25);
		t3 = new JTextField();
		t3.setBounds(120,105,150,25);

		//Mobile no part
		l5 = new JLabel("Mobile No:");
		l5.setBounds(5, 140, 70, 25);
		t4 = new JTextField();
		t4.setBounds(120,140,150,25);

		//Address part1
		l6 = new JLabel("Street:");
		l6.setBounds(5, 190, 70, 25);
		t5 = new JTextField();
		t5.setBounds(120,190,150,25);

		l7 = new JLabel("City:");
		l7.setBounds(280, 190, 70, 25);
		t6 = new JTextField();
		t6.setBounds(390,190,150,25);

		//Address part2
		l8 = new JLabel("State:");
		l8.setBounds(5, 225, 70, 25);
		t7 = new JTextField();
		t7.setBounds(120,225,150,25);

		l9 = new JLabel("Pin-Code:");
		l9.setBounds(280, 225, 70, 25);
		t8 = new JTextField();
		t8.setBounds(390,225,150,25);

		

		//Submit Button.
		b1 = new JButton("Submit");
		b1.setBounds(450,390,100,40);
		b1.addActionListener(this);

		f.add(l1);
		f.add(l2);
		f.add(t1);
		f.add(l3);
		f.add(t2);
		f.add(l4);
		f.add(t3);
		f.add(l5);
		f.add(t4);
		f.add(l6);
		f.add(t5);
		f.add(l7);
		f.add(t6);
		f.add(l8);
		f.add(t7);
		f.add(l9);
		f.add(t8);
		
		f.add(b1);

		f.setVisible(true);		
	}
	public static void main(String arg[]){
		sum s = new sum();		
	}
}

class jdbc {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "org.postgresql.Driver";  
   static final String DB_URL = "jdbc:postgresql://localhost:5433/test";

   //  Database credentials
   static final String USER = "postgres";
   static final String PASS = "Shravan@123";
   
   
   Connection conn = null;
   Statement stmt = null;
   void insert(){
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("org.postgresql.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();
      
      String sql = "INSERT INTO test_tb " +
                   "VALUES (3,'akshay')";
      stmt.executeUpdate(sql);
      
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
   
}//end JDBCExample