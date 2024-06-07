package learningjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {
	public static void main(String[] args) {
		String path = "./in.txt";
		File file = new File(path);
		Scanner sc = null;

		// Lesson 214
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

		// Lesson 215
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Lesson 216
		try (BufferedReader br1 = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		
		// Lesson 217
		String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
		String writePath = "./out.txt";
		
		// true in FileWriter means that we do not want to recreate the file
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(writePath, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Lesson 218
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc1.nextLine();
		
		File path1 = new File(strPath);
		
		File[] folders = path1.listFiles(File::isDirectory);
		System.out.println("FOLDERS:");
		for (File folder: folders) {
			System.out.println(folder);
		}
		
		File[] files = path1.listFiles(File::isFile);
		System.out.println("FILES:");
		for (File file1: files) {
			System.out.println(file1);
		}
		
		boolean success = new File(strPath + "/subdir").mkdir();
		System.out.println("Directory created successfully!:");
		
		//Lesson 219
		System.out.println("getName: " + path1.getName());
		System.out.println("getParent: " + path1.getParent());
		System.out.println("getPath: " + path1.getPath());

		sc1.close();
	}
}
