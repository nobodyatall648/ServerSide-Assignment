package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.ProductEntity;

@Local
public interface ProductSessionBeanLocal {
	public List<ProductEntity> getAllProduct() throws EJBException;
	public List<ProductEntity> findProductByName(String productName) throws EJBException;
	public void addProduct(String[]s) throws EJBException;
	public void updateProduct(String[]s) throws EJBException;
	ProductEntity getProductByProductCode(String productCode) throws EJBException;
	public void deleteProduct(String productName) throws EJBException;	
	public int getQuantityByProductCode(String productCode) throws EJBException;
	public void setQuantityByProductCode(String productCode, Integer newQuantity) throws EJBException;


}
