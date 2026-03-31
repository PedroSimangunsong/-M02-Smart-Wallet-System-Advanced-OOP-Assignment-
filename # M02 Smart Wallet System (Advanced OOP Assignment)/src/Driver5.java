package smartwallet.driver;

import smartwallet.model.*;
import java.util.*;

public class Driver5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        while (true) {
            String input = sc.nextLine();
            if (input.equals("---")) break;

            String[] parts = input.split("#");

            switch (parts[0]) {

                case "create-account":
                    accounts.put(parts[2], new Account(parts[1], parts[2], parts[3]));
                    break;

                case "deposit": {
                    Account acc = accounts.get(parts[1]);
                    Transaction t = new DepositTransaction(parts[1],
                            Double.parseDouble(parts[2]),
                            parts[3],
                            parts[4]);
                    t.process(acc);
                    acc.addTransaction(t);
                    break;
                }

                case "withdraw": {
                    Account acc = accounts.get(parts[1]);
                    Transaction t = new WithdrawTransaction(parts[1],
                            Double.parseDouble(parts[2]),
                            parts[3],
                            parts[4]);
                    t.process(acc);
                    acc.addTransaction(t);
                    break;
                }

                case "show-account": {
                    Account acc = accounts.get(parts[1]);

                    System.out.println(acc.getUsername() + "|" +
                            acc.getName() + "|" +
                            acc.getType() + "|" +
                            acc.getBalance());

                    List<Transaction> list = acc.getTransactions();

                    list.sort(Comparator.comparing(Transaction::getTimestamp));

                    for (Transaction t : list) {
                        System.out.println(
                                t.getId() + "|" +
                                t.getType() + "|" +
                                t.getAmount() + "|" +
                                t.getFee() + "|" +
                                t.getNetAmount() + "|" +
                                t.getTimestamp() + "|" +
                                t.getDescription()
                        );
                    }
                    break;
                }
            }
        }
    }
}
    
}
