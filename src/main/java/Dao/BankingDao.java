package Dao;

import Entity.Account;
import Entity.Login;

public interface BankingDao {
	Integer saveLogin(Login login);
	Integer saveAccount(Account account);
	Integer UpdateAccount(Account account);
	Account fetchAccount(Integer accId);
}
