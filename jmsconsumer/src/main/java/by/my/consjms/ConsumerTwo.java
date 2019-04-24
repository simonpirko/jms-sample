package by.my.consjms;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/Topic")
public class ConsumerTwo implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage message1 = (TextMessage) message;
        try {
            System.out.println(this.getClass().getName() + " - " + message1.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
