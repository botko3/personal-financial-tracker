package SmallChangeSys;

import java.text.SimpleDateFormat;
import java.util.*;

public class OOPSmallChangeSys {
    private double balance = 0.0;
    private ArrayList<String> details = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public void start() {
        while (true) {
            System.out.println("\n==========Small Changes System==========");
            System.out.println("\t\t\t\t1  Details");
            System.out.println("\t\t\t\t2  Income");
            System.out.println("\t\t\t\t3  Expense");
            System.out.println("\t\t\t\t4  Quit");
            System.out.print("Please select (1-4): ");

            String key = scanner.next();

            switch (key) {
                case "1":
                    showDetails();
                    break;
                case "2":
                    addIncome();
                    break;
                case "3":
                    addExpense();
                    break;
                case "4":
                    quit();
                    return;
                default:
                    System.out.println("Invalid operation, please select again.");
            }
        }
    }

    private void showDetails() {
        System.out.println("---------------details----------------");
        for (String Detail : details) {
            System.out.println(Detail);
        }
    }

    private void addIncome() {
        try {
            System.out.print("Income: ");
            double money = scanner.nextDouble();
            if (money <= 0) {
                System.out.println("The amount of income should be greater than 0.");
                return;
            }
            System.out.println("Reason:");
            String reasons = scanner.next();
            balance += money;
            Date date = new Date();
            details.add(String.format("\nIncome\t+%.2f\t%s\t%s", money, reasons, sdf.format(date)));

        } catch (InputMismatchException e) {
            scanner.next(); // clear the input buffer
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void addExpense() {
        try {
            System.out.print("Expense: ");
            double money = scanner.nextDouble();

            if (money <= 0 || money > balance) {
                System.out.println("The amount of expense should be greater than 0 and not more than balance.");
                return;
            }

            System.out.print("Reasons: ");
            String reason = scanner.next();

            balance -= money;
            Date date = new Date();
            details.add(String.format("\nExpense\t-%.2f\t%s\t%s", money, reason, sdf.format(date)));
        } catch (InputMismatchException e) {
            scanner.next(); // clear the input buffer
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    private void quit() {
        String input = "";
        while (true) {
            System.out.print("Do you want to quit? (y/n) ");
            input = scanner.next();
            if ("y".equalsIgnoreCase(input) || "n".equalsIgnoreCase(input)) {
                break;
            }
        }
        if ("y".equalsIgnoreCase(input)) {
            System.out.println("----------Exited----------");
            scanner.close();
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        OOPSmallChangeSys smallChange = new OOPSmallChangeSys();
        smallChange.start();
    }
}