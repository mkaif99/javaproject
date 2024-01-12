package BookShop.Controller;
import BookShop.modal.*;
import BookShop.Database.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane.*;

public class CustomerController extends JFrame implements ActionListener
{
	Button B;
	JPanel P;
	JTable j;
	static DBHelper openDbs;
	DBHelper d;
	public CustomerController()
	{
		setTitle("Total Customer Sales ");
		setSize(1280,650);
		setLocation(300,150);
		setBackground(Color.BLACK);			
		Font f = new Font("Arial",Font.PLAIN, 17);
		
		try
		{
			P = new JPanel();
			d = new DBHelper();
			ResultSet rsobj = null;
			rsobj = d.getconnect().executeQuery("Select * from Customer");
			ResultSetMetaData rsmd = rsobj.getMetaData();
			j=new JTable();
			j.setFont(f);
			j.setRowHeight(j.getRowHeight()+15);
			DefaultTableModel model = (DefaultTableModel)j.getModel();
			
			int cols = rsmd.getColumnCount();
			String colName[] = new String[cols];
			
			for(int i=0; i<cols; i++)
				colName[i] = rsmd.getColumnName(i+1);
			
				model.setColumnIdentifiers(colName);
				String id,na,ph,cat,bn,pr,qt,ta,da;
				
			while(rsobj.next()){
				id = rsobj.getString(1);
				na = rsobj.getString(2);
				ph = rsobj.getString(3);
				cat = rsobj.getString(4);
				bn = rsobj.getString(5);
				pr = rsobj.getString(6);
				qt = rsobj.getString(7);
				ta = rsobj.getString(8);
				da = rsobj.getString(9);
				String[] row = {id,na,ph,cat,bn,pr,qt,ta,da};
				model.addRow(row);
			}		
		
			B = new Button("CLOSE");
			B.setBackground(Color.DARK_GRAY);
			B.setForeground(Color.WHITE);
			B.setBounds(300,300,250,40);
			P.add(B);
			B.addActionListener(this);
			setLayout(new BorderLayout());
			add(P,"South");
			setVisible(true);
			add(new JScrollPane(j));
			
		}
		catch(Exception e){		e.printStackTrace();		}
	}
	
	public void actionPerformed(ActionEvent AObj){
		if(AObj.getSource()==B)
		{
			dispose();
		}
	}	
	
	public static void CustomerData(Customer C)
	{
		try
		{
			String insertQry = "insert into Customer(CustomerName,PhoneNo,BookCatogery,BookName,BookPrice,Quantity,Date,TotalAmt) values(";
			
			insertQry += "'" + C.getCustomerName() + "',";
			insertQry += "'" + C.getPhoneNo() + "',";
			insertQry += "'" + C.getBookCatogery() + "',";
			insertQry += "'" + C.getBookName() + "',";
			insertQry += "'" + C.getQuantity() +"',";
			insertQry += "'" + C.getBookPrice() + "',";
			insertQry += "'" + C.getDate() +"',";
			insertQry += "'" + C.getTotalAmt() +"')";
			openDbs = new DBHelper();
			
			openDbs.setRecords(insertQry);		
		}
		catch(Exception e){		e.printStackTrace();		}
	}
}

//	javac -d d:\MyProjectClass -cp c:\com.mysql.jdbc_5.1.5.jar;d:\MyProjectClass BookController.java
