package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.OrderdetailEntity;

@Local
public interface OrderDetailSessionBeanLocal {
	List<OrderdetailEntity> getOrderDetalByOrderNumber(String orderNum) throws EJBException;
	List<OrderdetailEntity> getOrderDetailByProductCode(String productCode) throws EJBException;
	List<OrderdetailEntity> getAllOrderDetail() throws EJBException;
	void addOrderDetail(OrderdetailEntity orderDetail) throws EJBException;
	void updateOrderDetail(OrderdetailEntity orderDetail) throws EJBException;
	void deleteOrderDetail(String orderNum, String productCode) throws EJBException;
}
