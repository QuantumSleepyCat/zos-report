package by.iba.xmlreport.ftpsend;

import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FtpSender {
    public boolean sendFileToZos()
    {
        FTPClient client = new FTPClient();
        FileInputStream fis = null;

        try {
            client.connect("172.20.2.116");
            client.login("user06a", "user06a");
            //System.out.print(client.getStatus());
            //
            // Create an InputStream of the file to be uploaded
            //
            String filename = "mydoc2.txt";
            // URL url=new URL("http://ftp.byfly.by/robots.txt");
            //File file =null;
            File file = new File("robot.txt");
            URL url = new URL("http://ftp.byfly.by/robots.txt");
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(file);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            fis = new FileInputStream(file);
            fos.close();
            rbc.close();

            fis = new FileInputStream(file);

            //
            // Store file to server
            //
            boolean  done= client.storeFile(filename, fis);
            System.out.println(done);
            client.logout();
            return done;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
