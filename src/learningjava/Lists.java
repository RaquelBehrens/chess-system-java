package learningjava;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists {
	public static void lists() throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//APRENDENDO LISTAS EM JAVA		
		int n = sc.nextInt();
		double[] vect = new double[n];
		
		for(int i = 0; i < n; i++) {
			vect[i] = sc.nextDouble();
		}
		
		double sum = 0.0;
		for (int i = 0; i < n; i++) {
			sum += vect[i];
		}
		double avg = sum / n;
		
		System.out.printf("AVERAGE HEIGHT: %.2f%n", avg);
		
		String[] vetor = new String[] {"Maria", "Bob", "Alex"};
		for (int i = 0; i < vect.length; i++) {
			System.out.println(vect[i]);
		}
		
		for (String obj: vetor) {
			System.out.println(obj);
		}
		
		sc.close();
		
		List<String> list = new ArrayList<>();
		list.add("Maria");
		
		String name = list.stream().filter(x -> x.charAt(0) == 'A').findFirst().orElse(null);
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
	}
}
