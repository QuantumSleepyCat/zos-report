package by.iba.xmlreport.ftpsend;

import org.apache.commons.net.ftp.FTPClient;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FtpSender {
    public boolean sendFileToZos(Document document)
    {
        FTPClient client = new FTPClient();
        FileInputStream fis = null;

        try {
            client.connect("172.20.2.116");
            client.login("user06a", "user06a");
            String filename = "report";
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer();
            File file = new File("report");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
            fis = new FileInputStream(file);

            boolean  done= client.storeFile(filename, fis);
            System.out.println(done);
            client.logout();
            return done;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
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
