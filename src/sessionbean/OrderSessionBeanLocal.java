package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.OrderEntity;

@Local
public interface OrderSessionBeanLocal {
	public OrderEntity getOrderByOrderNumber(String custNum) throws EJBException;
	public List<OrderEntity> getOrderByCustNum(String custNum) throws EJBException;
	public void addOrder(OrderEntity order) throws EJBException;
	public void updateOrder(OrderEntity order) throws EJBException;
	public void deleteOrder(int orderNum) throws EJBException;
	public List<OrderEntity> getAllOrder() throws EJBException;
}
