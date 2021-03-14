package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.UserRoleEntity;

@Stateless
public class UserRoleSessionBean implements UserRoleSessionBeanLocal {
	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;

	@Override
	public UserRoleEntity findRole(String role) throws EJBException {
		// TODO Auto-generated method stub
	
			Query u=em.createNativeQuery("SELECT * FROM classicmodels.user_roles e WHERE e.username=:name",UserRoleEntity.class);
		u.setParameter("name", role);
		UserRoleEntity result = (UserRoleEntity) u.getSingleResult();
        return result;
	}

}
