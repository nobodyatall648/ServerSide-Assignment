package domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the productlines database table.
 * 
 */
@Entity
@Table(name="productlines",schema="classicmodels")
@NamedQuery(name="ProductlineEntity.findAll", query="SELECT p FROM ProductlineEntity p")
public class ProductlineEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String productline;

	private String htmldescription;

	private String image;

	private String textdescription;

	//bi-directional many-to-one association to ProductEntity
	@OneToMany(mappedBy="productlineBean")
	private List<ProductEntity> products;

	public ProductlineEntity() {
	}

	public String getProductline() {
		return this.productline;
	}

	public void setProductline(String productline) {
		this.productline = productline;
	}

	public String getHtmldescription() {
		return this.htmldescription;
	}

	public void setHtmldescription(String htmldescription) {
		this.htmldescription = htmldescription;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTextdescription() {
		return this.textdescription;
	}

	public void setTextdescription(String textdescription) {
		this.textdescription = textdescription;
	}

	public List<ProductEntity> getProducts() {
		return this.products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public ProductEntity addProduct(ProductEntity product) {
		getProducts().add(product);
		product.setProductlineBean(this);

		return product;
	}

	public ProductEntity removeProduct(ProductEntity product) {
		getProducts().remove(product);
		product.setProductlineBean(null);

		return product;
	}

}