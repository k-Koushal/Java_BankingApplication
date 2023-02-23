package Entity;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen",  initialValue = 4700)
public class Transactions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = "port_gen")
	private Integer transactionId;

	private Double deposite;
	private Double withdraw;
	private String date=getDate();

	
	@ManyToOne
	private Account txAccount;

	private Double balance;

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
	}

	public Account getAccount() {
		return txAccount;
	}

	public void setAccount(Account account) {
		this.txAccount = account;
	}

	@Override
	public String toString() {
		return "Transaction: \ntransactionId=" + transactionId +", \nDate=" + date + ", \ndeposite=" + deposite + ", \nwithdraw="
				+ withdraw + ", \naccount=" + txAccount.getAccountId() +",& \nBalance="+txAccount.getBalance();
	}

	// --------TO STRING-------

	// methods;

	private String MakeDeposit(Double amount) {
		Double balance = txAccount.getBalance();
		txAccount.setBalance(balance += amount);
		this.balance=balance+amount;
		return "Deposit of amount " + amount + " Successfull | Current Balance=" + txAccount.getBalance();
	}

	private String MakeWithdrawal(Double amount) {
		if (txAccount.getBalance() > amount) {
			Double balance = txAccount.getBalance();
			txAccount.setBalance(balance - amount);
			this.withdraw=amount;
			this.balance=balance-amount;
			return "Withdrawal of amount " + amount + " Successfull | Current Balance=" + txAccount.getBalance();
		} else {
			this.withdraw=null;
			this.balance=txAccount.getBalance();
			System.err.println("Insuffience Account balance |  Current Balance=" + txAccount.getBalance());
			return "Insuffience Account balance |  Current Balance=" + txAccount.getBalance();
		}
	}
	
	private String getDate() {
		Locale locale = new Locale("en", "IN");
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
		String date = dateFormat.format(new Date());
		
		return date;
	
	}

}
