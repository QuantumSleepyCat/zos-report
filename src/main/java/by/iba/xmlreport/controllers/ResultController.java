package by.iba.xmlreport.controllers;


import by.iba.xmlreport.ftpsend.FtpSender;
import by.iba.xmlreport.model.DTO.JCLAndXMLDoc;
import by.iba.xmlreport.model.jclcreate.CreatingJCLFile;
import by.iba.xmlreport.model.statuslist.StatusBarList;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class ResultController {

    @PostMapping("/result/approve")
    public void getResultApprove(@RequestBody JCLAndXMLDoc jclAndXMLDoc)
    {
        StatusBarList.getInstance().getStatusItems().get(
                jclAndXMLDoc.getIdStat()
        ).setStyleClass("list-group-item list-group-item-success");
        StatusBarList.getInstance().getStatusItems().get(
                jclAndXMLDoc.getIdStat()
        ).setStatus("Approved");
        FtpSender ftpSender=new FtpSender();
        ftpSender.sendFileToZos(jclAndXMLDoc.getXmlDocument(),
                new CreatingJCLFile().createJclFile(jclAndXMLDoc.getJclText()));
    }

    @PostMapping("/result/reject")
    public void getResultReject(@RequestBody int id)
    {
        StatusBarList.getInstance().getStatusItems().get(id)
                .setStyleClass("list-group-item list-group-item-success");
        StatusBarList.getInstance().getStatusItems().get(id)
                .setStatus("Rejected");
    }

}
