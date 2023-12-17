package com.test.qa;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingAndRenamingFile {

	public static void CreatingNewFile() throws IOException {
		String directoryPath = "D:\\file\\";
		String baseFileName = "Dheerendra";
		int numberOfFiles = 20;

		for (int i = 1; i <= numberOfFiles; i++) {
			String fileName = baseFileName + i + ".docx";
			String filePath = directoryPath + fileName;
			FileWriter fileWriter = new FileWriter(filePath);
			fileWriter.close();
			System.out.println("File created: " + fileName);

		}
	}

	public static void RenamingExistingFile() throws IOException {
		// Specify the directory path
		String directoryPath = "D:\\file\\";

		String baseFileName = "Dheerendra";

		int numberOfFiles = 20;

		for (int i = 0; i <= numberOfFiles; i++) {
			String oldFileName = directoryPath + baseFileName + i + ".docx";
			String newFileName = directoryPath + "Vikas" + i + ".properties";

			File oldFile = new File(oldFileName);
			File newFile = new File(newFileName);

			if (oldFile.exists()) {
				boolean success = oldFile.renameTo(newFile);

				if (success) {
					System.out.println("File renamed: " + oldFileName + " to " + newFileName);
				} else {
					System.out.println("Failed to rename file: " + oldFileName);
				}
			} else {
				System.out.println("File does not exist: " + oldFileName);
			}
		}
	}
}
