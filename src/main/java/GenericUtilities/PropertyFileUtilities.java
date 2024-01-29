package GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtilities 
{
	/**
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromPropertyFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String val = p.getProperty(key);
		return val;
	}
}
