package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public static final int CHECKING = 0;
    public static final int SAVINGS = 1;
    public static final int MAXI_SAVINGS = 2;

    private final int accountType;
    public List<Transaction> transactions;
    
    private double balance;

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

    public void rollback(Account fromAcct,Account toAcct,double amount) {
               fromAcct.balance = balance + amount;
               toAcct.balance   = balance-amount;
       
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
                if((amonut == balance) && past10days)  // albert pi
                   return balance+(balance* 0.05);
                else 
                    return balance+(balance*0.01);
                                                       // albert pi
                                                      
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

    public void transferTo(Account fromAcct,Account toAcct, double amount) { // albert pi
        if((fromAcct.balance > amount) && (amount > 0)) {        
           fromAcct.withdraw(amount);
           toAcct.deposit(amount);
           System.out.println("Transfer succesful. Tansfered: $" + amount);
       } else if(amount <= 0) {
            rollback(fromAcct,toAcct,amount);
            transactions.add(new Transaction(amount));
            System.out.println("Invalid amount to transfe, Transaction cancelled.");
       } else { 
           transactions.add(new Transaction(amount));
           System.out.println("Transfer failed, not enough balance!");
        }
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
  public double Accure() { // albert pi
      
      return balance+(balance*0.015);  // rates above are per-annum
      
  }
    


