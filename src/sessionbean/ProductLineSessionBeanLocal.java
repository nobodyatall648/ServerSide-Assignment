package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.ProductlineEntity;

@Local
public interface ProductLineSessionBeanLocal {
	List<ProductlineEntity> getAllProductLine() throws EJBException;
	
}
