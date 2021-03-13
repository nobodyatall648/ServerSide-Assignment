package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.OfficeEntity;

/**
 * Session Bean implementation class OfficeSessionBean
 */
@Stateless
public class OfficeSessionBean implements OfficeSessionBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
    public OfficeSessionBean() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public List<OfficeEntity> getAllOffice() throws EJBException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("OfficeEntity.findAll").getResultList();
	}
	@Override
	public OfficeEntity findOffice(int officeCode) throws EJBException {
		// TODO Auto-generated method stub
		
			Query off=em.createNamedQuery("OfficeEntity.findbynum");
			off.setParameter("officenum",officeCode);
			return (OfficeEntity) off.getSingleResult();
			
			
			
			
	}
	@Override
	public void addOffice(String[] o) throws EJBException {
		// TODO Auto-generated method stub
		OfficeEntity f=new OfficeEntity();
		f.setOfficecode(Integer.parseInt(o[0]));
		f.setCity(o[1]);
		f.setPhone(o[2]);
		f.setAddressline1(o[3]);
		f.setAddressline2(o[4]);
		f.setState(o[5]);
		f.setCountry(o[6]);
		f.setPostalcode(o[7]);
		f.setTerritory(o[8]);
		em.persist(f);
		
	}
	@Override
	public void updateOffice(String[] o) throws EJBException {
		// TODO Auto-generated method stub
		OfficeEntity f=findOffice(Integer.parseInt(o[0]));
		f.setCity(o[1]);
		f.setPhone(o[2]);
		f.setAddressline1(o[3]);
		f.setAddressline2(o[4]);
		f.setState(o[5]);
		f.setCountry(o[6]);
		f.setPostalcode(o[7]);
		f.setTerritory(o[8]);
		em.merge(f);
		
		
	}
	@Override
	public void deleteOffice(String[] o) throws EJBException {
		// TODO Auto-generated method stub
		OfficeEntity f=findOffice(Integer.parseInt(o[0]));
		em.remove(f);
	}
    
    
}
