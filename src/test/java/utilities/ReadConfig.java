package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;

	public ReadConfig() {
		File src=new File("./ConfigurationFiles/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	public  String getApplicationURL() {
		String url =pro.getProperty("baseURL");
		return url;
		
	}
	public  String getUSERNAME() {
		String uname =pro.getProperty("username");
		return uname;
		
	}
	public  String getPWD() {
		String pwd =pro.getProperty("password");
		return pwd;
		
	}
	public  String getChromePath() {
		String chromepath =pro.getProperty("chromepath");
		return chromepath;
		
	}
	public String getEdgePath() {
		String edgepath =pro.getProperty("edgepath");
		return edgepath;
	}
}
