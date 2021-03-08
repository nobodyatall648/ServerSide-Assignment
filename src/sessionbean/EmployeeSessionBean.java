package sessionbean;



import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import domain.EmployeeEntity;

@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {

	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	
	@Override
	public EmployeeEntity getEmployeeByEmpNum(String empNum,HttpServletRequest req) throws EJBException {
		// TODO Auto-generated method stub
		try {
		Query emp=em.createNamedQuery("EmployeeEntity.findbynum");
		emp.setParameter("Employnum",Integer.valueOf(empNum));
		return (EmployeeEntity) emp.getSingleResult();
		
		
		
		}catch(NoResultException e) {
			System.out.println("No data found");
			return null;
		}
		
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
	public void deleteEmployee(String empNum) throws EJBException {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public List <EmployeeEntity> getallEmployee() throws EJBException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EmployeeEntity.findAll").getResultList();
	}

}
