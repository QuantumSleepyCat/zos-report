package by.iba.xmlreport.controllers;


import by.iba.xmlreport.model.HostInfo;
import by.iba.xmlreport.model.status.StatusList;
import by.iba.xmlreport.model.statuslist.StatusBarList;
import by.iba.xmlreport.services.status.JobStatusValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/status")
public class StatusBarController {


    @Autowired
    private JobStatusValues jobStatusValues;

    @GetMapping
    public String getStatus(Model model)
    {
        jobStatusValues.updateStatus();
        model.addAttribute("statusList", StatusBarList.getInstance().getStatusItems().values());
        return "statusbar";
    }

    @GetMapping("/{id}")
    public String getStatusJob(@PathVariable int id, Model model)
    {
        jobStatusValues.updateStatusById(id);
        model.addAttribute("job",StatusBarList.getInstance().getStatusItems().get(id));
        return "jobstatus";
    }
}
