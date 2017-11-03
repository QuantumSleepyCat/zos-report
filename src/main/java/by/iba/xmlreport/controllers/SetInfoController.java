package by.iba.xmlreport.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SetInfoController {

    @GetMapping(value = "/")
    public String setInfoPage(Model model)
    {
       model.addAttribute("message","test message");
        return "index";
    }

}
