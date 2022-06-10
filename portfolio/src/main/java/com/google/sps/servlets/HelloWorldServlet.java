package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
    List<String> facts=Arrays.asList("I have never lost a game of Othello.","I was born in Delhi, India.","My second toe is bigger than my first toe.","I can touch my nose with my tongue.");
    Gson gson = new Gson();
    String json = gson.toJson(facts);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);

  }
}
