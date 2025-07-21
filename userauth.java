import java.util.*;
import java.io.*;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class UserAuth {
    private static final String CREDENTIALS_FILE = "users.txt";
    private static final String SALT = "S@ltValue123"; // constant salt for demo (use random salt in production)

    public static void register(String username, String password) throws Exception {
        String hashedPassword = hashPassword(password);
        FileWriter fw = new FileWriter(CREDENTIALS_FILE, true);
        fw.write(username + ":" + hashedPassword + "\n");
        fw.close();
    }

    public static boolean login(String username, String password) throws Exception {
        String hashedPassword = hashPassword(password);
        BufferedReader br = new BufferedReader(new FileReader(CREDENTIALS_FILE));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals(username + ":" + hashedPassword)) {
                br.close();
                return true;
            }
        }
        br.close();
        return false;
    }

    private static String hashPassword(String password) throws Exception {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), 65536, 128);
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }
}
