package sessionbean;

import java.util.List;

import javax.ejb.EJBException;

import domain.UserRoleEntity;

public interface UserRoleSessionBeanLocal {
	public List<UserRoleEntity> findRole(String role)throws EJBException;

}
