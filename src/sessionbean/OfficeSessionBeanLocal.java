package sessionbean;

import java.util.List;

import javax.ejb.EJBException;

import domain.OfficeEntity;

public interface OfficeSessionBeanLocal {
	public List<OfficeEntity> getAllOffice() throws EJBException;
	public OfficeEntity findOffice(int officeCode) throws EJBException;
	public void addOffice(OfficeEntity office)throws EJBException;
	public void updateOffice(OfficeEntity office)throws EJBException;
	public void deleteOffice(OfficeEntity office)throws EJBException;

}
