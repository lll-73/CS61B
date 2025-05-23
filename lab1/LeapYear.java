/** Class that determines whether or not a year is a leap year.
 *  @author yiming lin
 */
public class LeapYear {
	public static boolean isLeapYear(int year){
	/**check whether a year is divisible by 400*/
		if (year%400==0){
			return true;
		}
	/**check whether a year is divisible by 4 and not by 100*/
		if (year%4==0){
			if (year%100!=0){
				return true;
			}
		}
		return false;
	}
	/** Calls isLeapYear to print correct statement.
	 *  @param  year to be analyzed
	 */
	private static void checkLeapYear(int year) {
		if (isLeapYear(year)) {
			System.out.printf("%d is a leap year.\n", year);
		} else {
			System.out.printf("%d is not a leap year.\n", year);
		}
	}

	/** Must be provided an integer as a command line argument ARGS. */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Please enter command line arguments.");
			System.out.println("e.g. java Year 2000");
		}
		for (int i = 0; i < args.length; i++) {
			try {
				int year = Integer.parseInt(args[i]);
				checkLeapYear(year);
			} catch (NumberFormatException e) {
				System.out.printf("%s is not a valid number.\n", args[i]);
			}
		}
	}
}

