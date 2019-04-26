package by.my.consjms;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.SessionContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/Topic")
public class ConsumerTwo implements MessageListener {

    @EJB
    private SessionContext sessionContext;

    @Override
    public void onMessage(Message message) {
        TextMessage message1 = (TextMessage) message;
        try {
            System.out.println(this.getClass().getName() + " - " + message1.getText());
        } catch (JMSException e) {
            sessionContext.setRollbackOnly();
        }
    }
}
