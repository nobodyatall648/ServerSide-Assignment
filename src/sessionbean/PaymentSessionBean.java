package sessionbean;


import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.OrderdetailEntity;
import domain.PaymentEntity;
import domain.PaymentEntityPK;


/**
 * Session Bean implementation class PaymentSessionBean
 */
@Stateless
public class PaymentSessionBean implements PaymentSessionBeanLocal {
	@PersistenceContext(unitName = "ServerSideAssignment")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public PaymentSessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<PaymentEntity> getCustomerPaymentInfo(String custNum) throws EJBException {
		// TODO Auto-generated method stub
		Query q = null;
		
		q = em.createNativeQuery("SELECT * FROM classicmodels.payments p WHERE p.customernumber = ?", PaymentEntity.class);
		q.setParameter(1, Integer.parseInt(custNum));

		return q.getResultList();
	}
	
	@Override
	public void addCustomerPayment(PaymentEntity payment) throws EJBException {
		// TODO Auto-generated method stub	
		em.persist(payment);
	}

	@Override
	public List<PaymentEntity> getAllPayment() throws EJBException {
		// TODO Auto-generated method stub
		return em.createNamedQuery("PaymentEntity.findAll").getResultList();
	}

}
