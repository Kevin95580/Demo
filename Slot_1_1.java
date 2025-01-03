//Haystack-needle --> slot-1 Program-1

import java.util.Scanner;

public class Slot_1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter haystack =>");
        String haystack = sc.next();
        System.out.print("Enter needle => ");
        String needle = sc.next();

        haystack = haystack.toLowerCase();
        needle = needle.toLowerCase();
        int index = -1;

        for(int i=0;i<=haystack.length() - needle.length();i++)
        {
            if((haystack.substring(i, i+needle.length())).equals(needle))
            {
                index = i;
                break;
            }

        }
        System.out.println("Index =>" +index);
    }
}
