import java.io.*;
import java.util.*;

class AutoKeyCipher {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the plaintext:");
        String plaintext = sc.nextLine();

        System.out.println("Enter the key:");
        String key = sc.nextLine();

        String encryptedText = encrypt(plaintext, key);
        System.out.println("The encrypted text is:" + " " + encryptedText);
    }

    public static String encrypt(String plaintext, String key) {
        StringBuilder encryptedText = new StringBuilder();
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        int keyIndex = 0;

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            char keyChar;
            if (keyIndex < key.length()) {
                keyChar = key.charAt(keyIndex);
                keyIndex++;
            } else {
                keyChar = plaintext.charAt(i - key.length());
            }
            char encryptedChar = (char) ((ch + keyChar - 2 * 'A') % 26 + 'A');
            encryptedText.append(encryptedChar);
        }

        return encryptedText.toString();
    }
}
