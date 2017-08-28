package net.scai.fitp.esb.connection;

import java.util.Map;

public interface MakeURL {

	public String makeURL(Map<String, String> map);

	String makeURL();
	
}
