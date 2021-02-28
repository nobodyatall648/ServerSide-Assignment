package sessionbean;

import javax.ejb.EJBException;
import javax.ejb.Stateless;

import domain.OfficeEntity;

@Stateless
public class OfficeSessionBean implements OfficeSessionBeanLocal {

	@Override
	public <List> OfficeEntity getAllOffice() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <List> OfficeEntity findOffice(String officeCode) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOffice(OfficeEntity office) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOffice(OfficeEntity office) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOffice(OfficeEntity office) throws EJBException {
		// TODO Auto-generated method stub
		
	}

}
