package by.iba.xmlreport.model;

import java.util.ArrayList;
import java.util.List;

public class PageInfoModel {
    private String applicationName;
    private String prodect_CR_ID;
    private String requester;
    private String transferDate;
    private String region;
    private List<Item> items= new ArrayList<>();

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public void setItem(Item item)
    {
        items.add(item);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getProdect_CR_ID() {
        return prodect_CR_ID;
    }

    public void setProdect_CR_ID(String prodect_CR_ID) {
        this.prodect_CR_ID = prodect_CR_ID;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
