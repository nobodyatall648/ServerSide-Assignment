package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products",schema="classicmodels")
@NamedQuery(name="ProductEntity.findAll", query="SELECT p FROM ProductEntity p")
@NamedQuery(name="ProductEntity.findByProductCode", query="SELECT p FROM ProductEntity p WHERE p.productcode = :productcode")
public class ProductEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String productcode;

	private BigDecimal buyprice;

	private BigDecimal msrp;

	private String productdescription;

	private String productname;

	private String productscale;

	private String productvendor;

	private Integer quantityinstock;

	//bi-directional many-to-one association to OrderdetailEntity
	@OneToMany(mappedBy="product")
	private List<OrderdetailEntity> orderdetails;

	//bi-directional many-to-one association to ProductlineEntity
	@ManyToOne
	@JoinColumn(name="productline", insertable=false, updatable=false)
	private ProductlineEntity productlineBean;

	public ProductEntity() {
	}

	public String getProductcode() {
		return this.productcode;
	}

	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	public BigDecimal getBuyprice() {
		return this.buyprice;
	}

	public void setBuyprice(BigDecimal buyprice) {
		this.buyprice = buyprice;
	}

	public BigDecimal getMsrp() {
		return this.msrp;
	}

	public void setMsrp(BigDecimal msrp) {
		this.msrp = msrp;
	}

	public String getProductdescription() {
		return this.productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductscale() {
		return this.productscale;
	}

	public void setProductscale(String productscale) {
		this.productscale = productscale;
	}

	public String getProductvendor() {
		return this.productvendor;
	}

	public void setProductvendor(String productvendor) {
		this.productvendor = productvendor;
	}

	public Integer getQuantityinstock() {
		return this.quantityinstock;
	}

	public void setQuantityinstock(Integer quantityinstock) {
		this.quantityinstock = quantityinstock;
	}

	public List<OrderdetailEntity> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<OrderdetailEntity> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public OrderdetailEntity addOrderdetail(OrderdetailEntity orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setProduct(this);

		return orderdetail;
	}

	public OrderdetailEntity removeOrderdetail(OrderdetailEntity orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setProduct(null);

		return orderdetail;
	}

	public ProductlineEntity getProductlineBean() {
		return this.productlineBean;
	}

	public void setProductlineBean(ProductlineEntity productlineBean) {
		this.productlineBean = productlineBean;
	}

}