import java.util.*;

class BankAccount {
    private String username;
    private String password;
    private double balance;

    public BankAccount(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String pass) {
        return this.password.equals(pass);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class BankSystem {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample account
        accounts.add(new BankAccount("jyo", "1234", 1000));

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    static void register() {
        System.out.print("Enter username: ");
        String user = sc.next();

        System.out.print("Enter password: ");
        String pass = sc.next();

        accounts.add(new BankAccount(user, pass, 0));
        System.out.println("Account created successfully!");
    }

    static void login() {
        System.out.print("Enter username: ");
        String user = sc.next();

        System.out.print("Enter password: ");
        String pass = sc.next();

        for (BankAccount acc : accounts) {
            if (acc.getUsername().equals(user) && acc.checkPassword(pass)) {
                System.out.println("Login successful!");
                bankingMenu(acc);
                return;
            }
        }
        System.out.println("Invalid credentials");
    }

    static void bankingMenu(BankAccount acc) {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Logout");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    acc.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    acc.withdraw(sc.nextDouble());
                    break;
                case 3:
                    acc.showBalance();
                    break;
                case 4:
                    System.out.println("Logged out");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}