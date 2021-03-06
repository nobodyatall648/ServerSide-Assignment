package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.OfficeEntity;

@Local
public interface OfficeSessionBeanLocal {
	public List<OfficeEntity> getAllOffice() throws EJBException;
	public OfficeEntity findOffice(int officeCode) throws EJBException;
	public void addOffice(String[] o)throws EJBException;
	public void updateOffice(String[] o)throws EJBException;
	public void deleteOffice(String[] o)throws EJBException;
}
