package sessionbean;

import java.util.Date;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.OrderEntity;

/**
 * Session Bean implementation class OrderSessionBean
 */
@Stateless
public class OrderSessionBean implements OrderSessionBeanLocal {
	@PersistenceContext(unitName="ServerSideAssignment")
	EntityManager em;
	
	/**
     * Default constructor. 
     */
    public OrderSessionBean() {
        // TODO Auto-generated constructor stub
    }
	
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
		em.persist(order);
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

	@Override
	public int newOrderNumber() throws EJBException {
		// TODO Auto-generated method stub
		
		Query q = em.createNamedQuery("OrderEntity.getLastOrderNumber");
		int lastNum = (int) q.setMaxResults(1).getSingleResult();
		int newNum = lastNum + 1;
		
		return newNum;
	}
		
}
