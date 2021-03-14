package sessionbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.UserEntity;

@Stateless
public class UserSessionBean implements UserSessionBeanLocal {
	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;

	public UserSessionBean() {
		super();
	}

	@Override
	public Boolean accountMatching(String user, String pass) throws EJBException {
		// TODO Auto-generated method stub
		Query q = em.createNativeQuery("SELECT * FROM classicmodels.users u WHERE u.username = ? AND u.password = ?",
				UserEntity.class);
		q.setParameter(1, user);
		q.setParameter(2, pass);

//		try {
		List<UserEntity> userList = new ArrayList<UserEntity>();
		userList = q.getResultList();
		// credential match means 1 result will be return
		if (userList.size() == 1) {
			return true;
		}else {
			return false;
		}
//		} catch (Exception e) {
//			return false;
//		}
	}

	@Override
	public UserEntity findUser(String user) throws EJBException {
		// TODO Auto-generated method stub
		try {
			Query u = em.createNativeQuery("SELECT * FROM classicmodels.users e WHERE e.username=:name",
					UserEntity.class);
			u.setParameter("name", user);
			return (UserEntity) u.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
