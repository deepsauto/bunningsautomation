package TestBase;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Base {
	public static Properties property;

	public static void loadConfigproperty() {

		try {
			File f = new File(".\\src\\main\\java\\Configuaration\\config.properties");
			FileReader fr = new FileReader(f);
			property = new Properties();
			property.load(fr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static String getconfig(String key)
	{
		loadConfigproperty();
		String value = property.getProperty(key);
		return value;
	}
	
}

