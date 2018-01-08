package by.iba.xmlreport.services.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.iba.xmlreport.getlogs.GetLogsByFtp;
import by.iba.xmlreport.getlogs.reading.ReadLogs;

@Component
public class ListenerMQ implements MessageListener{

	@Autowired
	private GetLogsByFtp getLogs;
	
	@Autowired
	private ReadLogs readLogs;
	
	@Override
	public void onMessage(Message message) {
		
		if (message instanceof TextMessage)
        {
		try {
			String str = ((TextMessage)message).getText();
			System.out.println(str.trim());
			String str2=str.trim();
			if(str2.contains("JOB"))
			{
			String [] itemsMsg = str2.split("-");
			System.out.println(itemsMsg.length);
			itemsMsg[0]=itemsMsg[0].replace(itemsMsg[0].substring(0, 1), "");
			getLogs.execute(itemsMsg);
			readLogs.read(itemsMsg[0]);
			for(String s : itemsMsg)
			{
				System.out.println(s.trim());
			}
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
        }
	}

}
