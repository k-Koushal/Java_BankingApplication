package Entity;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen",  initialValue = 100000)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  , generator = "port_gen")
	private Integer accountId;

	private String userName;
	private String dob;
	private String address;
	private String email;
	private String accountType;
	private Double balance=0d;
	private String password;
	
	@OneToMany(mappedBy = "txAccount")
	private List<Transactions> tx;

//-------------C O N S T R U C T O R S---------
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account(String userName, String dob, String address, String email,String password, String accountType) {
	super();
	this.userName = userName;
	this.dob = dob;
	this.address = address;
	this.email = email;
	this.accountType = accountType;
	this.password = password;
}






	// -------G E T T E R S & S E T T E R S----------
	
	public Integer getAccountId() {
		return accountId;
	}

	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}




	
//---------TO STRING----------

	public  Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public List<Transactions> getTx() {
		return tx;
	}




	public void setTx(List<Transactions> tx) {
		this.tx = tx;
	}




	@Override
	public String toString() {
		return "Account :\naccountId=" + accountId + ", \nuserName=" + userName + ", \ndob=" + dob + ", \naddress=" + address
				+ ", \nemail=" + email + ", \naccountType=" + accountType + "\nBalance="+balance+", \nNumber of Transactions ="+tx.size();
	}
	
}
