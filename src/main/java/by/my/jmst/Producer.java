package by.my.jmst;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;

@Stateless
public class Producer {
    @Inject
    @JMSConnectionFactory(value = "jms/ConnectionTopic")
    private JMSContext jmsContext;

    @Resource(lookup = "jms/Topic")
    private Topic queue;

    public void send() {
        JMSProducer producer = jmsContext.createProducer();
        producer.send(queue, "hello");
    }
}
