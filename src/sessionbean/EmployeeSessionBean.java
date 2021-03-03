package sessionbean;



import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.EmployeeEntity;

@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {

	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	
	@Override
	public EmployeeEntity getEmployeeByEmpNum(int empNum) throws EJBException {
		// TODO Auto-generated method stub
		Query emp=em.createNamedQuery("EmployeeEntity.getEmployeenumber");
		emp.setParameter("Employee number",String.valueOf(empNum));
		return(EmployeeEntity)emp.getSingleResult();
		
	}

	@Override
	public void addEmployee(EmployeeEntity emp) throws EJBException {
		// TODO Auto-generated method stub
		EmployeeEntity e=new EmployeeEntity();
		e.setFirstname(emp.getFirstname());
		e.setLastname(emp.getLastname());
		e.setEmail(emp.getEmail());
		e.setOffice(emp.getOffice());
		e.setJobtitle(emp.getJobtitle());
		em.merge(e);
		
	}

	@Override
	public void updateEmployee(EmployeeEntity emp) throws EJBException {
		// TODO Auto-generated method stub
		EmployeeEntity e=em.find(EmployeeEntity.class, emp.getEmployeenumber());
		e.setFirstname(emp.getFirstname());
		e.setLastname(emp.getLastname());
		e.setEmail(emp.getEmail());
		e.setOffice(emp.getOffice());
		e.setJobtitle(emp.getJobtitle());
	}
	
@Override
	public void deleteEmployee(int empNum) throws EJBException {
		// TODO Auto-generated method stub
		EmployeeEntity e=getEmployeeByEmpNum(empNum);
		em.remove(e);
	}

	@Override
	public List <EmployeeEntity> getallEmployee() throws EJBException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EmployeeEntity.findAll").getResultList();
	}

}
