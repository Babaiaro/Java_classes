package strings;
import java.util.Scanner;

public class Scannerinput {

    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");

       String name = scanner.nextLine();
       System.out.println("Hello, " + name);

       System.out.print("Enter your age: ");
       double age = scanner.nextDouble();


       System.out.print("Are you student? (true/false): ");
       boolean isStudent = scanner.nextBoolean();

        System.out.println("Hi "+ name +" your age is " + age);


       if(isStudent == true){
           System.out.println("Student are student at NLU now");

       }else {
           System.out.println("Student are not student at NLU now");
       }
       */


        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age : ");
        int yourage = scanner .nextInt();
        scanner.nextLine();

        System.out.print("Enter your fav color : ");
        String colour = scanner.nextLine();

        System.out.print("You are "+ yourage + " years old ");
        System.out.print("You like "+ colour+" color");
        










        scanner.close();

    }
}
































