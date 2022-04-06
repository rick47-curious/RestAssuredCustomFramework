package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public class XMLReaderUtil {

	public static String getRequestBody(String filename) {
		File file = new File(System.getProperty("user.dir")+"//src//test/resources//XMLRequestPayloads//"+filename+".xml");
		if (file.exists()) {
			try {
				FileInputStream fis = new FileInputStream(file);
				
				return IOUtils.toString(fis, "UTF-8");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Filepath does not exist!");
		}
		return null;
	}
	public static String replaceWithTestdata(String request,String dataA,String dataB) {
		
		String requestBody = request.replace("{{dataA}}",dataA.toString());
		requestBody = requestBody.replace("{{dataB}}",dataB.toString());
		
		
		return requestBody;
	}
	
}
