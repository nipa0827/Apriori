package apriori;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputFileReader {

	public List<Set<String>> readFile(String path) throws IOException {
		List<Set<String>> itemsetList = new ArrayList<>();
		FileInputStream fstream = new FileInputStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			String[] res = strLine.split(" ");
			itemsetList.add(new HashSet<>(Arrays.asList(res)));
		}
		br.close();
		return itemsetList;
	}

}
