/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jsf.util.DataConnect;

/**
 *
 * @author Fabian
 */
public class LoginDAO {
    
public static int validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;
                Statement stm;
                ResultSet rs;
                String sql = "select login, password,tipo from usuarios where login ='"+user+"' and password ='"+password+"'";
                System.out.println("Usuario: "+user+" Pasword: "+password);
		try {
			/**con = DataConnect.getConnection();
			ps = con.prepareStatement("select login, password from usuarios where login ="+user+" and password ="+password);
			//ps.setString(1, user);
			//ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//result found, means valid inputs
				return true;
                                * 
			}**/
                        
                        stm= DataConnect.getConnection().createStatement();
                        rs=stm.executeQuery(sql);
                        if (rs.next()) {
				//result found, means valid inputs
                                int tipo= rs.getInt("tipo");
				return tipo;
                                
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return 100;
		} finally {
			DataConnect.close(con);
		}
		return 100;
	}
}
