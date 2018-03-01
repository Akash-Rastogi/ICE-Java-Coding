package Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CSUIP {
	public static void main(String[] args) {
		try {
			// Open the file for input
			FileInputStream fstream = new FileInputStream("/Users/akashrastogi/Documents/workspace/ICE/src/Problems/CSUIP.txt");

			// Here second argument takes the buffer size as parameter.
			// Currently using default.
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			// Two Strings one for current line and one for previous.
			String currLine = br.readLine();
			String prevLine = currLine;

			// Creating new file to write the output
			File fout = new File("/Users/akashrastogi/Documents/workspace/ICE/src/Problems/output.txt");
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			// Read File Line By Line
			while (currLine != null) {
				
				// Write in new file
				if(!isDouble(currLine) && currLine.length()==8) {
					if(!prevLine.equals(currLine)) { // for first time only
						bw.write(prevLine);
						bw.newLine();
					}
					bw.write(currLine);
					bw.newLine();
				}
				
				prevLine = currLine;
				currLine = br.readLine();
			}
			bw.write(prevLine);
			
			// Closing the input and output stream
			br.close();
			bw.close();
		}

		catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

	// Method to check if provided String is a Valid Double.
	private static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
