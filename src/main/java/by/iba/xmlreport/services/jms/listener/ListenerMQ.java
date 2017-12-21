package by.iba.xmlreport.services.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component
public class ListenerMQ implements MessageListener{

	@Override
	public void onMessage(Message message) {
		
		if (message instanceof TextMessage)
        {
		try {
			String str = ((TextMessage)message).getText();
			System.out.println(str);
		} catch (JMSException e) {
			e.printStackTrace();
		}
        }
	}

}
