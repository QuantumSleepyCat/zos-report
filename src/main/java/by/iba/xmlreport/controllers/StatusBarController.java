package by.iba.xmlreport.controllers;


import by.iba.xmlreport.model.statuslist.StatusBarList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/status")
public class StatusBarController {


    @GetMapping
    public String getStatus(Model model)
    {
        model.addAttribute("statusList", StatusBarList.getInstance().getStatusItems().values());
        return "statusbar";
    }
}
