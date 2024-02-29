import java.util.ArrayList;
import java.util.Scanner;

class Admin {
    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Main {
    private static ArrayList<Admin> users = new ArrayList<>();

    public static void main(String[] args) {

        users.add(new Admin("user1", "password1"));
        users.add(new Admin("user2", "password2"));
        String[] mahasiswaNIMs = {"202310370311054", "987654321098765"};

        Scanner scanner = new Scanner(System.in);
        boolean isLogin = false;

        // Login process
        while (!isLogin) {
            System.out.println("\nSilakan login sebagai Admin atau Mahasiswa:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    if (isValidAdmin(username, password)) {
                        System.out.println("Successful Login as Admin!");
                        isLogin = true;
                    } else {
                        System.out.println("User not found. Please try again.");
                    }
                    break;
                case 2:
                    System.out.print("Enter your NIM: ");
                    String nim = scanner.nextLine();
                    if (isValidNIM(nim, 15) && isValidMahasiswa(nim, mahasiswaNIMs)) {
                        System.out.println("Successful Login as Student!");
                        isLogin = true;
                    } else {
                        System.out.println("User not found. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem login Library.");
                    return;
                default:
                    isLogin = true;
                    System.out.println("Pilihan tidak valid.");
            }
            scanner.close();
        }
    }

    public static boolean isValidAdmin(String username, String password) {
        for (Admin user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidNIM(String nim, int length) {
        return nim.length() == length;
    }

    public static boolean isValidMahasiswa(String nim, String[] mahasiswaNIMs) {
        for (String validNIM : mahasiswaNIMs) {
            if (validNIM.equals(nim)) {
                return true;
            }
        }
        return false;
    }
}


