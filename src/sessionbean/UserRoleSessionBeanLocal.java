package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.UserRoleEntity;

@Local
public interface UserRoleSessionBeanLocal {
	public List<UserRoleEntity> findRole(String role)throws EJBException;

}
