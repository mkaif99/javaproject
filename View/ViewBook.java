package BookShop.view;
import BookShop.modal.*;
import BookShop.Controller.*;
import BookShop.Database.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;			// JFrame in this package
import java.time.LocalDate;

public class ViewBook extends JFrame implements ActionListener
{	
	JLabel L1,L2,L3,L4,L5,L6;
	JTextField T1,T2,T3,T4,T5,T6;
	Button B1,B2,B;
	Choice ch;
	JPanel p,P;
	DBHelper d1;
	JFrame j;
	JTextArea J;
	static LocalDate Ld = LocalDate.now();	
	int b=0, c=0, d=0;
	public ViewBook()
	{
		
		setSize(900,700);
		setLocation(500,200);
		Font f = new Font("TimesRoman",Font.BOLD , 20);
		Font f1 = new Font("Arial",Font.PLAIN , 18);	
		p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(204,255,255));		// VLB
		
		JLabel title = new JLabel("Add New Book");
		title.setBounds(190,40,250,40);
		title.setFont(new Font("Arial",Font.BOLD, 30));
		p.add(title);
		
		L2 = new JLabel("Book Catogery");
		L2.setBounds(120,120,140,30);
		L2.setFont(f);
		
		ch = new Choice();
		ch.add("--None--");
		ch.add("--Programming--");
		ch.add("--Competition--");
		ch.add("--Science Fiction--");
		ch.add("--Historical--");
		ch.add("--Picture Book--");
		ch.add("--Novel Stories--");
		ch.add("--Children Book--");
		ch.setBounds(300,120,200,26);
		ch.setFont(new Font("Arial",Font.PLAIN, 16));
		p.add(L2); 		p.add(ch);
		
		L3 = new JLabel("Book Title");
		L3.setBounds(120,180,120,25);
		L3.setFont(f);
		
		T3 = new JTextField();
		T3.setBounds(300,180,200,25);
		T3.setFont(f1);
		p.add(L3); 		p.add(T3);
		
		L4 = new JLabel("Book Author");
		L4.setBounds(120,240,120,25);
		L4.setFont(f);
		
		T4 = new JTextField();
		T4.setBounds(300,240,200,25);
		T4.setFont(f1);
		p.add(L4); 		p.add(T4);
		
		L5 = new JLabel("Book Price");
		L5.setBounds(120,300,100,25);
		L5.setFont(f);
		
		T5 = new JTextField();
		T5.setBounds(300,300,200,25);
		T5.setFont(f1);
		p.add(L5); 		p.add(T5);
		
		L6 = new JLabel("Book Qty");
		L6.setBounds(120,360,100,25);
		L6.setFont(f);
		
		T6 = new JTextField();
		T6.setBounds(300,360,200,25);
		T6.setFont(f1);	
		p.add(L6); 		p.add(T6);
		
		B1 = new Button("Add");
		B1.setBounds(140,460,140,30);
		B1.setFont(f);
		B2 = new Button("Cancel");
		B2.setBounds(330,460,140,30);
		B2.setFont(f);
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
			if(!ch.getSelectedItem().equals("--None--") && T3.getText().length()!=0 && T4.getText().length()!=0 && T5.getText().length()!=0 && T6.getText().length()!=0){
				String s="", s1="", s2="";
				int b=0, c=0, d=0;
				if(!ch.getSelectedItem().equals("--None--"))
					s = ch.getSelectedItem();
				if(!T3.getText().equals(""))
					s1 = T3.getText();
				if(!T4.getText().equals(""))
					s2 = T4.getText();
				if(!T5.getText().equals(""))
					b = Integer.parseInt(T5.getText());
				if(!T6.getText().equals(""))
					c = Integer.parseInt(T6.getText());
				d = b*c;
				BookStore oneBook = new BookStore( s, s1, s2, b, c, Ld, d);
			//	showBook(oneBook);
				BookController.BookData(oneBook);
				showSlip(s,s1,s2,b,c);
				dispose();				
			}else
			{
				JOptionPane.showMessageDialog(null,"Plz Fill the Fields");
			}
		}	
		if(Aobj.getSource()==B2)
		{
			if(!ch.getSelectedItem().equals("--None--") && T3.getText().length()!=0&& T4.getText().length()!=0&& T5.getText().length()!=0&& T6.getText().length()!=0){
			ch.select(0);
			T3.setText("");
			T4.setText("");
			T5.setText("");
			T6.setText("");
			}else 	dispose();
		}
	}

	public void showSlip(String s, String s1, String s2, int b, int c)
	{
		j = new JFrame();
		j.setTitle("Bill of Purchase Book");
		j.setLocation(500,200);
		j.setSize(900,750);	
		j.setLayout(null);
		setBackground(Color.CYAN);
		J = new JTextArea(500,100);
		J.setFont(new Font("sanserif",Font.ITALIC , 30));	
		J.setBounds(0,0,900,800);
		
		try{
			d1 = new DBHelper();
			ResultSet rsobj = d1.getconnect().executeQuery(" select * from BookStore where BookCatogery= '"+s+"' and BookTitle= '"+s1+"' and BookAuthor= '"+s2+"' and BookPrice='"+b+"' and BookStock='"+c+"';");
			J.setText("\n\t   Bill of Book Purchase\n\t-------------------------------------------------");
			
				while(rsobj.next()){
					J.append("\n\t\t\tDate : "+rsobj.getString("Date")); 
					J.append("\n\tBookId         : "+rsobj.getString("BookId"));
					J.append("\n\n\tBookCatogery : "+rsobj.getString("BookCatogery")); 
					J.append("\n\n\tBookTitle      : "+rsobj.getString("BookTitle")); 
					J.append("\n\n\tBookAuthor    : "+rsobj.getString("BookAuthor")); 
					J.append("\n\n\tBookPrice     : "+rsobj.getString("BookPrice")); 
					J.append("\n\n\tBookStock    : "+rsobj.getString("BookStock")); 				
					J.append("\n\n\tTotalBill      : "+rsobj.getString("TotalBill")); 
				}
			}catch(Exception e){	e.printStackTrace();	}
		j.add(J,"Center");
		j.setVisible(true);
	}
	
	public static void showBook(BookStore BObj)
	{
		String s = "BILL of Buy New Book \n";
		s += "\nBook Id :"+BObj.getBookId()+"\nBook Catg :"+BObj.getBookCatogery()+"\nBook Title :"+BObj.getBookTitle()+"\nBook Author :"+BObj.getBookAuthor()+"\nOne Book Price :"+BObj.getBookPrice()+"\nBook Qty :"+BObj.getBookStock()+"\nTotal Amt :"+BObj.getTotalBill()+"\nDate :"+Ld;	
		JOptionPane.showMessageDialog(null,s);
	}
}
//	new Color(0-255-51)		new Color(255-255-153)	new Color(255-153-0)	new Color(153-153-153)	new Color(255-51-51)	new Color(255-204-51)
//	51-204-255	VLY