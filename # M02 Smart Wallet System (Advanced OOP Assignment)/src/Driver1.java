package smartwallet.driver;

import smartwallet.model.*;
import java.util.*;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] parts = input.split("#");

            if (parts[0].equals("create-account")) {
                Account acc = new Account(parts[1], parts[2], parts[3]);
                accounts.add(acc);
            }
        }

        for (Account acc : accounts) {
            System.out.println(
                acc.getUsername() + "|" +
                acc.getName() + "|" +
                acc.getType() + "|" +
                acc.getBalance()
            );
        }
    }
}