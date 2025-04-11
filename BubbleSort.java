//Andrea Ramirez 
// Chpt3 PA
// Bubble Sort Algorithm - O(N^2)

// Program generates 25 random numbers, sorts them using bubble sort, and prints before and after

import java.util.Random;

public class BubbleSort {

   public static void bubbleSort(int[] numbers, int numbersSize) {
      int i = 0;
      int j = 0;
      int k = 0;
      int temp = 0;  // Temporary variable for swap

      for (i = 0; i < numbersSize - 1; ++i) {

         // Compare each pair of numbers in the list and move the larger number to the right
         for (j = 0; j < numbersSize - 1 - i; ++j) {

            if (numbers[j] > numbers[j + 1]) {
			
               // Swap numbers[j] and numbers[j + 1]
               temp = numbers[j];
               numbers[j] = numbers[j + 1];
               numbers[j + 1] = temp;
            }
         }

         // System.out.printf("After Iteration %d:  ", i + 1);
         // for (k = 0; k < numbersSize; ++k) {
         //    System.out.printf("%d ", numbers[k]);
         // }
         // System.out.printf("\n");
      }
   }

   // Prints the array
   public static void printArray(int[] numbers, int numbersSize) {
      int i = 0;
      for (i = 0; i < numbersSize; ++i) {
         System.out.printf("%d ", numbers[i]);
      }
      System.out.printf("\n");
   }

   public static void main(String[] args) {
      int numbers[] = new int[25];
      int NUMBERS_SIZE = 25;
      int i = 0;

      Random rand = new Random();

      // Fill array with random integers between 1 and 1000
      for (i = 0; i < NUMBERS_SIZE; ++i) {
         numbers[i] = rand.nextInt(1000) + 1;
      }

      // Print unsorted array
      System.out.print("Unsorted Array:\n");
      printArray(numbers, NUMBERS_SIZE);

      // Call bubbleSort
      bubbleSort(numbers, NUMBERS_SIZE);

      // Print sorted array
      System.out.print("Sorted Array:\n");
      printArray(numbers, NUMBERS_SIZE);
   }
}
