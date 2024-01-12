package BookShop.Controller;
import BookShop.modal.*;
import BookShop.Database.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;

public class SearchBook1 extends JFrame implements ActionListener
{
	Button B2,B3;
	JPanel P1,P2;
	JLabel l1, l2;
	Choice ch, ch1;
	Frame j;
	DBHelper d;
	TextArea T;
	public SearchBook1()
	{
		setTitle("Search Book");
		setLocation(630,300);
		setSize(600,500);
		setBackground(Color.DARK_GRAY);
		P1 = new JPanel();
		P1.setLayout(null);
		
        l1 = new JLabel("Catogery : ");
		l1.setBounds(100,100,100,30);
		l1.setFont(new Font("Arial",Font.PLAIN,15));

        ch = new Choice();
		ch.add("--NONE--");
		ch.add("--Programming--");
		ch.add("--Competition--");
		ch.add("--Science Fiction--");
		ch.add("--Historical--");
		ch.add("--Picture Book--");
		ch.add("--Novel Stories--");
		ch.add("--Children Book--");
		ch.setBounds(240,100,200,30);
		
		l2 = new JLabel("Book Name : ");
		l2.setBounds(100,160,100,30);
		l2.setFont(new Font("Arial",Font.PLAIN,15));
		
		ch1 = new Choice();
		ch.addItemListener(new ItemListener(){	
		public void itemStateChanged(ItemEvent Aobj){
			try{
				ch1.removeAll();
				Class.forName("com.mysql.jdbc.Driver");
				Connection Cobj = DriverManager.getConnection("jdbc:mysql://localhost/MyProject","root"," ");	
				Statement sobj = Cobj.createStatement();
				ResultSet rsobj = null;
				ch1.add("--None--");
			
				String insertQry = "select BookTitle from BookStore where BookCatogery= '"+ch.getSelectedItem()+"';";
				rsobj = sobj.executeQuery(insertQry);
				System.out.print(insertQry);
					while(rsobj.next()){
						ch1.add(rsobj.getString("BookTitle"));
					}
				}catch(Exception e){		}
			}
		});
		ch1.setBounds(240,160,200,30);
		T = new TextArea(50,15);
	//	T.setBounds();
	
		ch1.addItemListener(new ItemListener(){	
		public void itemStateChanged(ItemEvent Aobj){
			
			}
		});
		B2 = new Button("Search");
		B2.setBackground(Color.DARK_GRAY);
		B2.setForeground(Color.WHITE);
		B2.setBounds(200,280,150,30);
		B2.setFont(new Font("Arial",Font.PLAIN,17));

		P1.add(l1);
		P1.add(ch);
		P1.add(l2);
		P1.add(ch1);
		P1.add(B2);
		P1.add(T);
		
		B2.addActionListener(this);
		setLayout(new BorderLayout());
		add(P1,"Center");
		setVisible(true);
	}

	public void actionPerformed(ActionEvent AObj){

		if(AObj.getSource()==B2)
		{
			try{
				d = new DBHelper();
				ResultSet rsobj = d.getconnect().executeQuery(" select * from BookStore where BookCatogery= '"+ch.getSelectedItem()+"' and BookTitle= '"+ch1.getSelectedItem()+"';");
				System.out.print(" select * from BookStore where BookCatogery= '"+ch.getSelectedItem()+"' and BookTitle= '"+ch1.getSelectedItem()+"';");
					while(rsobj.next()){
						T.append(rsobj.getString("BookId"));
						T.append(rsobj.getString("BookCatogery")); 
						T.append(rsobj.getString("BookTitle")); 
						T.append(rsobj.getString("BookAuthor")); 
						T.append(rsobj.getString("BookPrice")); 
						T.append(rsobj.getString("BookStock")); 
						T.append(rsobj.getString("Date")); 
						T.append(rsobj.getString("TotalBill")); 
					}
				}catch(Exception e){	e.printStackTrace();	}
		
		//	else				JOptionPane.showMessageDialog(null,"Plz Fill the Fields");
				
		}
	}
	
	/*
	
	*/
	// public void findBook(String a, String b)
	// {
		// setTitle("List of Searching Books Buy from Suppiler");
		// setSize(700,500);
		// setLocation(480,280);
		// setBackground(Color.CYAN);
		// P2 = new JPanel();
	// //	f = new Frame();
		// B3 = new Button("CLOSE");
			// B3.setBackground(Color.DARK_GRAY);
			// B3.setForeground(Color.WHITE);
			// B3.setBounds(300,300,150,30);
			// P2.add(B3);
			// B3.addActionListener(this);
			// setLayout(new BorderLayout());
		// //	f.add(P2,"South");
			// setVisible(true);
				
	// }
}