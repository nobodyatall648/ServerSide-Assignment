package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.ProductEntity;

@Local
public interface ProductSessionBeanLocal {
	List<ProductEntity> getAllProduct() throws EJBException;
	List<ProductEntity> findProductByName(String productName) throws EJBException;
	void addProduct(ProductEntity product) throws EJBException;
	void updateProduct(ProductEntity product) throws EJBException;
	ProductEntity getProductByProductCode(String productCode) throws EJBException;
	void deleteProduct(String productCode) throws EJBException;	
}
