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
 * @author Fabian
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

    public Login() {
    }
    
}
