package Entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer transactionId;

	private Double deposite;
	private Double withdraw;
	private Date date;

	@ManyToOne
	private Account txAccount;


	// -------CONSTRUCTORS---
	public Transactions() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transactions(Double deposite, Double withdraw, Account account) {
		super();
		this.deposite = deposite;
		this.withdraw = withdraw;
		this.txAccount = account;
	}
	// ------GENNETS & SETTERS---

	public Integer getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}

	public Double getDeposite() {
		return deposite;
	}

	public void setDeposite(Double deposite) {
		MakeDeposit(deposite);
		this.deposite = deposite;
	}

	public Double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Double withdraw) {
		MakeWithdrawal(withdraw);
		this.withdraw = withdraw;
	}

	public Account getAccount() {
		return txAccount;
	}

	public void setAccount(Account account) {
		this.txAccount = account;
	}

	@Override
	public String toString() {
		return "Transactions : \ntransactionId=" + transactionId +", \nDate=" + date + ", \ndeposite=" + deposite + ", \nwithdraw="
				+ withdraw + ", \naccount=" + txAccount.getAccountId();
	}

	// --------TO STRING-------

	// methods;

	String MakeDeposit(Double amount) {
		Double balance = txAccount.getBalance();
		txAccount.setBalance(balance += amount);
		return "Deposit of amount " + amount + " Successfull | Current Balance=" + txAccount.getBalance();
	}

	String MakeWithdrawal(Double amount) {
		if (txAccount.getBalance() > amount) {
			Double balance = txAccount.getBalance();
			txAccount.setBalance(balance -= amount);
			return "Withdrawal of amount " + amount + " Successfull | Current Balance=" + txAccount.getBalance();
		} else {
			return "Insuffience Account balance |  Current Balance=" + txAccount.getBalance();
		}
	}

}
