package com.faiz.emp.rest.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Cookie;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

/**
 * Servlet implementation class EmpClientServlet
 */
@WebServlet("/EmpClientServlet")
public class EmpClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Client client = Client.create();
		
		String empId =(String) request.getParameter("empId");
		System.out.println(" empId = " + empId);
		
		Form form = new Form();
		form.add("empId", empId);
		
		
		
		WebResource webResource = client.resource("http://localhost:8080/FaizRestProject/api/v3/status/fp");

		ClientResponse clientResponse = webResource.accept("text/html").post(ClientResponse.class, form);
	
		
		if(clientResponse.getStatus() == 200){
			String output = clientResponse.getEntity(String.class);
			out.println(output);
				
		}
	}

}
