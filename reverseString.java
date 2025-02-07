import java.util.Scanner;

public class reverseString {

     public static String reverseString (String word) {
		if (word.length( ) <= 1) {
			return word;
		} else {
				return reverseString(word.substring(1)) + word.charAt(0);
			}
	}
   
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String input, result;
		
		System.out.print("Enter the string to be reversed: ");
		input = scnr.nextLine();
		
		result = reverseString(input);
		
		System.out.printf("Reversed: %s\n", result);
	}
}