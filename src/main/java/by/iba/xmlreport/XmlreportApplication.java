package by.iba.xmlreport;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class XmlreportApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(XmlreportApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(XmlreportApplication.class, args);
		/*FTPClient client = new FTPClient();
		FileInputStream fis = null;
		FileInputStream fisForJCL = null;


		try {
			client.connect("172.20.2.116");
			client.login("user06a", "user06a");
			//String [] str=client.doCommandAsStrings("ls","*");
			String [] str=client.listNames();
			for(String s:str)
			{
				System.out.println(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}
}
