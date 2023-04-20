package datastructures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV {

	public static void main(String[] args) { // throws IOException
		String fileName = "D:\\Books\\JAVA\\Codes\\PROJECTS\\accounts.csv";
		String dataRow;

		ArrayList<String[]> data = new ArrayList<String[]>();

		try {
			// Open the file
			BufferedReader br = new BufferedReader(new FileReader(fileName));

			// Read the data as long as it's not empty
			while ((dataRow = br.readLine()) != null) {
				// parse the data by commas
				String[] line = dataRow.split(",");
				// Add the data to the collection
				data.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String[] account : data) {
			System.out.print("[  ");
			for (String field : account) {
				System.out.print(field + " ");
			}
			System.out.println(" ]");
		}

	}

}
