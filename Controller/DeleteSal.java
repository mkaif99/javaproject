package BookShop.Controller;
import BookShop.Database.*;
import BookShop.modal.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class DeleteSal extends JFrame implements ActionListener
{
	Button B;
	JPanel p;
	Choice ch ;
	JLabel L1, L2, L3, L4, L5, L6, L7, L8, L9;
	JLabel T2, T3, T4, T5, T6, T7, T8, T9;
	DBHelper d;
	Font f;
	public DeleteSal()
	{
		Font f = new Font("TimesRoman",Font.BOLD, 20);
		p = new JPanel();
		setTitle("Do you want to Delete Sales ");
		setLocation(600,200);
		setSize(700,720);
		p.setBackground(new Color(255,255,204));
		
		JLabel title = new JLabel("Delete Customer");
		title.setBounds(240,30,250,30);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		p.setLayout(null);
        L1 = new JLabel("Customer ID : ");
		L1.setBounds(150,100,120,20);
		L1.setFont(new Font("Arial",Font.PLAIN,17));
      
        ch = new Choice();
		ch.setFont(new Font("TimesRoman",Font.BOLD , 17));
		ch.setBounds(290,100,200,20);
		ch.add("--None--");
		p.add(L1); 		
		
		try{
			d= new DBHelper();
			 ResultSet rsobj = null; 
			 rsobj = d.getconnect().executeQuery("select CustomerId from Customer;");
			 while(rsobj.next()){
						ch.add(rsobj.getString(1));
					}
		}catch(Exception e){	e.printStackTrace();	}
		p.add(ch);
		
		L2 = new JLabel("Customer Name :");
		L2.setBounds(150,150,140,20);
		L2.setFont(new Font("Arial",Font.PLAIN,17));
		
		T2 = new JLabel();
		T2.setBounds(290,150,200,20);
		T2.setFont(f);
		p.add(L2); 		p.add(T2);
		
		L3 = new JLabel("Phone No :");
		L3.setBounds(150,200,120,20);
		L3.setFont(new Font("Arial",Font.PLAIN,17));
		
		T3 = new JLabel();
		T3.setBounds(290,200,200,20);
		T3.setFont(f);
		p.add(L3); 		p.add(T3);
		
		L4 = new JLabel("Book Catogery :");
		L4.setBounds(150,250,120,20);
		L4.setFont(new Font("Arial",Font.PLAIN,17));
		
		T4 = new JLabel();
		T4.setBounds(290,250,200,20);
		T4.setFont(f);
		p.add(L4); 		p.add(T4);
		
		L5 = new JLabel("Book Name :");
		L5.setBounds(150,300,100,20);
		L5.setFont(new Font("Arial",Font.PLAIN,17));
		
		T5 = new JLabel();
		T5.setBounds(290,300,200,20);
		T5.setFont(f);
		p.add(L5); 		p.add(T5);
		
		L6 = new JLabel("Quantity :");
		L6.setBounds(150,350,100,20);
		L6.setFont(new Font("Arial",Font.PLAIN,17));
		
		T6 = new JLabel();
		T6.setBounds(290,350,200,20);
		T6.setFont(f);
		p.add(L6); 		p.add(T6);
		
		L7 = new JLabel("Book Price :");
		L7.setBounds(150,400,100,20);
		L7.setFont(new Font("Arial",Font.PLAIN,17));
		
		T7 = new JLabel();
		T7.setBounds(290,400,200,20);
		T7.setFont(f);
		p.add(L7); 		p.add(T7);
		
		L8 = new JLabel("Date :");
		L8.setBounds(150,450,100,20);
		L8.setFont(new Font("Arial",Font.PLAIN,17));
		
		T8 = new JLabel();
		T8.setBounds(290,450,200,20);
		T8.setFont(f);
		p.add(L8); 		p.add(T8);
		
		L9 = new JLabel("Total Amt :");
		L9.setBounds(150,500,100,20);
		L9.setFont(new Font("Arial",Font.PLAIN,17));
		
		T9 = new JLabel();
		T9.setBounds(290,500,200,20);
		T9.setFont(f);
		p.add(L9); 		p.add(T9);
		
		ch.addItemListener(new ItemListener(){	
		public void itemStateChanged(ItemEvent Aobj){
			try{
				d = new DBHelper();
				ResultSet rsobj = d.getconnect().executeQuery(" select CustomerName, PhoneNo, BookCatogery, BookName, Quantity, BookPrice, Date, TotalAmt from Customer where CustomerId= '"+ch.getSelectedItem()+"';");
				
					while(rsobj.next()){
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
			}
		});
		
		B = new Button("Delete");
		B.setBackground(Color.DARK_GRAY);
		B.setForeground(Color.WHITE);
		B.setBounds(230,570,200,30);
		B.setFont(new Font("Arial",Font.PLAIN,17));
		p.add(B);
	
		
		B.addActionListener(this);
		setLayout(new BorderLayout());
		add(p,"Center");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent AObj){

		if(AObj.getSource()==B)
		{		
		 if(!ch.getSelectedItem().equals("--None--")){			
				del();
				dispose();			
			}
		else				JOptionPane.showMessageDialog(null,"Plz choose BookId");			
		}
	}
	
	public void del()
	{
		try{
			d = new DBHelper();
			String insertQry = "delete from Customer where CustomerId= '"+ch.getSelectedItem()+"';";
			int count = d.getconnect().executeUpdate(insertQry);
		//	System.out.print(insertQry);
		}catch(Exception e){	e.printStackTrace();	}
	}
	
} 