package by.iba.xmlreport.controllers;

import by.iba.xmlreport.model.DTO.JCLAndXMLDoc;
import by.iba.xmlreport.model.HostInfo;
import by.iba.xmlreport.model.statuslist.StatusBarList;
import by.iba.xmlreport.model.statuslist.item.StatusItem;
import by.iba.xmlreport.services.jms.JmsServiceSend;
import by.iba.xmlreport.services.promote.SendInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/send")
public class SendController {
    @Autowired
    private SendInfo sendInfo;
    @Autowired
	private JmsServiceSend jmsServiceSend;
    @GetMapping("/{id}")
    public String sendInfo(@PathVariable int id)
    {
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<JCLAndXMLDoc> responseEntity= restTemplate.getForEntity(
                HostInfo.getHost()+"info/"+id,JCLAndXMLDoc.class);
        //sendInfo.send(responseEntity.getBody());
        StatusBarList.getInstance().getStatusItems().get(responseEntity.getBody().getIdStat())
        .setStyleClass("list-group-item list-group-item-action list-group-item-warning")
        .setStatus("In process");
        jmsServiceSend.send(responseEntity.getBody());
       
        return "redirect:/";
    }

}
