package smartwallet.model;
import java.util.*;

public class account{
private String name;
private String usarname;
private String type;
private double balance;
private List <Transaction> transaction;

public account(string name, string usarname, stringtype){
    this.name = name;
    this.username = username;
    this.type = type;
    this balance = 0.0;
    this translacations = new ArrayList<>()
}
public String getUsarname() {return usarname;}
public String getName(){return name;}
public String getType(){return type;}
public double getBalance() {return balance;}

public void addBalance(double amount){
    balance+= amount;
}
public void deductBalance(doubleamount){
    balance -= amount;}
public void addTransaction(Transcaction t) {transactions.add(t);}
public List<Transaction>
getTranscation(){
    return transactions;
}
}

