package control;
import java.sql.*;
public class Remove {
	String id;
	boolean res=false;
	private Statement stat;
	private Connection con;
	public Remove(String n){
		id=n;
	}
	public boolean subtract(){
		Connn use = new Connn();
		String tab[]={"personal_info","professionl_info","attendence","e-mail_id","contact_no"};
		if(!use.verify("professional_info", id)){
			return false;
		}
		else{
			for(int i=0;i<tab.length;i++){
				String sql="Delete from"+tab[i]+"where ID = "+id+";";
				try{
					con=use.getConnection();
					System.out.println("Working");
					stat=con.createStatement();
					System.out.println(sql);
					stat.executeUpdate(sql);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}finally{
					use.close(con, stat);
				}
			}
			return true;
		}
	}
}