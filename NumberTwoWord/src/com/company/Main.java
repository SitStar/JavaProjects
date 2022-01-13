package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){
            //Make a string to hold the user's input
            int input  = sc.nextInt();
            WordNumber wn = new WordNumber(input);
            String converted = wn.toString();
            System.out.println(converted);
        }

    }


}

class WordNumber{
    private int number;
    private String words;
    private String[] powers = { "", "thousand", "million", "billion"};
    public WordNumber(int num){
        number = num;
        words = "";
        convertNumToWord();
    }

    private void convertNumToWord() {
        int power = 0;
        int numCopy = number;
        while (numCopy / 1000 > 0) {
            power++;
            numCopy = numCopy / 1000;
        }

        if (number < 20) {
            if (number >= 10) {
                words += tensDigitToWord(number);
            } else {
                words += singleDigitToWord(number);
            }
        }

        // powers
        if (power != 0) {
            if (numCopy >= 100) {
                int hundreds = numCopy / 100;
                numCopy -= hundreds * 100;
                words += singleDigitToWord(hundreds) + " hundred ";
            }
            if (numCopy >= 20) {
                int tens = numCopy / 10;
                int single = numCopy % 10;
                words += tyDigitToWord(tens * 10) + "-" + singleDigitToWord(single) + " " + powers[power];
            } else if (numCopy >= 10) {
                words += tensDigitToWord(numCopy) + " " + powers[power];
            } else {
                words += singleDigitToWord(numCopy) + " " + powers[power];
            }
        }

        int leftover = power == 0 ? numCopy : (int) (number % Math.pow(1000, power));


        //space
        if(leftover > 0){
            words += " ";
        }else{
            return;
        }

        //thousands
        if(leftover >= 1000){
            int thousands = leftover / 1000;
            words += singleDigitToWord(thousands) +  " thousand ";
            leftover = leftover % 1000;
        }

        //hundreds
        if(leftover >= 100){
            int hundreds = leftover / 100;
            words += singleDigitToWord(hundreds) +  " hundred ";
            leftover = leftover % 100;
        }

        // and
        if(leftover > 0 && number >= 100){
            words += "and ";
        }else{
            return;
        }

        //check ty
        if(leftover >= 20 && leftover <= 99){
            int ty = leftover / 10;
            leftover = leftover % 10;
            words += tyDigitToWord(ty * 10) + "-";
        }

        //teens
        if(leftover >= 10 && leftover <= 19){
            words += tensDigitToWord(leftover);
        }
        // single digits
        else if(leftover < 10){
            words += singleDigitToWord(leftover);
        }
    }

    private String tyDigitToWord(int i){
        if( i >= 20 && i <= 90){
            switch(i) {
                case 20:
                    return "twenty";
                case 30:
                    return "thirty";
                case 40:
                    return "forty";
                case 50:
                    return "fifty";
                case 60:
                    return "sixty";
                case 70:
                    return "seventy";
                case 80:
                    return "eighty";
                case 90:
                    return "ninety";
            }
        }else{
            // we have a problem
            System.out.println("Not a digit in the 20-90 range!");
        }
        return "error";
    }

    private String tensDigitToWord(int i){
        if( i >= 10 && i <= 19){
            switch(i) {
                case 10:
                    return "ten";
                case 11:
                    return "eleven";
                case 12:
                    return "twelve";
                case 13:
                    return "thirteen";
                case 14:
                    return "fourteen";
                case 15:
                    return "fifteen";
                case 16:
                    return "sixteen";
                case 17:
                    return "seventeen";
                case 18:
                    return "eighteen";
                case 19:
                    return "nineteen";
            }
        }else{
            // we have a problem
            System.out.println("Not a digit in the 10-19 range!");
        }
        return "error";
    }

    private String singleDigitToWord(int i){
        switch(i){
            case 0:
                return "";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
        }
        return "Not a single digit";
    }

    public String toString(){
        return words;
    }
}

// 1, 100, 1532
// one, one hundred, one thousand five hundred thirty two