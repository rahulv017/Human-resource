package control;
import java.sql.*;
import java.util.ArrayList;
public class RetrieveEmail {
	private String sql,id;
	private ResultSet rs;
	private Statement stat;
	private Connection con;
	public ArrayList al = new ArrayList();
	public RetrieveEmail(String n1){
		id=n1;
	}
	public void Select(){
		Connn use = new Connn();
		sql="Select * from e-mail_id where ID = "+id+";";
		try{
			con=use.getConnection();
			System.out.println("Working");
			stat=con.createStatement();
			System.out.println(sql);
			rs=stat.executeQuery(sql);
			while(rs.next()){
		       al.add(rs.getString("E_mail_ID"));
			}
		}catch(Exception e){
			System.err.println(e);
		}finally{
			use.close(con,stat);
		}
	}
}