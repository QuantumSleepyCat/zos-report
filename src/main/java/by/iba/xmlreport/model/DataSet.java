package by.iba.xmlreport.model;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    private String itemValue;
    private String itemRemark;
    private List<String> members=new ArrayList<>();

    public void setMember(String member)
    {
        members.add(member);
    }

    public String getItemValue() {
        return itemValue;
    }

    public void setItemValue(String itemValue) {
        this.itemValue = itemValue;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
