/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguitos;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolaMundo
 */
@WebServlet(
		description = "chalala", 
		urlPatterns = { "/Saludador" }, 
		initParams = { 
				@WebInitParam(name = "malo1", value = "OSAMA", description = "palabra uno"), 
				@WebInitParam(name = "malo2", value = "ATILA", description = "palabra dos"), 
				@WebInitParam(name = "malo3", value = "HITLER", description = "palabra tres"),
				@WebInitParam(name = "malo4", value = "PEÑA", description = "palabra cuatro"),
				@WebInitParam(name = "malo5", value = "NUÑEZ", description = "palabra cinco"),
				@WebInitParam(name = "malo6", value = "OSORIO", description = "palabra seis")
		})
public class Saludador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Enumeration<String> nomb;
	
    /**
     * Default constructor. 
     */
    public Saludador() {
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.nomb = config.getInitParameterNames();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        this.init(getServletConfig());
        boolean ban = true;
        while (this.nomb.hasMoreElements()) {
        	String name = (String) this.nomb.nextElement();
            if(getInitParameter(name).equals(nombre.toUpperCase())){
            	ban = false;
            	out.println("No te saludare malosis");
            	break;
            	
            }
          } 
        if(ban){
        	out.println("Hola "+nombre);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}