package sessionbean;

import javax.ejb.EJBException;

import domain.UserEntity;

public interface UserEntitySessionBeanLocal {
	public UserEntity findUser(String user)throws EJBException;
}
