package Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Merge {
	public static void main(String[] args) {
		try {
			// Open the files for input
			FileInputStream fstream1 = new FileInputStream("/Users/akashrastogi/Documents/workspace/ICE/src/Problems/Sample1.txt");
			FileInputStream fstream2 = new FileInputStream("/Users/akashrastogi/Documents/workspace/ICE/src/Problems/Sample2.txt");

			// Here second argument takes the buffer size as parameter.
			// Currently using default.
			BufferedReader br1 = new BufferedReader(new InputStreamReader(fstream1));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(fstream2));

			// Two Strings one for current line and one for previous.
			String lineFile1 = br1.readLine();
			String lineFile2 = br2.readLine();

			// Creating new file to write the output
			File fout = new File("/Users/akashrastogi/Documents/workspace/ICE/src/Problems/merged.txt");
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			// Read both files Line By Line
			while (lineFile1 != null && lineFile2 != null) {
				
				// Write in new file
				// Note: This condition is for ascending order
				if(lineFile1.compareTo(lineFile2) < 0) {
					bw.write(lineFile1);
					bw.newLine();
					lineFile1 = br1.readLine();
				} else {
					bw.write(lineFile2);
					bw.newLine();
					lineFile2 = br2.readLine();
				}
			}
			
			// If file1 has remaining values and file2 = null 
			while(lineFile1 != null) {
				bw.write(lineFile1);
				bw.newLine();
				lineFile1 = br1.readLine();
			}
			
			// If file2 has remaining values and file1 = null
			while(lineFile2 != null) {
				bw.write(lineFile2);
				bw.newLine();
				lineFile2 = br2.readLine();
			}
			
			// Closing the input and output stream
			br1.close();
			br2.close();
			bw.close();
		}

		catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
}
