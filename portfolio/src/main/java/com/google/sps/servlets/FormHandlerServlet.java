package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String name = request.getParameter("Name");
    String email = request.getParameter("Email");
    String message = request.getParameter("Message");

    // Print the value so you can see it in the server logs.
    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
    System.out.println("Message: " + message);

    //redirect user
    response.sendRedirect("http://aaggarwal-sps-summer22.appspot.com/");
  }
}