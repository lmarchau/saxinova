package fr.lmarchau.saxinova.utils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Util class used to working on command line arguments
 */
public class CommandLineParser {

	private CommandLineParser() {}

	/**
	 * Extract File object from an array of Objects
	 * Check file exists and is a file
	 *
	 * @param args array of objects, might be command line arguments
	 *
	 * @return File
	 *
	 * @throws FileNotFoundException expected file exists and is a file
	 * @throws IllegalArgumentException expected one and ony one object into parameter
	 */
	public static File extractFileFromArgs(Object[] args) throws FileNotFoundException {
		if (args.length != 1) {
			throw new IllegalArgumentException("Expected one and only one argument");
		}
		File file = new File((String) args[0]);
		if (!file.exists()) {
			throw new FileNotFoundException("File " + file.getAbsolutePath() + " is not found");
		} else if (!file.isFile()) {
			throw new FileNotFoundException(file.getAbsolutePath() + " is not a file");
		}
		return file;
	}

}
