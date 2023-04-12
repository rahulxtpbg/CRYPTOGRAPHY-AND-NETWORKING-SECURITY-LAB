import java.io.*;
import java.util.*;

class CaesarCipher {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the plaintext:");
        String plaintext = sc.nextLine();

        System.out.println("Enter the key");
        int key = sc.nextInt();

        String encryptedText = encrypt(plaintext, key);
        System.out.println("The encrypted text is:" + " " + encryptedText);
    }

    public static String encrypt(String plaintext, int key) {
        String encryptedText = "";

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                ch = (char) ((ch - 'a' + key) % 26 + 'a');
            }
            if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + key) % 26 + 'A');
            }

            encryptedText = encryptedText + ch;
        }

        return encryptedText;
    }
}
