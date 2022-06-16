package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
//import org.jsoup.safety.Whitelist;

/** Servlet responsible for creating new messages. */
@WebServlet("/new-message")
public class NewMessageServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Sanitize user input to remove HTML tags and JavaScript.
    // String title = Jsoup.clean(request.getParameter("name"), Whitelist.none());
    // long timestamp = System.currentTimeMillis();

    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String message=request.getParameter("message");


    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Message");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name", name)
            .set("email", email)
            .set("message",message)
            .build();
    datastore.put(taskEntity);

    response.sendRedirect("/index.html");
  }
}