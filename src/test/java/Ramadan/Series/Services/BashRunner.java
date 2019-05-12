package Ramadan.Series.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author ahmedyoussef 
 * 
 * Runs bash scripts from Java code
 *
 */
public class BashRunner {
	
	private String getResourceScriptPath(String scriptName) {
		return System.getProperty("user.dir") + File.separator + "resources" + File.separator + scriptName;
	}
	
	private void displayOutput(InputStream inputStream) throws IOException {
	    Reader r = new InputStreamReader(inputStream);
	    BufferedReader br = new BufferedReader(r);
	    String line;
	    while ((line = br.readLine()) != null) {
	        System.out.println(line);
	    }
	}
	
	public void runCommand(String link, String path) {
		ProcessBuilder pb = new ProcessBuilder(getResourceScriptPath("downloadAndMove.sh"), link, path);
		try {
			Process p = pb.start();
			System.out.println("downloadAndMove.sh exited successfully");
			displayOutput(p.getInputStream());
		} catch (IOException e) {
			System.out.println("Couldn't run downloadAndMove.sh, link: " + link
					+ " | path: " + path);
			e.printStackTrace();
		}
	}
}
