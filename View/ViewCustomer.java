package BookShop.view;
import BookShop.modal.*;
import BookShop.Controller.*;
import BookShop.Database.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class ViewCustomer extends JFrame implements ActionListener
{
	JLabel L1,L2,L3,L4,L5;
	JTextField T1,T2,T5;
	Button B1,B2;
	Choice ch, ch1;
	int a1=0, q=0, p=0, z=0;
	boolean x = false, y = false;
	static LocalDate Ld = LocalDate.now();
	String s="", s1="", s2="", s3="";
	DBHelper d, d1;
	JFrame j;
	JTextArea J;
	public ViewCustomer()
	{
		setSize(900,700);
		setLocation(500,200);
		Font f = new Font("TimesRoman",Font.BOLD , 20);
		Font f1 = new Font("Arial",Font.PLAIN , 18);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(255,255,153));
		
		JLabel title = new JLabel("Add New Customer");
		title.setBounds(190,40,300,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		L1 = new JLabel("Customer Name");
		L1.setBounds(120,120,140,25);
		L1.setFont(f);
		
		T1 = new JTextField();
		T1.setBounds(300,120,200,25);
		T1.setFont(f1);
		p.add(L1); 		p.add(T1);
		
		L2 = new JLabel("Phone No");
		L2.setBounds(120,180,120,25);
		L2.setFont(f);
		
		T2 = new JTextField();
		T2.setBounds(300,180,200,25);
		T2.setFont(f1);
		p.add(L2); 		p.add(T2);
		
		L3 = new JLabel("Select Catogery");
		L3.setBounds(120,240,140,25);
		L3.setFont(f);
		
		ch = new Choice();
		ch.add("--None--");
		ch.add("--Programming--");
		ch.add("--Competition--");
		ch.add("--Science Fiction--");
		ch.add("--Historical--");
		ch.add("--Picture Book--");
		ch.add("--Novel Stories--");
		ch.add("--Children Book--");

		ch.setBounds(300,240,200,25);
		ch.setFont(new Font("Arial",Font.PLAIN , 16));
		p.add(L3); 		p.add(ch);
		
		L4 = new JLabel("Choose Book");
		L4.setBounds(120,300,140,25);
		L4.setFont(f);
		
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
			//	System.out.print(insertQry);
					while(rsobj.next()){
						ch1.add(rsobj.getString("BookTitle"));
					}
				}catch(Exception e){		e.printStackTrace();	}
			}
		});
		ch1.setBounds(300,300,200,25);
		ch1.setFont(new Font("Arial",Font.PLAIN , 16));
		p.add(L4); 		p.add(ch1);
		
		L5 = new JLabel("Quantity ");
		L5.setBounds(120,360,100,25);
		L5.setFont(f);
		
		T5 = new JTextField();
		T5.setBounds(300,360,200,25);
		T5.setFont(f1);
		p.add(L5); 		p.add(T5);
			
		B1 = new Button("Add");
		B1.setBounds(140,460,140,30);
		B1.setFont(new Font("Arial",Font.PLAIN,15));
		B2 = new Button("Cancel");
		B2.setBounds(330,460,140,30);
		B2.setFont(new Font("Arial",Font.PLAIN,15));
		B1.setBackground(Color.BLACK);
		B1.setForeground(Color.WHITE);
		B2.setBackground(Color.BLACK);
		B2.setForeground(Color.WHITE);
		
		p.add(B1);		p.add(B2);
		setLayout(new BorderLayout());
		B1.addActionListener(this);
		B2.addActionListener(this);
		add(p,"Center");
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent Aobj){
		
		if(Aobj.getSource()==B1)
		{
			if(T1.getText().length()!=0 && T2.getText().length()!=0 && !ch.getSelectedItem().equals("--None--") && !ch1.getSelectedItem().equals("--None--") && T5.getText().length()!=0){
			
			int  a2=0, d=0;
			
				if(!T1.getText().equals("")){
					s = T1.getText();
				}
				if(!T2.getText().equals(" ")){
					if( T2.getText().length()<11 && T2.getText().length()>9){
						s1 = T2.getText();
						x=true;
					}
					else 	JOptionPane.showMessageDialog(null,"PhNo must be 10");
				}
				if(!ch.getSelectedItem().equals("--None--"))
					s2 = ch.getSelectedItem();
				if(!ch1.getSelectedItem().equals("--None--"))
					s3 = ch1.getSelectedItem();
				if(!T5.getText().equals("")){
					a1 = Integer.parseInt(T5.getText());
					z = BookQty();
					if(z>a1){		
						updQty();
						y = true;
					}
					else	JOptionPane.showMessageDialog(null,"Quantity must be less from stock");
				}
				a2 = BookPr();
				a2 += 5;
				d = (a1*a2);
				if(x==true && y==true){
				Customer C = new Customer(s, s1, s2, s3, a1, a2, Ld, d);
			//	showCustomer(C);
				CustomerController.CustomerData(C);
				showSlip(s,s1,s2,s3,z);
				dispose();
				}
			}else			JOptionPane.showMessageDialog(null,"Plz Fill the Fields");		
		}
		
		if(Aobj.getSource()==B2)
		{
			if(T1.getText().length()!=0 && T2.getText().length()!=0 && !ch.getSelectedItem().equals("--None--") && !ch1.getSelectedItem().equals("--None--") && T5.getText().length()!=0){
			T1.setText("");
			T2.setText("");
			ch.select(0);
			ch1.select(0);
			T5.setText("");
			T1.requestFocus();
			}else	dispose();
		}
		
	}
	
	public void showSlip(String s, String s1, String s2, String s3, int c)
	{
		j = new JFrame();
		j.setTitle("Bill of Purchase Book");
		j.setLocation(500,150);
		j.setSize(900,800);	
	//	j.setLayout(null);
		setBackground(Color.CYAN);
		J = new JTextArea(500,100);
		J.setFont(new Font("sanserif",Font.ITALIC , 30));	
		J.setBounds(0,0,900,800);
		
		try{
			d1 = new DBHelper();
			ResultSet rsobj = d1.getconnect().executeQuery(" select * from Customer where CustomerName= '"+s+"' and PhoneNo= '"+s1+"' and BookCatogery= '"+s2+"' and BookName='"+s3+"';");
			String s0 = "\n\t   Bill of Book Sale\n\t-------------------------------------------------";
		//	System.out.print("select * from Customer where CustomerName= '"+s+"' and PhoneNo= '"+s1+"' and BookCatogery= '"+s2+"' and BookName='"+s3+"' and Quantity='"+c+"';");
				while(rsobj.next()){
					s0 +="\n\t\t\tDate : "+rsobj.getString("Date"); 
					s0 += "\n\tCustomerId           : "+rsobj.getString("CustomerId");
					s0 += "\n\n\tCustomerName : "+rsobj.getString("CustomerName");
					s0 += "\n\n\tPhoneNo : "+rsobj.getString("PhoneNo"); 					
					s0 += "\n\n\tBookCatogery  : "+rsobj.getString("BookCatogery"); 
					s0 += "\n\n\tBookName    : "+rsobj.getString("BookName"); 
					s0 += "\n\n\tQuantity   : "+rsobj.getString("Quantity"); 
					s0 += "\n\n\tBookPrice     : "+rsobj.getString("BookPrice"); 				
					s0 += "\n\n\tTotalAmt      :"+rsobj.getString("TotalAmt"); 
				//	System.out.print(s0);
				//	J.append(s0);
				}
				J.setText(s0);
			}catch(Exception e){	e.printStackTrace();	}
		j.add(J,"Center");
		j.setVisible(true);
	}
	
	public int BookQty()
	{	
		try{
			ResultSet rsobj = null;
			d = new DBHelper();
			String insertQry = "select BookStock from BookStore where BookCatogery= '"+s2+"' and BookTitle='"+s3.trim()+"';";
			rsobj = d.getconnect().executeQuery(insertQry);
			rsobj.next();
			q = rsobj.getInt(1);
		}catch(Exception e){			e.printStackTrace();		}
		return q;
	}
	
	public int BookPr()
	{	
		try{
			ResultSet rsobj = null;
			d = new DBHelper();
			String insertQry = "select BookPrice from BookStore where BookCatogery= '"+s2+"' and BookTitle='"+s3.trim()+"';";
			rsobj = d.getconnect().executeQuery(insertQry);
			rsobj.next();
			p = rsobj.getInt(1);
		}catch(Exception e){			e.printStackTrace();		}
		return p;
	}
	
	public void updQty()
	{
		try{	
			d = new DBHelper();
			d.getconnect().executeUpdate("update BookStore set BookStock ="+(z-a1)+" where BookCatogery= '"+s2+"' and BookTitle='"+s3.trim()+"';");
		}catch(Exception e){			e.printStackTrace();		}	
	}
	
	public static void showCustomer(Customer CObj)
	{
	
		String s = "New Customer Detail\n";
		s += "\nName :"+CObj.getCustomerName()+"\nPHone No :"+CObj.getPhoneNo()+"\nBook Catg. :"+CObj.getBookCatogery()+"\nBook Name :"+CObj.getBookName()+"\nQuantity :"+CObj.getBookPrice()+"\nPerBookPrice :"+CObj.getQuantity()+"\nTotalAmt :"+CObj.getTotalAmt()+"\nDate :"+Ld;
		JOptionPane.showMessageDialog(null,s);
	}
}
//	javac -d d:\MyProjectClass -cp c:\com.mysql.jdbc_5.1.5.jar;d:\MyProjectClass ViewCustomer.java
