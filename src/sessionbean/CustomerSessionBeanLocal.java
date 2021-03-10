package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.CustomerEntity;
import domain.EmployeeEntity;

@Local
public interface CustomerSessionBeanLocal {
	List<CustomerEntity> getAllCustomer() throws EJBException;
	CustomerEntity getCustomerByCustNum(String custNum) throws EJBException;
	void addCustomer(CustomerEntity customer) throws EJBException;
	void updateCustomer(CustomerEntity customer) throws EJBException;
	List<CustomerEntity> getCustomerByUnassignedSR() throws EJBException;
	List<CustomerEntity> getCustomerBySR(String empNo) throws EJBException;
	Boolean assignSalesRep(String custNum, String salesRep) throws EJBException;
}
