package Dao;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import Entity.Account;
import Entity.Login;



public class BankingDaoImpl implements BankingDao {

	private HibernateTemplate ht;

	public HibernateTemplate setHt(HibernateTemplate ht) {
		this.ht = ht;
		return ht;
	}

	@Transactional
	public Integer saveLogin(Login login) {
		try {
			Integer n = (Integer) this.ht.save(login);
			return n;

		} catch (Exception e) {
			System.out.println("Error Couldn't perform the Operation| " + e);
			return null;
		}

	}
	
	@Transactional
	public Integer saveAccount(Account account) {
		try {
			Integer n = (Integer) this.ht.save(account);
			return n;
		} catch (Exception e) {
			System.out.println("Error Couldn't perform the Operation| " + e);
			return null;
		}

	}
	
	@Transactional
	public Integer UpdateAccount(Account account) {
		try {
			this.ht.update(account);
			return 1;
		} catch (Exception e) {
			System.out.println("Error Couldn't perform the Operation| " + e);
			return null;
		}
	}
	
	@Transactional
	public Account fetchAccount(Integer accId) {
		try {
			Account acc=(Account)this.ht.get(Account.class, accId);
			return acc;
		} catch (Exception e) {
			System.out.println("Error Couldn't perform the Operation| " + e);
			return null;
		}
	}

}
