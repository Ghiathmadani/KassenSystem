package resource;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceLoader {

	public static String loadText(String resourceName) {
		
		InputStream is = ResourceLoader.class.getResourceAsStream(resourceName);
		
		try ( BufferedReader in = new BufferedReader(new InputStreamReader(is)) ) {
			String line;
			
			StringBuilder sb = new StringBuilder();
			while( (line = in.readLine()) != null ) {
				sb.append(line).append("\n");
			}
			
			return sb.toString();
			
		} catch (Exception e) {
			throw new IllegalStateException(e);
		}
		
	}
	
}
