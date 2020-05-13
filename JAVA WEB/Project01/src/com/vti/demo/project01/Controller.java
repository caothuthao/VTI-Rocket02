package com.vti.demo.project01;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstNameInput = request.getParameter("firstName");
		String lastNameInput = request.getParameter("lastName");
		String emailInput = request.getParameter("email");
		
		Student student01 = new Student(firstNameInput, lastNameInput, emailInput);
		
		// Step 1: add data
		List<Student> listStudent1 = new ArrayList<>();
		listStudent1.add(student01);
		
		request.setAttribute("listStudents", listStudent1);
		
		//Step 2: get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("View02.jsp");
		
		//step 3:
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
