package utilities;

import java.util.Date;

public class commonUtils 
{
	public static final int IMPLICITY_WAIT=10;
	public static final int PAGE_LOAD_TIMEOUT=20;
	public static final int EXPLICITLY_WAIT=20;
	

	public static String getGmailWithTimestamp()
	{
		Date date=new Date();
		
		return date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
}
