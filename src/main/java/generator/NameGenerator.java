package generator;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class NameGenerator {
	
	public static String generate(){
		
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		return new SimpleDateFormat("yyyymmddhhmmss").format(ts);		
	}

}
