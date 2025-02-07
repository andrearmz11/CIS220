//Andrea Ramirez
//Chpt 2 PA

// This program reverses a string using recursion and outputs the reversed string.
public class reverseString {
	
/* This method reverses a string by moving the first character to the end,
   and then calling itself on the rest of the string. */
   
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
		//Ask for and get the string to be reversed 
		System.out.print("Enter the string to be reversed: ");
		input = scnr.nextLine();
		
		result = reverseString(input);
		//Output the reversed string
		System.out.printf("Reversed: %s\n", result);
	}
}