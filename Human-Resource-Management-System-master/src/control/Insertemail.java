package control;
import java.sql.*;
public class Insertemail {
	private String id,email;
	private ResultSet rs;
	private Statement stat;
	private Connection con;
	private boolean res=true;
	public Insertemail(String n1,String n2){
		id = "'"+n1+"'";
		email = "'"+n2+"'";
	}
	public boolean verify(){
		String sql="Select * from emailid where ID="+id+" and E_mail_ID="+email+";";
		Connn use = new Connn();
		try{
			con=use.getConnection();
			System.out.println("Working");
			stat=con.createStatement();
			System.out.println(sql);
			rs=stat.executeQuery(sql);
			if(rs.next())
				res=false;
			else
				res=true;
		}catch(Exception e){
			System.out.println(e.getMessage());
			res=false;
		}finally{
			use.close(con,stat);
			return res;
		}
	}
	public boolean add(){
		Connn use = new Connn();
		if(!use.verify("professional_info", id)){
			return false;
		}
		String sql = "insert into emailid values("+id+","+email+");";
			try{
				con=use.getConnection();
				System.out.println("Working");
				stat=con.createStatement();
				System.out.println(sql);
				stat.executeUpdate(sql);
				}catch(Exception e){
					System.out.println(e.getMessage());
					res=false;
				}finally{
					use.close(con, stat);
					return res;
				}
	}
}
