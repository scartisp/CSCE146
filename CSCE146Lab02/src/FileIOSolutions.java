
//Simion Cartis
import java.util.*;
import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardCopyOption;

public class FileIOSolutions {
	public static final String DELIM = "\t";

	public static void pastTense(String File1, String File1Copy) {
		try {
			// FileOutputStream presFile = new FileOutputStream(File1);
			PrintWriter TenseChange = new PrintWriter(new FileOutputStream(new File(File1Copy)));

			Scanner fileScannerTense = new Scanner(new File(File1));
			String present = "is";
			String past = "was";
			String presentCap= "Is";
			String pastCap = "Was";
			//System.out.println(fileScannerTense.nextLine());
			while (fileScannerTense.hasNextLine()) {
				String next = fileScannerTense.nextLine();
				//System.out.println(next);
				// next = past;
				String isToWas = next.replaceAll("\\b" + present + "\\b", past); //both are necessary 
				String isToWasCap = isToWas.replaceAll("\\b"+presentCap+"\\b", pastCap);// to preserve 
				if(isToWasCap == null) //original capitalizations
					break;
				TenseChange.println(isToWasCap); //this populates the ItWas file
				System.out.println(isToWasCap); //this actually prints everything out
			}
			fileScannerTense.close();
			TenseChange.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static double totalTubeVolume(String File2) {
		double volume = 0;
		try {
			Scanner FileScannerTube = new Scanner(new File(File2));
			String fileLine; // must DEFINE but NOT INITIALIZE until for loop
			String[] splitLines;
			Double[] radious = new Double[25]; // must be Double not double because double[] can't check
			Double[] height = new Double[25]; // if an index is null, only if the entire array is

			for (int i = 0; i < 25; i++) {
				fileLine = FileScannerTube.nextLine();
				splitLines = fileLine.split(DELIM);
				if (splitLines.length == 3) {
					radious[i] = Double.parseDouble(splitLines[1]);
					height[i] = Double.parseDouble(splitLines[2]);
					//System.out.println(radious[i]);
				}
			}
			FileScannerTube.close();
			int isValid = 0;
			for (int i = 0; i < 25; i++) {
				if (radious[i] != null)
					isValid++; // this is to prevent null elements from being multiplied together.
			}// there are null elements in the array, but its fine (not for space though) as they are being ignored
			double pi = Math.PI;
			for (int i = 0; i < isValid; i++) {
				volume += radious[i] * radious[i] * pi * height[i];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return volume;
	}
}
