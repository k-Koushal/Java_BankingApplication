package Entity;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "port_gen", sequenceName = "port_gen",  initialValue = 100000)
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  , generator = "port_gen")
	private Integer accountId;

	private String userName;
	private String dob;
	@Embedded
	private Address address;
	private String email;
	private String accountType;
	private Double balance=0d;
	
	@OneToOne(mappedBy = "account")
	private Login login;
	
	@OneToMany(mappedBy = "txAccount")
	private List<Transactions> tx;

//-------------C O N S T R U C T O R S---------
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public Account(String userName, String dob, Address address, String email, String accountType, Double balance,
		Login login, List<Transactions> tx) {
	super();
	this.userName = userName;
	this.dob = dob;
	this.address = address;
	this.email = email;
	this.accountType = accountType;
	this.balance = balance;
	this.login = login;
	this.tx = tx;
}




	// -------G E T T E R S & S E T T E R S----------
	public Integer getAccountId() {
		return accountId;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
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
