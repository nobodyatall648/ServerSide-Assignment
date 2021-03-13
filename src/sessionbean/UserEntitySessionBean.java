package sessionbean;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.UserEntity;

@Stateless
public class UserEntitySessionBean implements UserEntitySessionBeanLocal {
	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	

	@Override
	public UserEntity findUser(String user) throws EJBException {
		// TODO Auto-generated method stub
		try {
			Query u=em.createNativeQuery("SELECT * FROM classicmodels.users e WHERE e.username=:name",UserEntity.class);
			u.setParameter("name", user);
	        return (UserEntity)u.getSingleResult();
			}catch(NoResultException e) {
				return null;
			}
	}

}
