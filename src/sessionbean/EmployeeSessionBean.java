package sessionbean;



import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.postgresql.util.PSQLException;

import domain.EmployeeEntity;
import domain.OfficeEntity;
import domain.ProductEntity;
import domain.UserEntity;
import domain.UserRoleEntity;
import domain.UserRoleEntityPK;

@Stateless
public class EmployeeSessionBean implements EmployeeSessionBeanLocal {

	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	

	@Override
	public EmployeeEntity getEmployeeByEmpNum (String empNum) throws EJBException {
		// TODO Auto-generated method stub
		
		Query emp=em.createNamedQuery("EmployeeEntity.findbynum");
		emp.setParameter("Employnum",Integer.valueOf(empNum));
		return (EmployeeEntity) emp.getSingleResult();
		
	}

	@Override
	public void addEmployee(EmployeeEntity e) throws EJBException {
		// TODO Auto-generated method stub	
		//using native query because EJB not work for foreign key insertion
		Query q = em.createNativeQuery("INSERT INTO classicmodels.employees (employeenumber, email, extension, firstname, jobtitle, lastname, reportsto, officecode) VALUES (?,?,?,?,?,?,?,?)", EmployeeEntity.class);
		q.setParameter(1, e.getEmployeenumber());
		q.setParameter(2,e.getEmail() );
		q.setParameter(3, e.getExtension());
		q.setParameter(4, e.getFirstname());
		q.setParameter(5, e.getJobtitle());
		q.setParameter(6, e.getLastname());
		q.setParameter(7, e.getReportsto());
		q.setParameter(8, e.getOffice().getOfficecode());
		q.executeUpdate();	  
		
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

	@Override
	public void updateEmployeeFromProfile(String[] s) throws EJBException {
		// TODO Auto-generated method stub
		Query q = null;
		
		q = em.createNativeQuery("UPDATE classicmodels.employees SET firstname =?, lastname =?, email =?  WHERE employeenumber = ?", EmployeeEntity.class);
		q.setParameter(1,s[1]);
		q.setParameter(2,s[2]);
		q.setParameter(3,s[3]);
		q.setParameter(4,Integer.parseInt(s[0]));
		
		q.executeUpdate();
	}


}
