package by.iba.xmlreport.services.status;


import by.iba.xmlreport.model.HostInfo;
import by.iba.xmlreport.model.status.StatusList;
import by.iba.xmlreport.model.status.StatusValue;
import by.iba.xmlreport.model.statuslist.StatusBarList;
import by.iba.xmlreport.model.statuslist.item.StatusItem;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobStatusValuesImpl implements JobStatusValues {
    @Override
    public void updateStatus() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StatusList> statusListResponseEntity=null;
        statusListResponseEntity=restTemplate.getForEntity(HostInfo.getHost()+
                "status",StatusList.class);
        for(StatusValue statusValue:
                statusListResponseEntity.getBody()
                        .getStatusValues()
                        .values())
        {
            try {
                StatusItem statusItem = StatusBarList.getInstance().getStatusItems().get(
                        statusValue.getIdInfo()
                );
                if(statusValue.getStatus().equals("Approved") &&
                		!statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                        !statusItem.getStatus().equals("Failed"))
                {
                    statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-success")
                            .setStatus("Approved")
                            .setComment(statusValue.getComment());
                }
            else if(statusValue.getStatus().equals("Rejected") &&
            		!statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                    !statusItem.getStatus().equals("Failed"))
            {
                statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-danger")
                        .setStatus("Rejected")
                        .setComment(statusValue.getComment());

            }
            }
            catch (Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }

    @Override
    public void updateStatusById(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<StatusValue> statusListResponseEntity=null;
        statusListResponseEntity=restTemplate.getForEntity(HostInfo.getHost()+
                "status/"+id,StatusValue.class);
         StatusValue statusValue = statusListResponseEntity.getBody();
         try {
             StatusItem statusItem = StatusBarList.getInstance().getStatusItems().get(
                     statusValue.getIdInfo()
             );
             if (statusValue.getStatus().equals("Approved") &&
                     !statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                     !statusItem.getStatus().equals("Failed")) {
                 statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-success")
                         .setStatus("Approved")
                         .setComment(statusValue.getComment())
                         .setIdInList(statusValue.getIdInList());
                 System.out.println(statusValue.getComment());
             } else if (statusValue.getStatus().equals("Rejected") &&
            		 !statusItem.getStatus().equals("Finished") && !statusItem.getStatus().equals("In process") &&
                     !statusItem.getStatus().equals("Failed")) {
                 statusItem.setStyleClass("list-group-item list-group-item-action list-group-item-danger")
                         .setStatus("Rejected")
                         .setComment(statusValue.getComment());
             }
         }
         catch (Exception ex)
         {
             System.err.println(ex.getMessage());
         }
    }
}
