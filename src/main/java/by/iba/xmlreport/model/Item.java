package by.iba.xmlreport.model;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private List<DataSet> dataSets = new ArrayList<>();

    public void setDataSet(DataSet dataSet)
    {
        dataSets.add(dataSet);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(List<DataSet> dataSets) {
        this.dataSets = dataSets;
    }
}
