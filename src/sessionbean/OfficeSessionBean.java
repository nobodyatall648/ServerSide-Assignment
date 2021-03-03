package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	public List<OfficeEntity> findOffice(int officeCode) throws EJBException {
		// TODO Auto-generated method stub
		OfficeEntity e=em.find(OfficeEntity.class, officeCode);
		return null;
		
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
