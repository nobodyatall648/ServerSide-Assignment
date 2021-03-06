package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the orderdetails database table.
 * 
 */
@Entity
@Table(name="orderdetails",schema="classicmodels")
@NamedQuery(name="OrderdetailEntity.findAll", query="SELECT o FROM OrderdetailEntity o")

public class OrderdetailEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderdetailEntityPK id;

	private Integer orderlinenumber;

	private BigDecimal priceeach;

	private Integer quantityordered;

	//bi-directional many-to-one association to OrderEntity
	@ManyToOne
	@JoinColumn(name="ordernumber", insertable=false, updatable=false)
	private OrderEntity order;

	//bi-directional many-to-one association to ProductEntity
	@ManyToOne
	@JoinColumn(name="productcode", insertable=false, updatable=false)
	private ProductEntity product;

	public OrderdetailEntity() {
	}

	public OrderdetailEntityPK getId() {
		return this.id;
	}

	public void setId(OrderdetailEntityPK id) {
		this.id = id;
	}

	public Integer getOrderlinenumber() {
		return this.orderlinenumber;
	}

	public void setOrderlinenumber(Integer orderlinenumber) {
		this.orderlinenumber = orderlinenumber;
	}

	public BigDecimal getPriceeach() {
		return this.priceeach;
	}

	public void setPriceeach(BigDecimal priceeach) {
		this.priceeach = priceeach;
	}

	public Integer getQuantityordered() {
		return this.quantityordered;
	}

	public void setQuantityordered(Integer quantityordered) {
		this.quantityordered = quantityordered;
	}

	public OrderEntity getOrder() {
		return this.order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public ProductEntity getProduct() {
		return this.product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

}