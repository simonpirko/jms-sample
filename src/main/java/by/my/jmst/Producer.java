package by.my.jmst;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
public class Producer {
    @Inject
    @JMSConnectionFactory(value = "jms/ConnectionTopic")
    private JMSContext jmsContext;

    @Resource(lookup = "jms/Topic")
    private Destination topic;

    public void send(String message) {
        JMSProducer producer = jmsContext.createProducer();
        producer.send(topic, message);
    }
}
