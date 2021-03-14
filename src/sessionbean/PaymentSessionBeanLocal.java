package sessionbean;

import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;

import domain.PaymentEntity;
import domain.PaymentEntityPK;


@Local
public interface PaymentSessionBeanLocal {
	public List<PaymentEntity> getCustomerPaymentInfo(String custNum) throws EJBException;
	public void addCustomerPayment(PaymentEntity payment) throws EJBException;
	public List<PaymentEntity> getAllPayment() throws EJBException;
}
