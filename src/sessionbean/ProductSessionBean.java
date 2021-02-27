package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.ProductEntity;

/**
 * Session Bean implementation class ProductSessionBean
 */
@Stateless
public class ProductSessionBean implements ProductSessionBeanLocal {
	@PersistenceContext(unitName="ServerSideAssignment")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ProductSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<ProductEntity> getAllProduct() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductEntity> findProductByName(String productName) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProduct(ProductEntity product) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(ProductEntity product) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductEntity getProductByProductCode(String productCode) throws EJBException {
		// TODO Auto-generated method stub		
		Query q = em.createNamedQuery("ProductEntity.findByProductCode");
		q.setParameter("productcode", productCode);
		
		return (ProductEntity) q.getSingleResult();
	}

	@Override
	public void deleteProduct(String productCode) throws EJBException {
		// TODO Auto-generated method stub
		
	}

}
