/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jueguitos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * Servlet implementation class Programa4
 */
@WebServlet(description = "Fizz Bazz Buzz", urlPatterns = { "/Fizz" })
public class Fizz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fizz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i=1;
		String nombre = request.getParameter("nombre");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                out.println("<link rel=\"stylesheet\" href=\"../Jueguitos/faces/assets/css/main.css\" />");
		out.println("Fizz Bazz Buzz");
		out.println();
		out.println(i);
		++i;
		while (i<=50){			
			if (i%3==0 && i%5==0){
				out.println(i+" Buzz");
                                out.println("<br>");
			}else if(i%3==0){
				out.println(i+" Fizz");
                                 out.println("<br>");
			}else if(i%5==0){
				out.println(i+" Bazz");
                                 out.println("<br>");
			}else{
				out.println(i);
                                 out.println("<br>");
			}
			i++;
		}
                out.println("<form action=\"/Jueguitos/faces/juegos/View.xhtml\">");
	        out.println("<input type=\"submit\" value=\"Regresar\">");
	        out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
