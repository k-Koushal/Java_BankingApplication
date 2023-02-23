package Dao;

import java.util.List;

import Entity.Account;
import Entity.Login;
import Entity.Transactions;

public interface BankingDao {
	Integer saveLogin(Login login);
	Integer saveAccount(Account account);
	Integer UpdateAccount(Account account);
	Account fetchAccount(Integer accId);
	Integer saveTransactionList(List<Transactions> txList);
	Integer saveTransaction(Transactions tx);
}
