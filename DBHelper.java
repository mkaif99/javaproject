package BookShop.Database;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.*;

class DbConfiguration{

	public static final String URL = "jdbc:mysql://localhost/MyProject";
	public static final String USER = "root";
	public static final String PASSWORD = " ";
}

public class DBHelper
{
	Connection conObj = null;
    Statement stObj = null;
    ResultSet rstObj = null;
    private String url;
    private String user;
    private String password;
	
	public DBHelper() throws SQLException {
        this.url = DbConfiguration.URL;
        this.user = DbConfiguration.USER;
        this.password = DbConfiguration.PASSWORD;
    }
	
    public Statement getconnect() throws SQLException {

        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        conObj = DriverManager.getConnection(url, user, password);
        stObj = conObj.createStatement();
        return stObj;
    }
	
	public void setRecords(String query) {
        try {
            getconnect().executeUpdate(query);
        } catch (SQLException e) {
            System.out.print(e);
        }

    }
	
	public ResultSet getRecords(String query) {
        try {
            return getconnect().executeQuery("Select * from " + query + "");
        } catch (SQLException e) {
            System.out.print("Error to Coonect Resultset");
        }
        return null;
    }
	
	
/*	public ResultSet Tables(ResultSet rsobj)
	{	
	try{
		JTable j = new JTable();
			ResultSetMetaData rsmd = rsobj.getMetaData();
			j=new JTable();
			DefaultTableModel model = (DefaultTableModel)j.getModel();
			
			int cols = rsmd.getColumnCount();
			String colName[] = new String[cols];
			
			for(int i=0; i<cols; i++)
				colName[i] = rsmd.getColumnName(i+1);
			
				model.setColumnIdentifiers(colName);
				String Id,cat,tit,aut,pr,st,tb,d;
				
			while(rsobj.next()){
				Id = rsobj.getString(1);
				cat = rsobj.getString(2);
				tit = rsobj.getString(3);
				aut = rsobj.getString(4);
				pr = rsobj.getString(5);
				st = rsobj.getString(6);
				tb = rsobj.getString(7);
				d = rsobj.getString(8);
				String[] row = {Id,cat,tit,aut,pr,st,tb,d};
				model.addRow(row);
			}
	}catch(Exception e){}
			return rsobj;
	}		*/
}