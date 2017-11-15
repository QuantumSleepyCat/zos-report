package by.iba.xmlreport.model.statuslist.item;

public class StatusItem {
    private String appName;
    private String status;
    private String styleClass;

    public StatusItem(String appName, String status, String styleClass) {
        this.appName = appName;
        this.status = status;
        this.styleClass = styleClass;
    }

    public StatusItem() {
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStyleClass() {
        return styleClass;
    }

    public void setStyleClass(String styleClass) {
        this.styleClass = styleClass;
    }

    @Override
    public int hashCode() {
        return appName.hashCode()+status.hashCode()+styleClass.hashCode();
    }
}
