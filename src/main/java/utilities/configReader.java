package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configReader 
{

	public static Properties initializeProperties()
	{
		Properties prop=new Properties();
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		
		try {
			FileInputStream fi = new FileInputStream(file);
			prop.load(fi);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
}
