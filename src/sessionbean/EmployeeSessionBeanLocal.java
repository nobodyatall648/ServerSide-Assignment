package sessionbean;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.EmployeeEntity;

@Local
public interface EmployeeSessionBeanLocal {
	public EmployeeEntity getEmployeeByEmpNum(String empNum) throws EJBException;
	public void addEmployee(EmployeeEntity emp) throws EJBException;
	public void updateEmployee(EmployeeEntity emp) throws EJBException;
	public void deleteEmployee(String empNum) throws EJBException;
	public <List>EmployeeEntity getallEmployee() throws EJBException;
	

}
