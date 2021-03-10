package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.CustomerEntity;
import domain.EmployeeEntity;

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
		Query q = em.createNamedQuery("CustomerEntity.findCustomerByCustomerNum");
		q.setParameter("custnum", Integer.parseInt(custNum));
		
		return (CustomerEntity) q.getSingleResult();
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
		Query q = em.createNativeQuery("SELECT * FROM classicmodels.customers c WHERE c.salesrepemployeenumber is null", CustomerEntity.class);
		
		return q.getResultList();
	}

	@Override
	public List<CustomerEntity> getCustomerBySR(String empNo) throws EJBException {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("SELECT * FROM classicmodels.customers c WHERE c.salesrepemployeenumber = ?", CustomerEntity.class);
		q.setParameter(1, Integer.parseInt(empNo));
		
		List<CustomerEntity> cm = q.getResultList();

		return q.getResultList();
	}

	@Override
	public Boolean assignSalesRep(String custNum, String salesRep) throws EJBException {
		// TODO Auto-generated method stub
		CustomerEntity cust = getCustomerByCustNum(custNum);
		
		try {
		Query q = em.createNativeQuery("UPDATE classicmodels.customers SET salesrepemployeenumber = :salesrep WHERE customernumber = :custnum", CustomerEntity.class);
		q.setParameter("salesrep", Integer.parseInt(salesRep));
		q.setParameter("custnum", Integer.parseInt(custNum));
		q.executeUpdate();	
		}catch(Exception e) {
			return false;
		}
		
		return true;
	}
    
	
    
}
