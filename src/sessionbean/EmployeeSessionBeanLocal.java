package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

import domain.EmployeeEntity;

@Local
public interface EmployeeSessionBeanLocal {
	public EmployeeEntity getEmployeeByEmpNum(String empNum,HttpServletRequest req) throws EJBException;
	public void addEmployee(String[] s) throws EJBException;
	public void updateEmployee(String[] s) throws EJBException;
	public void deleteEmployee(String empNum) throws EJBException;
	public List<EmployeeEntity> getallEmployee() throws EJBException;
	public EmployeeEntity findEmployee(String num)throws EJBException;
	

}
