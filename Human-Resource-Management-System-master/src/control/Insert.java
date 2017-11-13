package control;
import java.sql.*;
public class Insert {
	private String id,fn,ln,sex,DOB,add,pwd;
	private boolean c=true;
	private ResultSet rs;
	private Statement stat;
	private Connection con;
	Connn use = new Connn();
	public Insert(String n1,String n2,String n3,String n4,String n5,String n6,String n7){
		this.id="'"+n1+"'";
		this.fn="'"+n2+"'";
		this.ln="'"+n3+"'";
		this.sex="'"+n4+"'";
		this.DOB="'"+n5+"'";
		this.add="'"+n6+"'";
		this.pwd="'"+n7+"'";
	}
	public boolean add(){
		if((use.verify("personal_info",id))){
			return false;
		}
		else{
			String sql = "Insert into personal_info (ID, FName, LName, Gender, DOB, Address, "
			+ "Password) values("+id+","+fn+","+ln+","+sex+","+DOB+","+add+","+pwd+")";
			try{
				con=use.getConnection();
				System.out.println("Working");
				stat=con.createStatement();
				System.out.println(sql);
				stat.execute(sql);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}finally{
					use.close(con, stat);
				}
				return true;
		}
	}
}