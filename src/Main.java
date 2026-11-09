import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 0;
        int max = 0;
        boolean min_status = false;
        boolean max_status = false;
        int try_number ;
        int guessing_number = 0 ;
        ArrayList<Integer> guessing_numbers =  new ArrayList<>();

        System.out.println("Welcome to the Guess Number Game :");
        System.out.println("Do you want to paly the game(yes/no)?");
        String want_to_play =  sc.nextLine();

        if(want_to_play.equals("no")){
            System.exit(1);
        }

        while(!min_status) {
            try {
                System.out.println("Please enter the minimum guess number :");
                min = sc.nextInt();
                min_status = true;
            }
            catch (InputMismatchException e) {
                sc.nextLine();
            }finally {
                System.out.println("Min number is setting successfully!");
            }
        }

        while(!max_status) {
            try {
                System.out.println("Please enter the maximum guess number :");
                max = sc.nextInt();
                max_status = true;
            }
            catch (InputMismatchException e) {
                sc.nextLine();
            }finally {
                System.out.println("Max number is setting successfully!");
            }
        }


        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;


        try_number = (int)(Math.round(Math.log(max - min + 1) / Math.log(2))) ;
        System.out.println("You have " + try_number + " Try to guess the right number in the range .");

        for (int i = 0; i < try_number ; i++) {
            boolean guessing_status = false  ;
            while(!guessing_status) {
                try {
                    System.out.println("Guess a number:");
                    guessing_number = sc.nextInt();
                    guessing_status = true;
                }catch (InputMismatchException e) {
                    System.out.println("Invalid input!!");
                    sc.nextLine();
                    i = i - 1 ;
                }
            }
            guessing_numbers.add(guessing_number);

            if(guessing_number == randomNum){
                System.out.println("Congratulation! You guess the right number in the " + (i+1) + " try.");
                System.out.println("The right number is " + randomNum + ", Exactlly as your choosing one : " + guessing_number);
                break;
            } else if (guessing_number > randomNum && guessing_number < max) {
                System.out.println("Your guessing number is too hight to the right number");
                System.out.println("you have "+(try_number -i - 1) +" tries ");
                System.out.println("Your wrong guessing numbers are " + guessing_numbers);
            } else if(guessing_number < randomNum && guessing_number > min) {
                System.out.println("Your guessing number is too low to the right number");
                System.out.println("you have "+(try_number -i - 1) +" tries ");
                System.out.println("Your wrong guessing numbers are " + guessing_numbers);
            } else {
                System.out.println("Your guessing number is out of the range!!");
                System.out.println("You have "+(try_number -i - 1) +" tries ");
                System.out.println("Your wrong guessing numbers are " + guessing_numbers);
            }
        }
        if(guessing_number != randomNum ){
            System.out.println("You finished the number of try.");
            System.out.println("You didn't get the right number!");
            System.out.println("The right number is " + randomNum);
        }

    }
}