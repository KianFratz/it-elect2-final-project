package pastryhaven.finalproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // This handles automatic ID generation
    @Column(name = "customer_id")
    private Long customer_id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "contact_no")
	private String contactNumber;
	
	@Column(name = "email_address", unique = true, nullable = false)
	private String emailAddress;

	@Column(name = "password", nullable = false)
    private String password;

	public Customer() {
		// Initialize default values if needed
	}

	public Customer(CustomerDto dto) {
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.contactNumber = dto.getContactNumber();
		this.emailAddress = dto.getEmailAddress();
		this.password = dto.getPassword();

	}


	public Long getId() {
		return customer_id;
	}

	public void setId(long id) {
		this.customer_id = customer_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
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
