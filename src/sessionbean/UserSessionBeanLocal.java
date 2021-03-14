package sessionbean;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.UserEntity;

@Local
public interface UserSessionBeanLocal {
	public UserEntity findUser(String user)throws EJBException;
	public Boolean accountMatching(String user, String pass) throws EJBException;
}
