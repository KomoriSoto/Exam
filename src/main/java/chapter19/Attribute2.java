package chapter19;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns={"/chapter19/attribute2"})
public class Attribute2 extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);

		ServletContext context=getServletContext();
		List<String> list=Collections.list(context.getAttributeNames());
		for (String name : list) {
			out.println("<p>"+name+" : ");
			out.println(context.getAttribute(name));
			out.println("</p>");
		}

		Page.footer(out);
	}
}

