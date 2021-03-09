package sessionbean;



import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import domain.EmployeeEntity;
import domain.OfficeEntity;

@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {

	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	
	@EJB
	private OfficeSessionBean offbean;
	
	
	
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
	public void addEmployee(String[] s) throws EJBException {
		// TODO Auto-generated method stub
		EmployeeEntity e=new EmployeeEntity();
	    OfficeEntity o=new OfficeEntity();
	    
	    o=offbean.findOffice(Integer.parseInt(s[5]));
	
		e.setEmployeenumber(Integer.parseInt(s[0]));
		e.setFirstname(s[1]);
		e.setLastname(s[2]);
		e.setEmail(s[3]);
		e.setJobtitle(s[4]);
		e.setExtension("x100");
		e.setReportsto(s[6]);
		e.setOffice(o);
		

		em.persist(o);
		em.persist(e);
		
		
		
	}

	@Override
	public void updateEmployee(String[] s) throws EJBException {
		// TODO Auto-generated method stub
	
		EmployeeEntity e=findEmployee(s[0]);
		OfficeEntity o=new OfficeEntity();
		o.setOfficecode(Integer.parseInt(s[5]));
		e.setFirstname(s[1]);
		e.setLastname(s[2]);
		e.setEmail(s[3]);
		e.setJobtitle(s[4]);
		e.setOffice(o);
		e.setReportsto(s[6]);
		em.merge(e);
	}
	
	
@Override
	public void deleteEmployee(String empNum) throws EJBException {
		// TODO Auto-generated method stub
		EmployeeEntity e=findEmployee(empNum);
		em.remove(e);
		
	}

	@Override
	public List <EmployeeEntity> getallEmployee() throws EJBException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("EmployeeEntity.findAll").getResultList();
	}

	@Override
	public EmployeeEntity findEmployee(String num) throws EJBException {
		// TODO Auto-generated method stub
		Query m=em.createNamedQuery("EmployeeEntity.findbynum");
		m.setParameter("Employnum", Integer.parseInt(num));
		return (EmployeeEntity)m.getSingleResult();
	}

}
