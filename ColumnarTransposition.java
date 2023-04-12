import java.io.*;
import java.util.*;

class ColumnarTransposition {
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
        String encryptedText = "";
        int plaintextLength = plaintext.length();
        int keyLength = key.length();
        int numRows = (int) Math.ceil((double) plaintextLength / keyLength);
        char[][] transpositionTable = new char[numRows][keyLength];
        int plaintextIndex = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < keyLength; j++) {
                if (plaintextIndex < plaintextLength) {
                    transpositionTable[i][j] = plaintext.charAt(plaintextIndex);
                    plaintextIndex++;
                } else {
                    transpositionTable[i][j] = ' ';
                }
            }
        }

        for (int i = 0; i < keyLength; i++) {
            int columnIndex = key.indexOf(Character.toString((char) (i + '1')));
            for (int j = 0; j < numRows; j++) {
                encryptedText = encryptedText + transpositionTable[j][columnIndex];
            }
        }

        return encryptedText;

    }
}
