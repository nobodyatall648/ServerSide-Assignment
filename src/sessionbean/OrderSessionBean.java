package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import domain.OrderEntity;

/**
 * Session Bean implementation class OrderSessionBean
 */
@Stateless
public class OrderSessionBean implements OrderSessionBeanLocal {
	@PersistenceContext(unitName="ServerSideAssignment")
	EntityManager em;
    @Override
	public OrderEntity getOrderByOrderNumber(String custNum) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrderEntity> getOrderByCustNum(String custNum) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void addOrder(OrderEntity order) throws EJBException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateOrder(OrderEntity order) throws EJBException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteOrder(int orderNum) throws EJBException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<OrderEntity> getAllOrder() throws EJBException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("OrderEntity.findAll").getResultList();
	}
	/**
     * Default constructor. 
     */
    public OrderSessionBean() {
        // TODO Auto-generated constructor stub
    }

}
