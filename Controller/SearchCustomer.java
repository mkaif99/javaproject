package BookShop.Controller;
import BookShop.modal.*;
import BookShop.Database.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class SearchCustomer extends JFrame implements ActionListener
{
	Button B2,B;
	JLabel l1, l2;
	Choice ch;
	Frame j, j1;
	DBHelper d;
	
	public SearchCustomer()
	{
		j = new Frame();
		j.setTitle("Do you want to Search Customer");
		j.setLocation(630,350);
		j.setSize(500,300);	
		j.setBackground(Color.LIGHT_GRAY);
		
		JLabel title = new JLabel("Search Customer");
		title.setBounds(150,50,300,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		j.add(title);
        l1 = new JLabel("Customer ID : ");
		l1.setBounds(150,130,120,30);
		l1.setFont(new Font("Arial",Font.BOLD,17));

        ch = new Choice();
		ch.setFont(new Font("Arial",Font.BOLD,17));
		ch.add("--None--");
		try{
			d= new DBHelper();
			 ResultSet rsobj = null; 
			 rsobj = d.getconnect().executeQuery("select CustomerId from Customer;");
			 while(rsobj.next()){
						ch.add(rsobj.getString(1));
					}
		}catch(Exception e){	e.printStackTrace();	}
		ch.setBounds(290,130,100,30);
		j.add(ch);
	
		B2 = new Button("Search");
		B2.setBackground(Color.DARK_GRAY);
		B2.setForeground(Color.WHITE);
		B2.setBounds(150,210,120,30);
		B2.setFont(new Font("Arial",Font.PLAIN,17));
		j.add(l1);
		j.add(ch);
		j.add(B2);	
		B2.addActionListener(this);
		j.setLayout(new BorderLayout());
		j.setVisible(true);
	}

	public void actionPerformed(ActionEvent AObj){

		if(AObj.getSource()==B2)
		{
			if(!ch.getSelectedItem().equals("--None--")){
				ShowSearch();
				j.dispose();
			}else			JOptionPane.showMessageDialog(null,"Plz Choose CustomerId");		
		}
		if(AObj.getSource()==B)
		{
			j1.dispose();
		}
	}
	
	public void ShowSearch()
	{
		
		JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9;
		JLabel T1, T2, T3, T4, T5, T6, T7, T8, T9;
	
		j1 = new Frame();
		Font f = new Font("TimesRoman",Font.BOLD , 20);
		
		j1.setTitle(" Customer Data Found ");
		j1.setLocation(600,150);
		j1.setSize(600,720);
		j1.setBackground(new Color(255,229,204));	// VLG
		
		JLabel title = new JLabel("Search Customer Data");
		title.setBounds(140,70,350,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		j1.add(title);
		
		j1.setLayout(null);
        L1 = new JLabel("Customer ID :");
		L1.setBounds(160,140,120,30);
		L1.setFont(new Font("Arial",Font.PLAIN,17));
      
        T1 = new JLabel();
		T1.setFont(f);
		T1.setBounds(330,140,200,30);
		j1.add(L1);		j1.add(T1); 		
		
		L2 = new JLabel("Customer Name :");
		L2.setBounds(160,190,130,30);
		L2.setFont(new Font("Arial",Font.PLAIN,17));
		
		T2 = new JLabel();
		T2.setBounds(330,190,200,30);
		T2.setFont(f);
		j1.add(L2); 		j1.add(T2);
		
		L3 = new JLabel("PhoneNo :");
		L3.setBounds(160,240,120,30);
		L3.setFont(new Font("Arial",Font.PLAIN,17));
		
		T3 = new JLabel();
		T3.setBounds(330,240,200,30);
		T3.setFont(f);
		j1.add(L3); 		j1.add(T3);
		
		L4 = new JLabel("Book Catogery :");
		L4.setBounds(160,290,130,30);
		L4.setFont(new Font("Arial",Font.PLAIN,17));
		
		T4 = new JLabel();
		T4.setBounds(330,290,200,30);
		T4.setFont(f);
		j1.add(L4); 		j1.add(T4);
		
		L5 = new JLabel("Book Name");
		L5.setBounds(160,340,100,30);
		L5.setFont(new Font("Arial",Font.PLAIN,17));
		
		T5 = new JLabel();
		T5.setBounds(330,340,200,30);
		T5.setFont(f);
		j1.add(L5); 		j1.add(T5);
		
		L6 = new JLabel("Quantity :");
		L6.setBounds(160,390,100,30);
		L6.setFont(new Font("Arial",Font.PLAIN,17));
		
		T6 = new JLabel();
		T6.setBounds(330,390,200,30);
		T6.setFont(f);
		j1.add(L6); 		j1.add(T6);
		
		L7 = new JLabel("Book Price :");
		L7.setBounds(160,440,100,30);
		L7.setFont(new Font("Arial",Font.PLAIN,17));
		
		T7 = new JLabel();
		T7.setBounds(330,440,200,30);
		T7.setFont(f);
		j1.add(L7); 		j1.add(T7);
		
		L8 = new JLabel("Date :");
		L8.setBounds(160,490,100,30);
		L8.setFont(new Font("Arial",Font.PLAIN,17));
		
		T8 = new JLabel();
		T8.setBounds(330,490,200,30);
		T8.setFont(f);
		j1.add(L8); 		j1.add(T8);
		
		L9 = new JLabel("Total Amt :");
		L9.setBounds(160,540,100,30);
		L9.setFont(new Font("Arial",Font.PLAIN,17));
		
		T9 = new JLabel();
		T9.setBounds(330,540,200,30);
		T9.setFont(f);
		j1.add(L9); 		j1.add(T9);
		
		B = new Button("CLOSE");
		B.setBackground(Color.DARK_GRAY);
		B.setForeground(Color.WHITE);
		B.setBounds(190,620,180,30);
		B.setFont(new Font("Arial",Font.PLAIN,17));
		j1.add(B);
		
			try{
				d = new DBHelper();
				ResultSet rsobj = d.getconnect().executeQuery(" select * from Customer where CustomerId= '"+ch.getSelectedItem()+"';");
				
					while(rsobj.next()){
						T1.setText(rsobj.getString("CustomerId"));
						T2.setText(rsobj.getString("CustomerName")); 
						T3.setText(rsobj.getString("PhoneNo")); 
						T4.setText(rsobj.getString("BookCatogery")); 
						T5.setText(rsobj.getString("BookName")); 
						T6.setText(rsobj.getString("Quantity")); 
						T7.setText(rsobj.getString("BookPrice")); 
						T8.setText(rsobj.getString("Date")); 
						T9.setText(rsobj.getString("TotalAmt")); 
					}
				}catch(Exception e){	e.printStackTrace();	}	
		j1.setLayout(new BorderLayout());
		B.addActionListener(this);
		j1.setVisible(true);
	}
}
