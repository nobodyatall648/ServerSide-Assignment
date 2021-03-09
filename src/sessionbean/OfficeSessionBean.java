package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.EmployeeEntity;
import domain.OfficeEntity;

@Stateless
public class OfficeSessionBean implements OfficeSessionBeanLocal {

	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	@Override
	public List<OfficeEntity> getAllOffice() throws EJBException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("OfficeEntity.findAll").getResultList();
	}
	

	@Override
	public OfficeEntity findOffice(int officeCode) throws EJBException {
		// TODO Auto-generated method stub
		try {
			Query off=em.createNamedQuery("OfficeEntity.findbynum");
			off.setParameter("officenum",officeCode);
			return (OfficeEntity) off.getSingleResult();
			
			
			
			}catch(NoResultException e) {
				System.out.println("No data found");
				return null;
			}
			
		
	}

	@Override
	public void addOffice(OfficeEntity office) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOffice(OfficeEntity office) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOffice(OfficeEntity office) throws EJBException {
		// TODO Auto-generated method stub
		
	}

}
