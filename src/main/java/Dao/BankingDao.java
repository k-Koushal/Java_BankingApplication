package Dao;

import java.util.List;

import Entity.Account;

import Entity.Transactions;

public interface BankingDao {
	Integer saveAccount(Account account);
	Integer UpdateAccount(Account account);
	Account fetchAccount(Integer accId);
	Account fetchAccountWithIDandPassword(Integer accId,String password);
	Integer saveTransactionList(List<Transactions> txList);
	Integer saveTransaction(Transactions tx);
}
