package domain;

public class Cart {
	private String productCode;
	private int customerNumber;
	private String requiredDate;
	private String comments;
	private int qty;
	
	public Cart() {
		
	}
	
	public Cart(String productCode, int customerNumber, String requiredDate, String comments, int qty) {
		super();
		this.productCode = productCode;
		this.customerNumber = customerNumber;
		this.requiredDate = requiredDate;
		this.comments = comments;
		this.qty = qty;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}	
	
}
