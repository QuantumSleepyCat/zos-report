package by.iba.xmlreport.controllers;



import by.iba.xmlreport.ftpsend.FtpSender;
import by.iba.xmlreport.model.DTO.JCLAndXMLDoc;
import by.iba.xmlreport.model.PageInfoModel;
import by.iba.xmlreport.model.jclcreate.CreatingJCLFile;
import by.iba.xmlreport.model.sendinfo.SendInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import java.io.File;

@Controller
public class SetInfoController {

    @GetMapping(value = "/")
    public String setInfoPage(Model model)
    {
       //model.addAttribute("message","test message");
        model.addAttribute("pageInfo",new PageInfoModel());
        return "index";
    }
   /* @PostMapping(value = "/sendtoftp")
    public ModelAndView sendToFtpZos(ModelAndView model, @ModelAttribute PageInfoModel pageInfo) throws InterruptedException {
       //System.out.println(username);
        //model.getModelMap().get("username");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JCLAndXMLDoc> responseEntity=null;
        responseEntity=restTemplate.postForEntity("http://xml-creator-for-zos.eu-gb.mybluemix.net/rest/getinfo",
                pageInfo,JCLAndXMLDoc.class);
        Thread.sleep(1000);
        FtpSender ftpSender=new FtpSender();
       //System.out.println();
        ftpSender.sendFileToZos(responseEntity.getBody().getXmlDocument(),
                new CreatingJCLFile().createJclFile(responseEntity.getBody().getJclText()));
        model.setViewName("redirect:/");
        return model;
    }*/

    @PostMapping(value = "/sendtoftp")
    public ModelAndView sendToFtpZos(ModelAndView model, @ModelAttribute PageInfoModel pageInfo) throws InterruptedException {
        //System.out.println(username);
        //model.getModelMap().get("username");
        //pageInfo.setSendInfo(new SendInfo(username,pass,server,cl_email));
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JCLAndXMLDoc> responseEntity=null;
        responseEntity=restTemplate.postForEntity("http://xml-creator-for-zos.eu-gb.mybluemix.net/rest/getinfo",
                pageInfo,JCLAndXMLDoc.class);
        model.setViewName("redirect:/");
        return model;
    }

}
