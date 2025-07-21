import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Welcome to Secure File Vault");
            System.out.print("1. Register\n2. Login\nChoose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            boolean loggedIn = false;

            if (choice == 1) {
                UserAuth.register(username, password);
                System.out.println("Registration successful. Please login.");
            }

            if (choice == 2 || choice == 1) {
                loggedIn = UserAuth.login(username, password);
                if (!loggedIn) {
                    System.out.println("Login failed.");
                    return;
                } else {
                    System.out.println("Login successful.");
                }
            }

            while (loggedIn) {
                System.out.print("\n1. Encrypt File\n2. Decrypt File\n3. Exit\nChoose option: ");
                int opt = sc.nextInt();
                sc.nextLine();

                if (opt == 1) {
                    System.out.print("Enter input file path: ");
                    String input = sc.nextLine();
                    System.out.print("Enter output encrypted file path: ");
                    String output = sc.nextLine();
                    FileEncryptor.encrypt(input, output, password);
                    System.out.println("File encrypted successfully.");
                } else if (opt == 2) {
                    System.out.print("Enter encrypted file path: ");
                    String input = sc.nextLine();
                    System.out.print("Enter output decrypted file path: ");
                    String output = sc.nextLine();
                    FileEncryptor.decrypt(input, output, password);
                    System.out.println("File decrypted successfully.");
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
