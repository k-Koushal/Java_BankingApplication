package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

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


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RegisterServlet() {
        super();
    
    }



	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();
	      ApplicationContext context=new ClassPathXmlApplicationContext("BankingApplication_beans.xml");
	      BankingDao dao=(BankingDaoImpl)context.getBean("BankingDaoImpl");
		
		try {
			String name=request.getParameter("userName");
			String dob=String.valueOf(request.getParameter("userDOB"));
			String address=request.getParameter("userAddress");
			String email= request.getParameter("userEmail");
			String password=request.getParameter("userPassword");
			String accountType=request.getParameter("userAccountType");
			
			Account acc= new Account(name,dob,address,email,password,accountType);
			
			dao.saveAccount(acc);
			Integer accID= acc.getAccountId();
			
		HttpSession session=request.getSession();
		session.setAttribute("message", "Account Successfully Registered | your userID is: " +accID);
			
			response.setContentType("text/html;charset=UTF-8l");
			response.sendRedirect("register.jsp");
			
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}


}
