import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;

public class FileEncryptor {
    private static SecretKeySpec getKey(String password) throws Exception {
        byte[] key = password.getBytes("UTF-8");
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        key = sha.digest(key);
        return new SecretKeySpec(Arrays.copyOf(key, 16), "AES");
    }

    public static void encrypt(String inputFilePath, String outputFilePath, String password) throws Exception {
        SecretKeySpec secretKey = getKey(password);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        FileInputStream fis = new FileInputStream(inputFilePath);
        FileOutputStream fos = new FileOutputStream(outputFilePath);
        CipherOutputStream cos = new CipherOutputStream(fos, cipher);

        byte[] buffer = new byte[64];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            cos.write(buffer, 0, bytesRead);
        }
        fis.close();
        cos.close();
    }

    public static void decrypt(String inputFilePath, String outputFilePath, String password) throws Exception {
        SecretKeySpec secretKey = getKey(password);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        FileInputStream fis = new FileInputStream(inputFilePath);
        CipherInputStream cis = new CipherInputStream(fis, cipher);
        FileOutputStream fos = new FileOutputStream(outputFilePath);

        byte[] buffer = new byte[64];
        int bytesRead;
        while ((bytesRead = cis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        cis.close();
        fos.close();
    }
}
