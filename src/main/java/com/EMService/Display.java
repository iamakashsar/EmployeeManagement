package com.EMService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/detail")
public class Display extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><head><title>Employee Details</title>");
        
        
        out.println("<style>"
                + "@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap');"
                + "body { font-family: 'Poppins', sans-serif; background: linear-gradient(135deg, #ece9e6, #ffffff); text-align: center; padding: 20px; }"
                + "h2 { color: #333; margin-bottom: 20px; font-weight: 600; animation: fadeIn 1s ease-in-out; }"
                + "table { width: 80%; margin: 20px auto; border-collapse: collapse; background: white; border-radius: 10px; overflow: hidden; box-shadow: 0px 5px 15px rgba(0, 0, 0, 0.2); animation: slideUp 1s ease-in-out; }"
                + "th, td { padding: 15px; border: 1px solid #ddd; text-align: center; font-size: 16px; }"
                + "th { background-color: #007bff; color: white; font-weight: 600; }"
                + "tr:nth-child(even) { background-color: #f9f9f9; }"
                + "tr:hover { background-color: #f1f1f1; transform: scale(1.02); transition: all 0.3s ease-in-out; }"
                + "button { background-color: #007bff; color: white; border: none; padding: 12px 20px; font-size: 16px; cursor: pointer; border-radius: 6px; margin: 10px; transition: all 0.3s; box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1); }"
                + "button:hover { background-color: #0056b3; transform: translateY(-3px); box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.3); }"
                + "form { display: inline-block; }"
                + "@keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }"
                + "@keyframes slideUp { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }"
                + "</style>");
        
        out.println("</head><body>");
        out.println("<h2>Employee Details</h2>");
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/employeeservice?user=postgres&password=Akash");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            out.println("<table>");
            out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Email</th><th>Phone Number</th><th>Salary</th></tr>");
            
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td><td>" 
                        + rs.getString("name") + "</td><td>" 
                        + rs.getInt("age") + "</td><td>"
                        + rs.getString("gender") + "</td><td>"
                        + rs.getString("email") + "</td><td>"
                        + rs.getString("phno") + "</td><td>"
                        + rs.getDouble("salary") + "</td></tr>");
            }
            out.println("</table>");

            
            out.println("<form action=\"updateEmployee\">"
                    + "<button type=\"submit\">Update Employee</button>"
                    + "</form>");
            out.println("<form action=\"deleteEmployee\">"
                    + "<button type=\"submit\">Delete Employee</button>"
                    + "</form>");
            
            con.close();
        } catch (Exception e) {
            out.println("<p style='color: red;'>Error: " + e.getMessage() + "</p>");
        }
        
        out.println("</body></html>");
        out.close();
    }
}
