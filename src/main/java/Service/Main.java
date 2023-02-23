package Service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Dao.BankingDao;
import Dao.BankingDaoImpl;
import Entity.Account;
import Entity.Address;
import Entity.Login;
import Entity.Transactions;

public class Main {

	public static void main(String[] args) {
	
	 	ApplicationContext context = new ClassPathXmlApplicationContext("BankingApplication_beans.xml");
		BankingDao dao = (BankingDaoImpl) context.getBean("BankingDaoImpl");
		Login login = new Login();
		login.setPassword("12345");

		Account acc = new Account();
		acc.setLogin(login);
		login.setAccount(acc);

		acc.setUserName("Koushal");
		acc.setAddress(new Address("10-10-24", "wrangal", "506002"));
		acc.setDob("14/12/1995");
		acc.setEmail("kandagatlakoushal@gmail.com");
		acc.setAccountType("Savings");

		Transactions tx = new Transactions();
		tx.setAccount(acc);
		tx.setDeposite(200d);

		List<Transactions> txList = new ArrayList();
		txList.add(tx);
		acc.setTx(txList);

		dao.saveAccount(acc);
		dao.saveTransaction(tx);
		dao.saveLogin(login);
	 
		System.out.println(tx);

	}

}
