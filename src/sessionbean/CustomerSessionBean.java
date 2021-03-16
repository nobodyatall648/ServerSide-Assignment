package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.CustomerEntity;
import domain.EmployeeEntity;
import domain.ProductEntity;

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
		Query q = em.createNativeQuery("SELECT * FROM classicmodels.customers c WHERE c.customernumber = ?", CustomerEntity.class);
		q.setParameter(1, Integer.parseInt(custNum));
		
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

	@Override
	public void updateCustomerFromProfile(String[] s) throws EJBException {
		// TODO Auto-generated method stub
		Query q = null;
		
		q = em.createNativeQuery("UPDATE classicmodels.customers SET customername =?, contactlastname =?, contactfirstname =?, phone=?, addressline1=?, addressline2=?, city=?, state=?, postalcode=?, country=?, creditlimit=? WHERE customernumber = ?", CustomerEntity.class);
		q.setParameter(1,s[1]);
		q.setParameter(2,s[2]);
		q.setParameter(3,s[3]);
		q.setParameter(4,s[4]);
		q.setParameter(5,s[6]);
		q.setParameter(6,s[7]);
		q.setParameter(7,s[9]);
		q.setParameter(8,s[10]);
		q.setParameter(9,s[8]);
		q.setParameter(10,s[11]);
		q.setParameter(11,Double.parseDouble(s[5]));
		q.setParameter(12,Integer.parseInt(s[0]));
		
		q.executeUpdate();
	
	}
    
	
    
}
