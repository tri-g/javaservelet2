package org.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.entity.User;
import org.model.UsersModel;

@WebServlet("/listusers")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/project")
	private DataSource dataSource;
    
    public HomeController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String page=request.getParameter("page");
	page=page.toLowerCase();
	switch(page)
	{
/*	case "home":
		request.getRequestDispatcher("index.jsp").forward(request,response);
		break;*/
	case "listusers":
		List<User> listUsers=new ArrayList<>();
		listUsers=new UsersModel().listUsers(dataSource);
		request.setAttribute("listUsers",listUsers);
		request.getRequestDispatcher("listUser.jsp").forward(request,response);
		break;
	case "error":
		request.getRequestDispatcher("error.jsp").forward(request,response);

		
	}
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
