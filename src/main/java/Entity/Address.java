package Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String hno;
	private String city;
	private String pin;
	
	public Address(String hno, String city, String pin) {
		super();
		this.hno = hno;
		this.city = city;
		this.pin = pin;
	}
	

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address : hno=" + hno + " | city=" + city + "|  pin=" + pin ;
	}
	
	
}
