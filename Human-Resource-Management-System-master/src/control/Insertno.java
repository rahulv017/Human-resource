package control;
import java.sql.*;
public class Insertno {
	private String id,no;
	private ResultSet rs;
	private Statement stat;
	private Connection con;
	private boolean res=true;
	public Insertno(String n1,String n2){
		id = "'"+n1+"'";
		no = "'"+n2+"'";
	}
	public boolean verify(){
		String sql="Select * from contact_no where ID="+id+" and Mobile_No ="+no+";";
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
		String sql = "Insert into contact_no values("+id+","+no+");";
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