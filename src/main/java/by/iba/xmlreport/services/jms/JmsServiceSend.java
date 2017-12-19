package by.iba.xmlreport.services.jms;

import by.iba.xmlreport.model.DTO.JCLAndXMLDoc;

public interface JmsServiceSend {
	void send(JCLAndXMLDoc jclAndXMLDoc);
}
