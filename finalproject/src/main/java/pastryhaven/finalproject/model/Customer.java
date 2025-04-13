package pastryhaven.finalproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // This handles automatic ID generation
    @Column(name = "customer_id")
    private Long id;

	@Column(name = "contact_no")
	private int contactNumber;
	
	@Column(name = "email_address", unique = true)
	private String emailAddress;

	@Column(name = "password", nullable = false)
    private String password;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(int contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
