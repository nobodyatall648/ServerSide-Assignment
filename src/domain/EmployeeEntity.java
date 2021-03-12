package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name="employees",schema="classicmodels")
@NamedQuery(name="EmployeeEntity.findAll", query="SELECT e FROM EmployeeEntity e")
@NamedQuery(name="EmployeeEntity.findbynum",query="SELECT e FROM EmployeeEntity e WHERE e.employeenumber =:Employnum")

public class EmployeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer employeenumber;

	private String email;

	private String extension;

	private String firstname;

	private String jobtitle;

	private String lastname;

	private String reportsto;
	

	//bi-directional many-to-one association to CustomerEntity
	@OneToMany(mappedBy="employee")
	private List<CustomerEntity> customers;

	//bi-directional many-to-one association to OfficeEntity
	@ManyToOne
	@JoinColumn(name="officecode", insertable=false, updatable=false)
	private OfficeEntity office;
	
	

	public EmployeeEntity() {
	}

	public Integer getEmployeenumber() {
		return this.employeenumber;
	}

	public void setEmployeenumber(Integer employeenumber) {
		this.employeenumber = employeenumber;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getReportsto() {
		return this.reportsto;
	}

	public void setReportsto(String reportsto) {
		this.reportsto = reportsto;
	}

	public List<CustomerEntity> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<CustomerEntity> customers) {
		this.customers = customers;
	}

	public CustomerEntity addCustomer(CustomerEntity customer) {
		getCustomers().add(customer);
		customer.setEmployee(this);

		return customer;
	}

	public CustomerEntity removeCustomer(CustomerEntity customer) {
		getCustomers().remove(customer);
		customer.setEmployee(null);

		return customer;
	}

	public OfficeEntity getOffice() {
		return this.office;
	}

	public void setOffice(OfficeEntity office) {
		this.office = office;
	}

}