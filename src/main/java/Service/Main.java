package Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.BankingDao;
import Dao.BankingDaoImpl;
import Entity.Account;
import Entity.Address;
import Entity.Login;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("BankingApplication_beans.xml");
		BankingDao dao= (BankingDaoImpl) context.getBean("BankingDaoImpl");
		Login login=new Login();
		login.setPassword("12345");
		
		Account acc= new Account();
		acc.setLogin(login);
		login.setAccount(acc);
	
		acc.setUserName("Koushal");
		acc.setAddress(new Address("10-10-24", "wrangal","506002"));
		acc.setDob("14/12/1995");
		acc.setEmail("kandagatlakoushal@gmail.com");
		acc.setAccountType("Savings");
		
		dao.saveAccount(acc);
		dao.saveLogin(login);
	}

}
