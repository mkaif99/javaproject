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
public class BookController extends JFrame implements ActionListener
{
	Button B;
	JPanel P;
	JTable j;
	static DBHelper openDbs;
	DBHelper d;
	Choice ch;
	
	public BookController()
	{
		setTitle("Total List of Books Buy from Suppiler");
		setSize(1280,650);
		setLocation(300,150);
		setBackground(Color.BLACK);			
		Font f = new Font("Arial",Font.PLAIN, 17);
		try
		{
			P = new JPanel();
			d = new DBHelper();
			ResultSet rsobj = null;
			rsobj = d.getconnect().executeQuery("Select * from BookStore");
			ResultSetMetaData rsmd = rsobj.getMetaData();
			j=new JTable();
			j.setRowHeight(j.getRowHeight()+15);
			j.setFont(f);
			DefaultTableModel model = (DefaultTableModel)j.getModel();
			
			int cols = rsmd.getColumnCount();
			String colName[] = new String[cols];
			
			for(int i=0; i<cols; i++)
				colName[i] = rsmd.getColumnName(i+1);
			
				model.setColumnIdentifiers(colName);
				String Id,cat,tit,aut,pr,st,tb,da;
				
			while(rsobj.next()){
				Id = rsobj.getString(1);
				cat = rsobj.getString(2);
				tit = rsobj.getString(3);
				aut = rsobj.getString(4);
				pr = rsobj.getString(5);
				st = rsobj.getString(6);
				tb = rsobj.getString(7);
				da = rsobj.getString(8);
				String[] row = {Id,cat,tit,aut,pr,st,tb,da};
				model.addRow(row);
			}					
		}
		catch(Exception e){		e.printStackTrace();		}
			B = new Button("CLOSE");
			B.setBackground(Color.DARK_GRAY);
			B.setForeground(Color.WHITE);
			B.setBounds(300,300,200,30);
			P.add(B);
			B.addActionListener(this);
			setLayout(new BorderLayout());
			add(P,"South");
			setVisible(true);
			add(new JScrollPane(j));
	}
	
	public void actionPerformed(ActionEvent AObj){
		if(AObj.getSource()==B)
		{
			dispose();
		}
	}
	
	public static void BookData(BookStore B)
	{
		try
		{
			String insertQry = "insert into BookStore values(";
			
			insertQry += "'" + B.getBookId() + "',";
			insertQry += "'" + B.getBookCatogery() + "',";
			insertQry += "'" + B.getBookTitle() + "',";
			insertQry += "'" + B.getBookAuthor() + "',";
			insertQry += "'" + B.getBookPrice() + "',";
			insertQry += "'" + B.getBookStock() +"',";
			insertQry += "'" + B.getDate() +"',";
			insertQry += "'" + B.getTotalBill() +"')";
			openDbs = new DBHelper();
			
			openDbs.setRecords(insertQry);							// Using function for Updating
			JOptionPane.showMessageDialog(null," Record Inserted...!!!");
			
		}catch(Exception e){		e.printStackTrace();		}
	}
}


