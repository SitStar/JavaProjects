package com.company;
import java.util.Scanner;

public class Main {

    public static int factorial(int n){
        int result = 1;
        for(int i = 1; i<=n; i++){
            // this loop will run n times
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        // Scan in the user's number and store iy in num
        int num = scanner.nextInt();
        System.out.println("You typed in: " + num);
        System.out.println(num + "! is equal to " + factorial(num));
    }
}
