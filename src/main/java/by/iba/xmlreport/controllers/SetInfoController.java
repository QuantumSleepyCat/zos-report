package by.iba.xmlreport.controllers;



import by.iba.xmlreport.ftpsend.FtpSender;
import by.iba.xmlreport.model.PageInfoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @PostMapping(value = "/sendtoftp")
    public ModelAndView sendToFtpZos(ModelAndView model, @ModelAttribute PageInfoModel pageInfo) throws InterruptedException {
        System.out.println(pageInfo.getAction());
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Document> responseEntity=null;
        responseEntity=restTemplate.postForEntity("http://localhost:9081/rest/getinfo",
                pageInfo,Document.class);
        Thread.sleep(1000);
        FtpSender ftpSender=new FtpSender();
       //System.out.println();
        ftpSender.sendFileToZos(responseEntity.getBody());
        model.setViewName("redirect:/");
        return model;
    }

}
