package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers",schema="classicmodels")
@NamedQuery(name="CustomerEntity.findAll", query="SELECT c FROM CustomerEntity c")
@NamedQuery(name="CustomerEntity.findSRByEmpNo", query="SELECT c FROM CustomerEntity c WHERE c.salesrepemployeenumber = :empno")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer customernumber;

	private String addressline1;

	private String addressline2;

	private String city;

	private String contactfirstname;

	private String contactlastname;

	private String country;

	private BigDecimal creditlimit;

	private String customername;

	private String phone;

	private String postalcode;

	private String state;

	//bi-directional many-to-one association to EmployeeEntity
	@ManyToOne
	@JoinColumn(name="salesrepemployeenumber", insertable=false, updatable=false)
	private EmployeeEntity employee;

	//bi-directional many-to-one association to PaymentEntity
	@OneToMany(mappedBy="customer")
	private List<PaymentEntity> payments;

	public CustomerEntity() {
	}

	public Integer getCustomernumber() {
		return this.customernumber;
	}

	public void setCustomernumber(Integer customernumber) {
		this.customernumber = customernumber;
	}

	public String getAddressline1() {
		return this.addressline1;
	}

	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}

	public String getAddressline2() {
		return this.addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactfirstname() {
		return this.contactfirstname;
	}

	public void setContactfirstname(String contactfirstname) {
		this.contactfirstname = contactfirstname;
	}

	public String getContactlastname() {
		return this.contactlastname;
	}

	public void setContactlastname(String contactlastname) {
		this.contactlastname = contactlastname;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigDecimal getCreditlimit() {
		return this.creditlimit;
	}

	public void setCreditlimit(BigDecimal creditlimit) {
		this.creditlimit = creditlimit;
	}

	public String getCustomername() {
		return this.customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public EmployeeEntity getEmployee() {
		return this.employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public List<PaymentEntity> getPayments() {
		return this.payments;
	}

	public void setPayments(List<PaymentEntity> payments) {
		this.payments = payments;
	}

	public PaymentEntity addPayment(PaymentEntity payment) {
		getPayments().add(payment);
		payment.setCustomer(this);

		return payment;
	}

	public PaymentEntity removePayment(PaymentEntity payment) {
		getPayments().remove(payment);
		payment.setCustomer(null);

		return payment;
	}

}