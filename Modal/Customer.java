package BookShop.modal;
import java.sql.*;
import java.time.LocalDate;

public class Customer
{
	private int CustomerId;
	private String CustomerName;
	private String PhoneNo;
	private String BookCatogery;
	private String BookName;
	private int BookPrice;
	private int Quantity;
	private int TotalAmt;
	LocalDate Ld;
	
	public Customer()
	{
		CustomerId = 101;
		CustomerName = "Kaif";
		PhoneNo = "7611033575";
		BookCatogery = "Science Fiction";
		BookName = "Physcis";
		Quantity = 2;
		TotalAmt = 200;
	}
	
	public Customer(String CustomerName, String PhoneNo, String BookCatogery, String BookName, int BookPrice, int Quantity, LocalDate Ld, int TotalAmt)
	{
		this.CustomerName = CustomerName;
		this.PhoneNo = PhoneNo;
		this.BookCatogery = BookCatogery;
		this.BookName = BookName;
		this.BookPrice = BookPrice;
		this.Quantity = Quantity;
		this.Ld = Ld;
		this.TotalAmt = TotalAmt;	
	}
	
	public void setCustomerID(int CustomerId){		this.CustomerId = CustomerId;		}
	public int getCustomerId(){				return CustomerId;			}
	
	public void setCustomerName(String CustomerName){		this.CustomerName = CustomerName;		}
	public String getCustomerName(){				return CustomerName;			}
	
	public void setPhoneNo(String PhoneNo){		this.PhoneNo = PhoneNo;		}
	public String getPhoneNo(){				return PhoneNo;			}
	
	public void setBookCatogery(String BookCatogery){		this.BookCatogery = BookCatogery;		}
	public String getBookCatogery(){					return BookCatogery;				}
	
	public void setBookName(String BookName){		this.BookName = BookName;}
	public String getBookName(){					return BookName;				 }
	
	public void setBookPrice(int BookPrice){		this.BookPrice = BookPrice;		}
	public int getBookPrice(){					return BookPrice;			}
	
	public void setQuantity(int Quantity){		this.Quantity = Quantity;		}
	public int getQuantity(){					return Quantity;			}
	
	public void setTotalAmt(int TotalAmt){	this.TotalAmt = TotalAmt;		}
	public int getTotalAmt(){					return TotalAmt;					}
	
	public void setDate(LocalDate Ld){			this.Ld = Ld;		}
	public LocalDate getDate(){						return Ld;			}
}