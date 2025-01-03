
import java.util.Scanner;

public class Slot_1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number => ");
        int number = sc.nextInt();

        long factorial = 1;
        int i=1;
        while (i<=number) {
            factorial *= i;
            i++;
        }
        System.out.println("Factorial of given number is => "+factorial);
        String str = Long.toString(factorial);
        int count = 0;
        int j=str.length();
        while (j>0) {
            if(str.charAt(j-1) == ('0'))
            {
                count++;
            }
            else
            {
                break;
            }
            j--;
        }
        System.out.println("Count => "+count);
    }
}
