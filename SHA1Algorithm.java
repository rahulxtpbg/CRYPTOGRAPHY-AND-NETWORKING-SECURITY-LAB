import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class SHA1Algorithm {
    public static void main(String args[]) {
        String input = "Hello World!";

        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");

            byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);

            sha1.update(inputBytes);

            byte[] hashBytes = sha1.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            System.out.println("Input: " + input);
            System.out.println("SHA-1 Hash: " + sb.toString());
        }

        catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
}
