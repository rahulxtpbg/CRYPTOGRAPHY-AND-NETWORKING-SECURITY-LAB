import java.io.*;
import java.util.*;

class PolyalphabeticCipher {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the plaintext:");
        String plaintext = sc.nextLine();

        System.out.println("Enter the key:");
        String key = sc.nextLine();

        String encryptedText = encrypt(plaintext, key);
        System.out.println("The encrypted text is:" + encryptedText);
    }

    public static String encrypt(String plaintext, String key) {
        StringBuilder encryptedText = new StringBuilder();
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            if (Character.isLetter(ch)) {
                char k = key.charAt(i % key.length());
                int shift = k - 'A';
                char encryptedChar = (char) ((ch - 'A' - shift + 26) % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(ch);
            }
        }

        return encryptedText;
    }
}
