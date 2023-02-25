package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.BankingDao;
import Dao.BankingDaoImpl;
import Entity.Account;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("BankingApplication_beans.xml");
		BankingDao dao = (BankingDaoImpl) context.getBean("BankingDaoImpl");
		
		
		Integer accountId = Integer.parseInt(request.getParameter("userID"));	
		String password = (String) request.getParameter("userPassword");
		
		Account acc = (Account) dao.fetchAccountWithIDandPassword(accountId, password);
		
		HttpSession session = request.getSession();
		session.setAttribute("account", acc);
		
		if (acc != null) {
			response.sendRedirect("optionsPage.jsp");
		}

		else {
			session.setAttribute("loginMessage", "Login failed! Please enter correct credentials");
			response.sendRedirect("login.jsp");
		}

	}

}
