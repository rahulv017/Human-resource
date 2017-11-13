package control;
import java.sql.*;
public class Retrieve {
	private String sql,id;
	private ResultSet rs;
	private Statement stat;
	private Connection con;
	public String arg[] = new String[6];
	public Retrieve(String n1){
		id=n1;
	}
	public void Select(){
		Connn use = new Connn();
		sql="Select * from personal_info where ID = "+id+";";
		try{
			con=use.getConnection();
			System.out.println("Working");
			stat=con.createStatement();
			System.out.println(sql);
			rs=stat.executeQuery(sql);
			while(rs.next()){
		       arg[0]=rs.getString("FName");
		       arg[1]=rs.getString("LName");
		       arg[2]=rs.getString("Gender");
		       arg[3]=rs.getDate("DOB").toString();
		       arg[4]=rs.getString("Address");
		       arg[5]=rs.getString("Password");
			}
		}catch(Exception e){
			System.err.println(e);
		}finally{
			use.close(con,stat);
		}
	}
}