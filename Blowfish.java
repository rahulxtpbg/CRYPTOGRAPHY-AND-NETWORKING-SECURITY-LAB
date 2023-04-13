import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

class Blowfish {
    public static void main(String args[]) {
        String plaintext = "Hello World!";
        String key = "ThisIsaKey";

        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted: " + encrypted);
    }

    public static String encrypt(String plaintext, String key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
