import BookShop.modal.*;
import BookShop.Controller.*;
import BookShop.view.*;
import java.util.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;	

class MainWindow extends Frame implements ActionListener
{
	public static void main(String ...q)
	{	
		MainWindow m= new MainWindow();	
	}
	
	MenuBar Bar;
	Menu B ,C, S, S1;
	MenuItem  Pur, SerB, Pur1, SerC, TS, TS1, SalDel, SupDel;
	Font f;
	Image img;
	
	public MainWindow()
	{
		setTitle("Book Store Management");
		setSize(1700,900);
		setLocation(110,60);
		setBackground(Color.BLACK);
		f = new Font("Arial", Font.BOLD, 17); 
		Toolkit tObj = Toolkit.getDefaultToolkit();
		img = tObj.getImage("D://Images//books.jpg");
		
		Cursor Cobj = tObj.createCustomCursor(img, new Point(25,25),"MyCursor");		
		setCursor(Frame.HAND_CURSOR);
		setIconImage(img);
		
		Bar = new MenuBar();
		B = new Menu("Book");
	//	B.setHorizontalAlignment(Menu.CENTER);
		C = new Menu("Customer");
		S = new Menu("Sales");
		S1 = new Menu("Supply");
		f = new Font("Arial", Font.BOLD, 17);
		setFont(f);
		B.setFont(new Font("sans-serif",Font.BOLD, 18));
		C.setFont(new Font("sans-serif",Font.BOLD, 18));
		S.setFont(new Font("sans-serif",Font.BOLD, 18));
		S1.setFont(new Font("sans-serif",Font.BOLD, 18));
		
		Pur = new MenuItem("Buy Book");
		SerB = new MenuItem("Search Book");
		
		Pur1 = new MenuItem("Sale Book");
		SerC = new MenuItem("Search Customer");
		
		TS = new MenuItem("Total Sales");
		SalDel = new MenuItem("Delete Customer");
		
		TS1 = new MenuItem("Total Supply");
		SupDel = new MenuItem("Delete Supplier");
		
		B.add(Pur);		B.add(SerB);	
		C.add(Pur1);	C.add(SerC);
		S.add(TS);		S.add(SalDel);
		S1.add(TS1);	S1.add(SupDel);
		
		Bar.add(B);
		Bar.add(C);
		Bar.add(S);
		Bar.add(S1);
		
		setMenuBar(Bar);
		
		SerB.addActionListener(this);
		Pur.addActionListener(this);
		Pur1.addActionListener(this);
		SerC.addActionListener(this);
		TS.addActionListener(this);
		TS1.addActionListener(this);
		SalDel.addActionListener(this);
		SupDel.addActionListener(this);
		
		addWindowListener(new MyWin());
		setVisible(true);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent AObj){
		
		if(AObj.getSource()==Pur){				// Buy Books
			new ViewBook();
		}
		else if(AObj.getSource()==SerB){		// Search Book
			new SearchBook();
		}
		else if(AObj.getSource()==Pur1){		// Sale
			new ViewCustomer();
		}
		else if(AObj.getSource()==SerC){		// Search Customer
			new SearchCustomer();
		}
		else if(AObj.getSource()==TS){			// Total Sales
			new CustomerController();
		}
		else if(AObj.getSource()==TS1){			// Total Supply		
			new BookController();
		}
		else if(AObj.getSource()==SalDel){			// Delete Sale	
			new DeleteSal();
		}
		else if(AObj.getSource()==SupDel){			// Delete Supply	
			new Deletee();
		}
	}
	
	public void paint(Graphics Gobj)
	{
		Gobj.drawImage(img,25,40,1650,850,this);
	}
}

class MyWin extends WindowAdapter
{
	public void windowClosing(WindowEvent wObj)
	{		System.exit(0);			}
}

//	javac -cp c:\com.mysql.jdbc_5.1.5.jar;d:\MyProjectClass MainWindow.java
//	java -cp c:\com.mysql.jdbc_5.1.5.jar;d:\MyProjectClass;. MainWindow
