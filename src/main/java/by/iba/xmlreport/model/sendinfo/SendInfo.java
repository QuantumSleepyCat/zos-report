package by.iba.xmlreport.model.sendinfo;

public class SendInfo {
    private String username;
    private String password;
    private String server;
    private String cl_email;

    public SendInfo() {
    }

    public SendInfo(String username, String password, String server, String cl_email) {
        this.username = username;
        this.password = password;
        this.server = server;
        this.cl_email = cl_email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getCl_email() {
        return cl_email;
    }

    public void setCl_email(String cl_email) {
        this.cl_email = cl_email;
    }

    @Override
    public int hashCode() {
        return (int) ((username.length()+
                        password.length()+
                        server.length()+
                        cl_email.length())*(Math.random()*(Math.random()*(Math.random()*9993)+
                        (Math.random()*9342)))*(username.length()*
                password.length()*
                server.length()*
                cl_email.length()));
    }
}
