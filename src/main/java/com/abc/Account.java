package com.abc;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.text.DateFormat;


public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;
    public double per-annum = 0.0
    
    private double balance;
    
    
    
    
    private final int accountType;
    public List<Transaction> transactions;
    
    public Account() { // albert pi
        balance = 0.0;
      }
    
    public Account(int accountType, double balance) {
        this.accountType = accountType;
        
        this.balance = balance; // albert pi
        
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("amount must be greater than zero");
    } else {
        transactions.add(new Transaction(-amount));
    }
}

    public double interestEarned() {
        double amount = sumTransactions();
                 
        switch(accountType){
            case SAVINGS:
                if (amount <= 1000)
                    return amount * 0.001;
                else
                    return 1 + (amount-1000) * 0.002;
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
            case MAXI_SAVINGS:
                if (amount <= 1000)
                    return amount * 0.02;
                if (amount <= 2000)
                    return 20 + (amount-1000) * 0.05;                         
                if(amonut == balance && past10days)  // albert
                    return amount* 0.05;
                else 
                    return amount* 0.01;
                    
                    return 70 + (amount-2000) * 0.1; 
                
                
                
                
            default:
                return amount * 0.001;
        }
    }

    public double sumTransactions() {
       return checkIfTransactionsExist(true);
    }

    private double checkIfTransactionsExist(boolean checkAll) {
        double amount = 0.0;
        for (Transaction t: transactions)
            amount += t.amount;
        return amount;
    }

    public int getAccountType() {
        return accountType;
    }
    
    
    public void transferTo(Account bank, double amount) { // albert pi
        if ( amount <= balance) {
        withdraw(amount);
        bank.deposit(amount);
        System.out.println("\nTransfer succesful. Tansfered: $" + amlount);
    } else { 
        System.out.println("\nTransfer failed, not enough balance!");
    }
                    
  public boolean past10days(){
    Date today = Calendar.getInstance().getTime();
    Calendar cal = Calendar.getInstance()
    String current = cal.toSstring():
    String past = cal.add(Calendar.DATE, -10).toString();
    if(current.equals(past))
       return true
        
   return false;
    
}      
 public double Accure() {
     
     return amount*0.015;  // rates above are per-annum
     
 }
