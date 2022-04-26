package com.laioffer.onlineOrder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.onlineOrder.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {     // Servlet to process data from backend
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");

        JSONObject customer = new JSONObject();
        customer.put("email", "sun@laioffer.com");
        customer.put("firstName", "rick");
        customer.put("lastName", "sun");
//        customer.put("age", 50);
        response.getWriter().print(customer);


//        // Hello
//        PrintWriter out = response.getWriter();
//        String customer = request.getParameter("customer");  // uppercase sensitive
////        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + customer + "</h1>");
//        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));

        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer = objectMapper.readValue(IOUtils.toString(request.getReader()), Customer.class);
        System.out.println(customer.getEmail());
        System.out.println(customer.getFirstName());
        System.out.println(customer.getLastName());
//        String email = jsonRequest.getString("email");
//        String firstName = jsonRequest.getString("firstName");
//        String lastName = jsonRequest.getString("lastName");
////        int age = jsonRequest.getInt("age");
//        // Print customer information to IDE console
//        System.out.println("Email is: " + email);
//        System.out.println("First name is: " + firstName);
//        System.out.println("Last name is: " + lastName);
//        System.out.println("Age is: " + age);
        // Return status = ok as response body to the client
        response.setContentType("application/json");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("status", "ok");
        response.getWriter().print(jsonResponse);

    }
    public void destroy() {
    }
}