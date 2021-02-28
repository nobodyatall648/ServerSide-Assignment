package sessionbean;

import javax.ejb.EJBException;
import javax.ejb.Stateless;

import domain.EmployeeEntity;

@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {

	@Override
	public EmployeeEntity getEmployeeByEmpNum(String empNum) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployee(EmployeeEntity emp) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEmployee(EmployeeEntity emp) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(String empNum) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <List> EmployeeEntity getallEmployee() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

}
