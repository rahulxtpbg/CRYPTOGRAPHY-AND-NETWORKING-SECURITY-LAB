import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.DESKeySpec;
import java.xml.bind.DataTypeConverters;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

class DES {
    public static void main(String args[]) {
        String plaintext = "Hello World";
        String keyString = "0123456789abcdef";

        byte[] keyBytes = DataTypeConverter.parseHexBinary(keyString);

        DESKeySpec keySpec = new DESKeySpec(keyBytes);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(keySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Text: " + encryptedText);
    }
}
