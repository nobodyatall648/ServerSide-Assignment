package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.CustomerEntity;

/**
 * Session Bean implementation class CustomerSessionBean
 */
@Stateless
public class CustomerSessionBean implements CustomerSessionBeanLocal {
	
	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CustomerSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<CustomerEntity> getAllCustomer() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerEntity getCustomerByCustNum(String custNum) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCustomer(CustomerEntity customer) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(CustomerEntity customer) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerEntity> getCustomerByUnassignedSR() throws EJBException {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("SELECT * FROM classicmodels.customers c WHERE c.salesrepemployeenumber is null");
				
		return q.getResultList();
	}

	@Override
	public List<CustomerEntity> getCustomerBySR(String empNo) throws EJBException {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("CustomerEntity.findSRByEmpNo");
		q.setParameter("empno", Integer.parseInt(empNo));
		
		return q.getResultList();
	}
    
	
    
}
