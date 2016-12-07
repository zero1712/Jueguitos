/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import jsf.dao.LoginDAO;

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
@Named(value = "login")
@Dependent
public class Login implements Serializable{

    /**
     * Creates a new instance of Login
     */
    private static final long serialVersionUID = 1094801825228386363L;
	
	private static  String pwd;
	private static  String msg;
	private static  String user;
        
        private static String j;
        private static String u;

    public  String getJ() {
        return j;
    }

    public  void setJ(String j) {
        Login.j = j;
    }

    public  String getU() {
        return u;
    }

    public  void setU(String u) {
        Login.u = u;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    //validate login
	public String validateUsernamePassword() {
               
		//boolean valid = LoginDAO.validate(user, pwd);
                int valid = LoginDAO.validate(user, pwd);
		if ((valid==1)||(valid==2)||(valid==3)) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", user);
                        session.setAttribute("tipo", valid);
                        session.setAttribute("clave", LoginDAO.claveUsuario(user));
			return "index";
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Incorrect Username and Passowrd",
							"Please enter correct username and Password"));
			return "index";
		}
	}

	//logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "index";
	}
        
        public String actualizaRecord(){
            System.out.println("entre update");
            boolean update = LoginDAO.actualizaRecord(Integer.parseInt(j), Integer.parseInt(u));
            System.out.println("regrese update");
            if(update){
                System.out.println("regrese true");
                if(Integer.parseInt(j)==1)
                    return "Saludador.html";
                if(Integer.parseInt(j)==2)
                    return "FizzFazz.html";
                if(Integer.parseInt(j)==3)
                    return "PiePapTij.html";
            }else{
                System.out.println("regrese false");
                if(Integer.parseInt(j)==1)
                    return "Saludador.html";
                if(Integer.parseInt(j)==2)
                    return "FizzFazz.html";
                if(Integer.parseInt(j)==3)
                    return "PiePapTij.html";
            }
            return "Saludador.html";
            
        }

    public Login() {
    }
    
}
