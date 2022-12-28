class Test {
    static void generateKeyMatrix(String key, int keyMatrix[][]) { // generate matrix corresponding to key
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                keyMatrix[i][j] = (key.charAt(k)) % 65;
                k++;
            }
        }
    }

    static void encrypt(int cipherMatrix[][], int keyMatrix[][], int messageVector[][]) {
        int x, i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 1; j++) {// Cipher matrix is 3x1
                cipherMatrix[i][j] = 0;// Initialize each instance of the resultant matrix to 0
                for (x = 0; x < 3; x++) {
                    cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];// Simple matrix multiplication
                }

                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;// mod 26
            }
        }
    }

    static void hillCipher(String message, String key) {
        int[][] keyMatrix = new int[3][3];
        generateKeyMatrix(key, keyMatrix);

        int[][] messageVector = new int[3][1];

        for (int i = 0; i < 3; i++) {
            messageVector[i][0] = (message.charAt(i)) % 65;
        }

        int cipherMatrix[][] = new int[3][1];

        encrypt(cipherMatrix, keyMatrix, messageVector);

        String cipherText = "";

        for (int i = 0; i < 3; i++) {
            cipherText += (char) (cipherMatrix[i][0] + 65);
        }

        System.out.println("The ciphertext is:" + cipherText);
    }

    public static void main(String[] args) {
        String message = "ACT";
        String key = "GYBNQKURP";

        hillCipher(message, key);
    }
}
