package com.company;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        // Ask the user for all the categories for their spinner
        System.out.println("Category name: ");
        ArrayList<String> categories = new ArrayList<String>();
        categories.add(scanner.nextLine());
        System.out.println("Add another category? (Y/N): ");
        while(scanner.nextLine().equalsIgnoreCase("Y")){
            System.out.println("Category name: ");
            categories.add(scanner.nextLine());
            System.out.println("Add another category? (Y/N): ");
        }
        System.out.println(categories.toString());
    }
}
