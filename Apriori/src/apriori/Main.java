package apriori;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		AprioriFrequentItemsetGenerator<String> generator = new AprioriFrequentItemsetGenerator<>();

		List<Set<String>> itemsetList = new ArrayList<>();
		itemsetList = new InputFileReader().readFile("res//input.txt");
		FrequentItemsetData<String> data = generator.generate(itemsetList, 0.2);
		int i = 1;
		System.out.println("Support calculation:");
		for (Set<String> itemset : data.getFrequentItemsetList()) {

			System.out.printf("%2d: %9s, support: %1.1f\n", i++, itemset, data.getSupport(itemset));
		}

		System.out.println("\nConfidence calculation:");
		getConfidence(data);
	}

	/*
	 * confidence A=>B p(B|A) = S_C(AUB)/S_C(A)
	 * 
	 * 
	 */
	public static void getConfidence(FrequentItemsetData<String> data) {
		Set<String> itemset1 = new HashSet<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first condition:\n");
		String str1 = scanner.nextLine();
		String[] array1 = str1.split(" ");
		
		for(int i=0;i<array1.length;i++) {
			itemset1.add(array1[i]);
		}
		Set<String> itemset2 = new HashSet<String>();
		System.out.println("Enter second condition:\n");
		String str2 = scanner.nextLine();
		String[] array2 = str2.split(" ");
		
		for(int i=0;i<array2.length;i++) {
			itemset1.add(array2[i]);
			itemset2.add(array2[i]);
		}

		double supportCountOfAB = data.getSupport(itemset1);
		double supportCountOfA = data.getSupport(itemset2);
		System.out.println("Confidence of (" + itemset1 + "=>" + itemset2 + ") = " + supportCountOfAB+"/"+supportCountOfA);
	}

}