package domain;

public class Cart {
	private String productCode;
	private int customerNumber;
	private String requiredDate;
	private int qty;
	private double priceEst;

	public Cart() {

	}

	public Cart(String productCode, int customerNumber, String requiredDate, int qty, double priceEst) {
		super();
		this.productCode = productCode;
		this.customerNumber = customerNumber;
		this.requiredDate = requiredDate;
		this.qty = qty;
		this.priceEst = priceEst;
	}
		
	public double getPriceEst() {
		return priceEst;
	}

	public void setPriceEst(double priceEst) {
		this.priceEst = priceEst;
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

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
