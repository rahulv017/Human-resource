package control;
import java.sql.*;
public class Connn {
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String dbName = "hrms";
	String userName = "root";
	String password = "";
	Connection con = null;
	public Connection getConnection(){
		try{
			Class.forName(driverName);
			con=DriverManager.getConnection(url+dbName, userName, password);
			System.out.println("Database connection established");
			return con;
		}catch(Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	public boolean verify(String tab,String id){
		Statement stat=null;
		ResultSet rs;
		boolean res=false;
		String sql="Select * from "+tab+" where ID="+id+";";
		try{
			con=this.getConnection();
			System.out.println("Working");
			stat=con.createStatement();
			System.out.println(sql);
			rs=stat.executeQuery(sql);
			if(rs.next())
				res= true;
			else
				res=false;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			this.close(con,stat);
			return res;
		}
	}
	public void close(Connection n,Statement st){
		if(n!=null){
			try{
				n.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		if(st!=null){
			try{
				st.close();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
}