import java.io.*;
import java.util.*;

class RailFence {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the plaintext:");
        String plaintext = sc.nextLine();

        System.out.println("Enter the no: of rails:");
        int rails = sc.nextInt();

        String encryptedText = encrypt(plaintext, rails);
        System.out.println("The encrypted text is:" + " " + encryptedText);
    }

    public static String encrypt(String plaintext, int rails) {
        StringBuilder encryptedText = new StringBuilder();
        char[][] matrix = new char[rails][plaintext.length()];
        int row = 0;
        int col = 0;
        boolean down = true;

        for (int i = 0; i < plaintext.length(); i++) {
            matrix[row][col] = plaintext.charAt(i);

            if (row == rails - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }

            if (down) {
                row++;
            } else {
                row--;
                col++;
            }
        }

        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                if (matrix[i][j] != 0) {
                    encryptedText.append(matrix[i][j]);
                }
            }
        }

        return encryptedText.toString();
    }
}
