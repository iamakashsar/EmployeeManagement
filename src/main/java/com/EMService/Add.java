package com.EMService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.EmployeeDataBase.DatabaseDriver;
import com.EmployeeDataBase.Employee;

@WebServlet("/add")
public class Add extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String i = req.getParameter("id");
        int id = Integer.parseInt(i);
        String name = req.getParameter("name");
        String a = req.getParameter("age");
        int age = Integer.parseInt(a);
        String gender = req.getParameter("gender");
        String email = req.getParameter("email");
        String phno = req.getParameter("phno");
        String sal = req.getParameter("salary");
        double salary = Double.parseDouble(sal);

        Employee e = new Employee(id, name, age, gender, email, phno, salary);
        DatabaseDriver d = new DatabaseDriver();
        try {
            int ss = d.insert(e);
            if (ss == 1) {
                RequestDispatcher dw = req.getRequestDispatcher("index.html");
                dw.forward(req, resp);
            }
        } catch (SQLException e1) {
        	
			    resp.setContentType("text/html; charset=UTF-8");  // Set UTF-8 encoding
			    PrintWriter out = resp.getWriter();
			    out.println("<html><head><title>Delete Failed</title>");
			    out.println("<meta charset='UTF-8'>");  // Add UTF-8 Meta Tag
			    out.println("<style>");

			    // General Styling
			    out.println("body { display: flex; justify-content: center; align-items: center; height: 100vh; background: linear-gradient(135deg, #ece9e6, #ffffff); font-family: 'Poppins', sans-serif;}");
			    out.println(".message-container { text-align: center; padding: 30px; background: white; border-radius: 12px; box-shadow: 0px 8px 20px rgba(0,0,0,0.1); animation: fadeIn 1s ease-in-out; max-width: 400px;}");
			    
			    // Fade-in Effect
			    out.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(-20px); } to { opacity: 1; transform: translateY(0); } }");
			    
			    // Crying Face with Tears Animation
			    out.println(".crying-face { font-size: 60px; position: relative; animation: popOut 1s ease-in-out;}");
			    out.println("@keyframes popOut { from { transform: scale(0.8); opacity: 0; } to { transform: scale(1); opacity: 1; } }");
			    
			    out.println(".tear { position: absolute; font-size: 18px; color: #0099ff; animation: dropTear 1.5s infinite alternate ease-in-out; }");
			    out.println(".tear.left { top: 10px; left: 35px; }");
			    out.println(".tear.right { top: 10px; right: 35px; animation-delay: 0.5s; }");
			    out.println("@keyframes dropTear { 0% { transform: translateY(0px); opacity: 1; } 100% { transform: translateY(15px); opacity: 0; } }");

			    // Error Message
			    out.println("h1 { color: #ff4b5c; font-size: 22px; font-weight: 600; margin-bottom: 10px; }");
			    out.println("p { color: #666; font-size: 16px; margin-bottom: 20px; }");
			    
			    // Button Styling
			    out.println(".btn { display: inline-block; padding: 10px 20px; background: #ff4b5c; color: white; text-decoration: none; border-radius: 6px; transition: 0.3s ease-in-out; font-size: 16px; font-weight: 500;}");
			    out.println(".btn:hover { background: #d43f4e; transform: scale(1.05); box-shadow: 0px 4px 10px rgba(0,0,0,0.2);}");

			    out.println("</style></head><body>");
			    out.println("<div class='message-container'>");

			    // Crying Face with Subtle Tears
			    out.println("<div class='crying-face'>😢");  // Crying emoji should render correctly now
			    out.println("<span class='tear left'>💧</span>");
			    out.println("<span class='tear right'>💧</span>");
			    out.println("</div>");

			    // Error Message
			    out.println("<h1>Adding Failed</h1>");
			    out.println("<p>The employee record could not be added. Please check the data you entered and try again.</p>");
			    out.println("<a href='Add.html' class='btn'>Retry</a>");

			    out.println("</div>");
			    out.println("</body></html>");
			
            RequestDispatcher dw = req.getRequestDispatcher("Add.html");
            dw.include(req, resp);
        }
    }
}
