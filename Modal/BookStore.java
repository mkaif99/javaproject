package BookShop.modal;
import java.sql.*;
import java.time.LocalDate;

public class BookStore
{
	private int BookId;
	private String BookCatogery;
	private String BookTitle;
	private String BookAuthor;
	private int BookPrice;
	private int BookStock;
	private int TotalBill;
	LocalDate Ld;
	
	public BookStore()
	{
		BookId = 101;
		BookCatogery = "Programming";
		BookTitle = "Java";
		BookAuthor = "Ks Publisher";
		BookPrice = 100;
		BookStock = 10;
	}
	
	public BookStore( String BookCatogery, String BookTitle, String BookAuthor, int BookPrice, int BookStock, LocalDate Ld, int TotalBill)
	{
		this.BookCatogery = BookCatogery;
		this.BookTitle = BookTitle;
		this.BookAuthor = BookAuthor;
		this.BookPrice = BookPrice;
		this.BookStock = BookStock;
		this.Ld = Ld;
		this.TotalBill = TotalBill;
	}
	
	public void setBookId(int BookId){			this.BookId = BookId;	}
	public int getBookId(){						return BookId;			}
	
	public void setBookCatogery(String BookCatogery){		this.BookCatogery = BookCatogery;		}
	public String getBookCatogery(){					return BookCatogery;				}
	
	public void setBookTitle(String BookTitle){	this.BookTitle = BookTitle;		}
	public String getBookTitle(){				return BookTitle;				}
	
	public void setBookAuthor(String BookAuthor){		this.BookAuthor = BookAuthor;	}
	public String getBookAuthor(){					return BookAuthor;			}
	
	public void setBookPrice(int BookPrice){				this.BookPrice = BookPrice;		}
	public int getBookPrice(){						return BookPrice;			}
	
	public void setBookStock(int BookStock){			this.BookStock = BookStock;		}
	public int getBookStock(){						return BookStock;			}
	
	public void setTotalBill(int TotalBill){			this.TotalBill = TotalBill;		}
	public int getTotalBill(){						return TotalBill;			}
	
	public void setDate(LocalDate Ld){			this.Ld = Ld;		}
	public LocalDate getDate(){						return Ld;			}
}