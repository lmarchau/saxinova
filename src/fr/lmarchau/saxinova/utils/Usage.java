package fr.lmarchau.saxinova.utils;

/**
 * Util class
 */
public class Usage {

	private Usage() {
	}

	/**
	 * print usage on standard output and exit with code 1
	 *
	 */
	public static void usage() {
		System.out.println("Usage: java -jar saxinova.jar <file>");
		System.exit(1);
	}

}
