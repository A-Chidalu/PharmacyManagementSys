package Tester;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddClientDBHelper {
	
	
	//Essentially I can Call this method to Create a new Row in my Drug Table
	public static int save(String client_name, String client_email, int client_nod){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into client_table(client_name,client_email,client_nod) values(?,?,?)");
			ps.setString(1,client_name);
			ps.setString(2,client_email);
			ps.setInt(3,client_nod);
			status=ps.executeUpdate(); // returns 1 if the update was successful or 0 if it was not successful
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	

}
