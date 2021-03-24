package sessionbean;

import java.util.List;
import java.math.BigDecimal;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.OrderEntity;
import domain.OrderdetailEntity;
import domain.PaymentEntity;
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
		Query query = em.createNamedQuery("ProductEntity.findAll");
		
		return query.getResultList();
	}
	

	@Override
	public List<ProductEntity> findProductByName(String productName) throws EJBException {
		// TODO Auto-generated method stub
		Query q = null;
		
		q = em.createNativeQuery("select * from classicmodels.products p where lower(p.productname) like ?", ProductEntity.class);
		q.setParameter(1, "%" + productName + "%");
		
		return q.getResultList();
	}

	@Override
	public void addProduct(String[] s) throws EJBException {
		// TODO Auto-generated method stub
		
		ProductEntity p = new ProductEntity();
		
		p.setProductcode(s[0]);
		p.setProductname(s[1]);
		p.setProductscale(s[2]);
		p.setProductvendor(s[3]);
		p.setProductdescription(s[4]);
		p.setQuantityinstock(Integer.parseInt(s[5])); 
		
		em.persist(p);
	}

	@Override
	public void updateProduct(String[] s) throws EJBException {
		// TODO Auto-generated method stub
		
	    ProductEntity p1 = (ProductEntity) findProductByName(s[0]);
		p1.setProductname(s[1]);
		p1.setProductscale(s[2]);
		p1.setProductvendor(s[3]);
		p1.setProductdescription(s[4]);
		p1.setQuantityinstock(Integer.parseInt(s[5])); 
		
	}

	@Override
	public ProductEntity getProductByProductCode(String productCode) throws EJBException {
		// TODO Auto-generated method stub		
		Query q = em.createNamedQuery("ProductEntity.findByProductCode");
		q.setParameter("productcode", productCode);
		
		return (ProductEntity) q.getSingleResult();
	}

	@Override
	public void deleteProduct(String productName) throws EJBException {
		// TODO Auto-generated method stub
		ProductEntity p2 = (ProductEntity) findProductByName(productName);
		em.remove(p2);
	}

	@Override
	public int getQuantityByProductCode(String productCode) throws EJBException {
		// TODO Auto-generated method stub
//		Query q = null;
//		
//		q = em.createNativeQuery("SELECT quantityinstock FROM classicmodels.products p WHERE p.productcode = ?", ProductEntity.class);
//		q.setParameter(1, productCode);
		Query q = em.createNamedQuery("ProductEntity.findQuantityByProductCode");
		q.setParameter("productcode", productCode);
		
		return (Integer) q.getSingleResult();
	}

	@Override
	public void setQuantityByProductCode(String productCode, Integer newQuantity) throws EJBException {
		// TODO Auto-generated method stub
		Query q = null;
	
		q = em.createNativeQuery("UPDATE classicmodels.products SET quantityinstock =?  WHERE productcode = ?", ProductEntity.class);
		q.setParameter(1,newQuantity);
		q.setParameter(2,productCode);
		
		q.executeUpdate();

	}

}
