package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the offices database table.
 * 
 */
@Entity
@Table(name="offices",schema="classicmodels")
@NamedQuery(name="OfficeEntity.findAll", query="SELECT o FROM OfficeEntity o")
@NamedQuery(name="OfficeEntity.findbynum",query="SELECT e FROM OfficeEntity e WHERE e.officecode =: officenum")

public class OfficeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer officecode;

	private String addressline1;

	private String addressline2;

	private String city;

	private String country;

	private String phone;

	private String postalcode;

	private String state;

	private String territory;

	//bi-directional many-to-one association to EmployeeEntity
	@OneToMany(mappedBy="office")
	private List<EmployeeEntity> employees;

	public OfficeEntity() {
	}

	public Integer getOfficecode() {
		return this.officecode;
	}

	public void setOfficecode(Integer officecode) {
		this.officecode = officecode;
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

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getTerritory() {
		return this.territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public List<EmployeeEntity> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<EmployeeEntity> employees) {
		this.employees = employees;
	}

	public EmployeeEntity addEmployee(EmployeeEntity employee) {
		getEmployees().add(employee);
		employee.setOffice(this);

		return employee;
	}

	public EmployeeEntity removeEmployee(EmployeeEntity employee) {
		getEmployees().remove(employee);
		employee.setOffice(null);

		return employee;
	}

}