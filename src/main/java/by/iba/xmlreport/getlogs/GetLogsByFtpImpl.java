package by.iba.xmlreport.getlogs;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Service;

@Service 
public class GetLogsByFtpImpl implements GetLogsByFtp{

	@Override
	public void execute(String [] infos) {
		 FTPClient client = new FTPClient();
	     try {
			client.connect("172.20.2.116");
			client.login("user06a", "user06a");
			
			OutputStream outStr =  null;
			boolean statusCreDir=new File("logs/"+infos[0]).mkdirs();
			for(int i=1;i<infos.length;i++)
			{
				//infos[i].replace("USER06A.", "");
				String dir="logs/"+infos[0]+"/"+infos[i];
				outStr = new BufferedOutputStream(new FileOutputStream(dir));
				boolean status = client.retrieveFile(infos[i], outStr);
				System.out.println(status);
			}
			outStr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
