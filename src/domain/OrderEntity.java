package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders",schema="classicmodels")
@NamedQuery(name="OrderEntity.findAll", query="SELECT o FROM OrderEntity o")

public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer ordernumber;

	private String comments;
	
	private Integer customernumber;

	private String orderdate;

	private String requireddate;

	private String shippeddate;

	private String status;

	//bi-directional many-to-one association to OrderdetailEntity
	@OneToMany(mappedBy="order")
	private List<OrderdetailEntity> orderdetails;

	public OrderEntity() {
	}

	public Integer getOrdernumber() {
		return this.ordernumber;
	}

	public void setOrdernumber(Integer ordernumber) {
		this.ordernumber = ordernumber;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getCustomernumber() {
		return this.customernumber;
	}

	public void setCustomernumber(Integer customernumber) {
		this.customernumber = customernumber;
	}

	public String getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getRequireddate() {
		return this.requireddate;
	}

	public void setRequireddate(String requireddate) {
		this.requireddate = requireddate;
	}

	public String getShippeddate() {
		return this.shippeddate;
	}

	public void setShippeddate(String shippeddate) {
		this.shippeddate = shippeddate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderdetailEntity> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<OrderdetailEntity> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public OrderdetailEntity addOrderdetail(OrderdetailEntity orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setOrder(this);

		return orderdetail;
	}

	public OrderdetailEntity removeOrderdetail(OrderdetailEntity orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setOrder(null);

		return orderdetail;
	}

}