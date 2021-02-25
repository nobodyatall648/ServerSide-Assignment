package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the payments database table.
 * 
 */
@Entity
@Table(name="payments",schema="classicmodels")
@NamedQuery(name="PaymentEntity.findAll", query="SELECT p FROM PaymentEntity p")
public class PaymentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PaymentEntityPK id;

	private BigDecimal amount;

	private String paymentdate;

	//bi-directional many-to-one association to CustomerEntity
	@ManyToOne
	@JoinColumn(name="customernumber")
	private CustomerEntity customer;

	public PaymentEntity() {
	}

	public PaymentEntityPK getId() {
		return this.id;
	}

	public void setId(PaymentEntityPK id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPaymentdate() {
		return this.paymentdate;
	}

	public void setPaymentdate(String paymentdate) {
		this.paymentdate = paymentdate;
	}

	public CustomerEntity getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

}