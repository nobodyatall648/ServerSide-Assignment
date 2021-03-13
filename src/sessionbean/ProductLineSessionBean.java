package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.ProductlineEntity;

/**
 * Session Bean implementation class ProductLineSessionBean
 */
@Stateless
public class ProductLineSessionBean implements ProductLineSessionBeanLocal {

	@PersistenceContext(unitName="ServerSideAssignment")
	EntityManager em;
	
    @Override
	public List<ProductlineEntity> getAllProductLine() throws EJBException {
		// TODO Auto-generated method stub
    	Query query = em.createNamedQuery("ProductlineEntity.findAll");
    	
		return query.getResultList();
	}

	/**
     * Default constructor. 
     */
    public ProductLineSessionBean() {
        // TODO Auto-generated constructor stub
    }

}
