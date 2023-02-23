package Entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer accountId;

	private String userName;
	private String dob;
	@Embedded
	private Address address;
	private String email;
	private String accountType;

	@OneToOne(mappedBy = "account")
	private Login login;

//-------------C O N S T R U C T O R S---------
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String userName, String dob, Address address, String email, String accountType, Login login) {
		super();
		this.userName = userName;
		this.dob = dob;
		this.address = address;
		this.email = email;
		this.accountType = accountType;
		this.login = login;
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

	@Override
	public String toString() {
		return "Account [\naccountId=" + accountId + ", \nuserName=" + userName + ", \ndob=" + dob + ", \naddress=" + address
				+ ", \nemail=" + email + ", \naccountType=" + accountType + "\n]";
	}
	
}
