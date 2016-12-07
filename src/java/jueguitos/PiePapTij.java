/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguitos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
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
/**
 * Servlet implementation class piepaptij
 */
@WebServlet("/PiePapTij")
public class PiePapTij extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int val;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PiePapTij() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String desicion="";
		String valor = request.getParameter("gender");
                System.out.println("Soy valor "+valor);
		int tiro =0;
		val = Integer.parseInt(valor);
                
                System.out.println("soy val"+ val);

                 String nombre = request.getParameter("nombre");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
           out.println("<link rel=\"stylesheet\" href=\"../Jueguitos/faces/assets/css/main.css\" />");
		 tiro = (int)(Math.random()*(3-1+1)+1);
                 System.out.println("Soy tiro"+ tiro);
		 if(val == tiro){
                     System.out.println("Pase aqui");
                     System.out.println(val==tiro);
			 if(val == 1){
				 out.println(" empate en piedra");
				// JOptionPane.showMessageDialog(null, "empate en piedra");
				 desicion = "Empate";
				 //getServletContext().log("Empate en piedra");
			 }else if(val==2){out.println(" empate en papel"); desicion = "Empate"; JOptionPane.showMessageDialog(null, "empate en papel"); getServletContext().log("Empate en papel");}else if(val==3){
				 out.println(" empate en tijera");
				 //JOptionPane.showMessageDialog(null, "empate en tijera");
				 //getServletContext().log("Empate en tijera");
				 desicion = "Empate";
			 }
		 }else if(val==1 && tiro==2){
			 out.println( "Tiro de la maquina 'papel' gana la maquina usuario piedra");
			// JOptionPane.showMessageDialog(null, "Tiro de la maquina 'papel' gana la maquina usuario piedra");
			// getServletContext().log("El usuario perdio");
			 desicion = "Pierde el usuario";
		 }else if(val==2 && tiro==1){
			 out.println("Tiro de la maquina 'piedra' gana el usuario con papel");
			 //JOptionPane.showMessageDialog(null, "Tiro de la maquina 'piedra' gana el usuario con papel");
			 //getServletContext().log("El usuario gano");
			 desicion = "Gana el usuario";
		 }else if(val==2 && tiro==3){
			 out.println("Tiro de la maquina 'tijera' gana la maquina usuario tiro papel");
			 //JOptionPane.showMessageDialog(null, "Tiro de la maquina 'tijera' gana la maquina usuario tiro papel");
			 //getServletContext().log("El usuario perdio");
			 desicion = "Pierde el usuario";
		 }else if(val==3 && tiro==2){
			 out.println("Tiro de la maquina 'papel' gana el usuario tiro tijera");
			 //JOptionPane.showMessageDialog(null, "Tiro de la maquina 'papel' gana el usuario tiro tijera");
			 //getServletContext().log("El usuario gano");
			 desicion = "Gana el usuario";
		 }else if(val==1 && tiro==3){
			 out.println("Tiro de la maquina 'tijera' gana el usuario tiro piedra");
			 //JOptionPane.showMessageDialog(null, "Tiro de la maquina 'tijera' gana el usuario tiro piedra");
			 //getServletContext().log("El usuario gano");
			 desicion = "Gana el usuario";
		 }else if(val==3 && tiro==1){
			 out.println("Tiro de la maquina 'piedra' gana la maquina usuario tiro tijera");
			 //JOptionPane.showMessageDialog(null, "Tiro de la maquina 'piedra' gana la maquina usuario tiro tijera");
		        //getServletContext().log("El usuario perdio");
		        desicion = "Pierde el usuario";
		 }
		 
			response.setContentType("text/html");
			out.println("<form action=\"/Jueguitos/faces/juegos/View.xhtml\">");
	       
	       

	        out.println("<input type=\"submit\" value=\"Regresar\">");
	      
	        out.println("</form>");
		 
		 
		 
		// response.sendRedirect("Menu.html");
		        
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
