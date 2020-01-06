package Tester;
import java.sql.*;


public class AddDrugDBHelper {
	
	//Essentially I can Call this method to Create a new Row in my Drug Table
	public static int save(String drug_Name, int drug_Price, int drug_Quantity){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into drug_table(drug_Name,drug_Price,drug_Quantity) values(?,?,?)");
			ps.setString(1,drug_Name);
			ps.setInt(2,drug_Price);
			ps.setInt(3,drug_Quantity);
			status=ps.executeUpdate(); // returns 1 if the update was successful or 0 if it was not successful
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}


}
