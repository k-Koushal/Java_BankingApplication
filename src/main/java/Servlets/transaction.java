package Servlets;

import java.io.IOException;
import java.util.List;

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
import Entity.Transactions;

public class transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ApplicationContext context = new ClassPathXmlApplicationContext("BankingApplication_beans.xml");
		BankingDao dao = (BankingDaoImpl) context.getBean("BankingDaoImpl");

		Double amount = Double.parseDouble(request.getParameter("transactionAmount"));
		String modeofTransaction = String.valueOf(request.getParameter("transactionType")).toLowerCase();
		System.out.println(modeofTransaction);
		
		HttpSession session = request.getSession();
		Integer accId=(Integer)session.getAttribute("accId");
		String password=(String)session.getAttribute("password");
		
		Account acc= dao.fetchAccount(accId);
		Double beforeBalance=acc.getBalance();

		if (acc != null) {
			
			if(modeofTransaction.equalsIgnoreCase("deposit")) {
				Transactions tx= new Transactions(acc);
				tx.setDeposite(amount);
				dao.saveTransaction(tx);
				List<Transactions> txList=acc.getTx();
				txList.add(tx);
				acc.setTx(txList);
				dao.UpdateAccount(acc);
				session.removeAttribute("account");
				session.setAttribute("account",acc);
				session.setAttribute("message", "Transaction Successull!! ");
				response.sendRedirect("transactions.jsp");
			}
			else {
				Transactions tx= new Transactions(acc);
				tx.setWithdraw(amount);
				Double afterBalance=tx.getBalance();
				if(afterBalance<beforeBalance) {
					dao.saveTransaction(tx);
					List<Transactions> txList=acc.getTx();
					txList.add(tx);
					acc.setTx(txList);
					dao.UpdateAccount(acc);
					session.removeAttribute("account");
					session.setAttribute("account",acc);
					session.setAttribute("message", "Transaction Successull!! ");
					response.sendRedirect("transactions.jsp");
				}
				else {
					session.setAttribute("message", "Transaction failed | enter amount below "+beforeBalance);
					response.sendRedirect("transactions.jsp");
				}
				
			}
			
		}
		else {
			session.setAttribute("loginMessage", "Error! couldn't process the Transaction, Please Login again");
			response.sendRedirect("login.jsp");
		}

		
	}

}
