package sessionbean;


import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.PaymentEntity;


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
	public PaymentEntity getCustomerPaymentInfo(String custNum) throws EJBException {
		// TODO Auto-generated method stub
		Query q = em.createNamedQuery("PaymentEntity.findCustomerPayment");
		q.setParameter("id", Integer.parseInt(custNum));
		return (PaymentEntity) q.getSingleResult();
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
