package by.iba.xmlreport.controllers;



import by.iba.xmlreport.ftpsend.FtpSender;
import by.iba.xmlreport.model.DTO.JCLAndXMLDoc;
import by.iba.xmlreport.model.PageInfoModel;
import by.iba.xmlreport.model.jclcreate.CreatingJCLFile;
import by.iba.xmlreport.model.sendinfo.SendInfo;
import by.iba.xmlreport.model.statuslist.StatusBarList;
import by.iba.xmlreport.model.statuslist.item.StatusItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView sendToFtpZos(ModelAndView model,
                                     @ModelAttribute PageInfoModel pageInfo,
                                     HttpServletRequest httpServletRequest) throws InterruptedException {
        pageInfo.setPort(httpServletRequest.getLocalPort());
        RestTemplate restTemplate = new RestTemplate();
        StatusBarList.getInstance().iterCounter();
        pageInfo.setId(StatusBarList.getInstance().getCounter());
        restTemplate.postForLocation("http://localhost:9081/rest/getinfo",
                pageInfo);

        StatusBarList.getInstance().setItem(new StatusItem(pageInfo.getApplicationName(),
                "Awaiting","list-group-item list-group-item-info"),pageInfo.getId());
        model.setViewName("redirect:/");
        return model;
    }

}
