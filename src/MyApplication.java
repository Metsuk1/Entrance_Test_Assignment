import tests.CaesarTest;
import tests.EvaluatorTest;
import java.util.Scanner;

public class MyApplication {
    private static Scanner sc = new Scanner(System.in);


    public static void start(){
        System.out.println("Welcome to Gehtsoft Technical Assessment!\n");
        System.out.println("Please choose an option:");
        System.out.println("1. Caesar Cipher Encryption");
        System.out.println("2. Caesar Cipher Decryption");
        System.out.println("3. Arithmetic Expression Evaluation");
        System.out.println("4.Exit");

        int choice = sc.nextInt();
        System.out.println();

        switch(choice){
            case 1: CaesarTest.encrypt(); break;
            case 2: CaesarTest.decrypt(); break;
            case 3: EvaluatorTest.starter(); break;
            case 4:
                System.out.println("Exiting...");
                System.exit(0);
            default:
            System.out.println("Please choose an option:\n");
            start();
        }

    }


}
