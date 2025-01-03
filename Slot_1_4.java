import java.util.Scanner;

public class Slot_1_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number => ");
        int n = sc.nextInt(); // User input 
        int tempn = n,digit=0;
        if(tempn < 10)
        {
            digit = 1;
        }
        else
        {
            while (tempn>0) 
            {
                digit++;
                tempn=tempn/10;
            }   
         }
        System.out.println("No. of digits => "+digit);
        int[] countArray = {0,9,90,900,9000,90000};
        int[] startArray = {0,1,10,100,1000,10000};
        int length = digit; // Length of numbers (1-digit, 2-digit, etc.)
        
        long count = countArray[digit]; // Number of numbers in the current block (9 for 1-digit, 90 for 2-digit, etc.)
        long start = startArray[digit]; // The first number in the current block (1, 10, 100, etc.)
         System.out.println(count);
         System.out.println(start);
        // Find the block where the nth digit lies
        while (n > length * count) {
            n -= length * count; // Decrease n by the number of digits in this block
            length++; // Increase the length for the next block (e.g., 1 -> 2 -> 3 digits)
            count *= 10; // Increase the count of numbers in the block (e.g., 9 -> 90 -> 900)
            start *= 10; // Move to the next starting number (e.g., 1 -> 10 -> 100)
        }

        // Find the actual number that contains the nth digit
        long num = start + (n - 1) / length;

        // Find the digit within the number
        String numStr = Long.toString(num); // Convert number to string to easily access digits
        int result = numStr.charAt((n - 1) % length) - '0'; // Return the nth digit

        // Output the result
        System.out.println(result); // Print the result
    }
}


// public class Main {

//     public static void main(String[] args) {
//         int n = 11; // Example input (you can change this to any integer)

//         int length = 1;  // Length of numbers (1-digit, 2-digit, etc.)
//         long count = 9;  // Number of numbers in the current block (9 for 1-digit, 90 for 2-digit, etc.)
//         long start = 1;  // The first number in the current block (1, 10, 100, etc.)
        
//         // Find the block where the nth digit lies
//         while (n > length * count) {
//             n -= length * count;  // Decrease n by the number of digits in this block
//             length++;              // Increase the length for the next block (e.g., 1 -> 2 -> 3 digits)
//             count *= 10;           // Increase the count of numbers in the block (e.g., 9 -> 90 -> 900)
//             start *= 10;           // Move to the next starting number (e.g., 1 -> 10 -> 100)
//         }
        
//         // Find the actual number that contains the nth digit
//         long num = start + (n - 1) / length;
        
//         // Find the digit within the number
//         String numStr = Long.toString(num);  // Convert number to string to easily access digits
//         int digit = numStr.charAt((n - 1) % length) - '0';  // Return the nth digit
        
//         // Output the result
//         System.out.println(digit);  // Print the result
//     }
// }
