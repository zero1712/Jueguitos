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
 * @author Cyntia Yomally Osorno López
 * @author Cesar Gibran Cadena Espinoza
 * @author Hever Luis Alvarez Carmona
 * @author Albaro Tonatihu Fabian Silverio
 * @author Jhonatan Saúl Ramírez Bravo
 * @version 06/12/2016
 * 
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
public static int claveUsuario(String user){
    Connection con = null;
		PreparedStatement ps = null;
                Statement stm;
                ResultSet rs;
                String sql = "select clave from usuarios where login ='"+user+"'";
                System.out.println("Usuario: "+user);
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
                                int tipo= rs.getInt("clave");
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
public static boolean actualizaRecord(int j, int usuario){
                Connection con = null;
		PreparedStatement ps = null;
                PreparedStatement ps2 = null;
                Statement stm;
                ResultSet rs;
                String sql = "update records set record=? where cve_juego =? and cve_usuario =?";
                String sql2 = "select record from records where cve_usuario="+usuario;
                String sql3 = "insert into records(cve_juego,cve_usuario,record) values(?,?,?)";
                
                System.out.println("cve_Juego: "+j+" cve_usuario: "+usuario);
                try{
                    con = DataConnect.getConnection();
                    ps = con.prepareStatement(sql2);
                    
                    stm= DataConnect.getConnection().createStatement();
                        rs=stm.executeQuery(sql2);
                        if (rs.next()) {
				//result found, means valid inputs
                                int tipo= rs.getInt("record");
                                
				ps = con.prepareStatement(sql);
                                ps.setInt(1,tipo+1);
                                ps.setInt(2, j);
                                ps.setInt(3, usuario);
                    
                                int n = ps.executeUpdate();
                                if(n>0)
                                    return true;    
                                
                        }
                        ps2 = con.prepareStatement(sql3);
                        ps2.setInt(1, j);
                        ps2.setInt(2,usuario);
                        ps2.setInt(3, 1);
                        boolean n = ps2.execute();
                                if(n)
                                    return true; 
                    
                    
                }catch (SQLException ex) {
			System.out.println("Update error -->" + ex.getMessage());
			return false;
		} finally {
			DataConnect.close(con);
		}
                return false;
}
}
