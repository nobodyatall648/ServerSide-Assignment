package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.OrderdetailEntity;

/**
 * Session Bean implementation class OrderDetailSessionBean
 */
@Stateless
public class OrderDetailSessionBean implements OrderDetailSessionBeanLocal {
	@PersistenceContext(unitName="ServerSideAssignment")
	EntityManager em;
    /**
     * Default constructor. 
     */
    public OrderDetailSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<OrderdetailEntity> getOrderDetalByOrderNumber(String orderNum) throws EJBException {
		// TODO Auto-generated method stub
		Query q = null;
		
		q = em.createNativeQuery("SELECT * FROM classicmodels.orderdetails o WHERE o.ordernumber = ?", OrderdetailEntity.class);
		q.setParameter(1, Integer.parseInt(orderNum));
		
		return q.getResultList();
	}

	@Override
	public List<OrderdetailEntity> getOrderDetailByProductCode(String productCode) throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderdetailEntity> getAllOrderDetail() throws EJBException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrderDetail(OrderdetailEntity orderDetail) throws EJBException {
		// TODO Auto-generated method stub
		em.persist(orderDetail);
	}

	@Override
	public void updateOrderDetail(OrderdetailEntity orderDetail) throws EJBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetail(String orderNum, String productCode) throws EJBException {
		// TODO Auto-generated method stub
		
	}

}
