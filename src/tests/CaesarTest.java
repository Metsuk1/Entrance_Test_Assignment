package tests;

import entity.Caesar;
import java.util.Scanner;

public class CaesarTest {
    private static Scanner sc = new Scanner(System.in);

    public static void encrypt(){
        System.out.println("Caesar Cipher Encryption");
        System.out.print("Enter text: ");

        String input = sc.nextLine();

        System.out.print("Enter shift (integer): ");
        int shift = sc.nextInt();

        String result = Caesar.encrypt(input, shift);
        System.out.println("Encrypted text: " + result);
        System.out.println();
    }

    public static void decrypt(){
        System.out.println("Caesar Cipher Decryption");
        System.out.print("Enter encrypted text: ");

        String input = sc.nextLine();

        System.out.print("Enter shift (integer): ");
        int shift = sc.nextInt();

        String result = Caesar.decrypt(input, shift);
        System.out.println("Decrypted text: " + result);
        System.out.println();

    }
}
