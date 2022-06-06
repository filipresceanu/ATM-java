package com.company;

public class Tranzaction {
    private BankAccount bankAccountsource;

    private BankAccount bankAccountdestination;


    public BankAccount getBankAccountsource() {
        return bankAccountsource;
    }

    public void setBankAccountsource(BankAccount bankAccountsource) {
        this.bankAccountsource = bankAccountsource;
    }

    public BankAccount getBankAccountdestination() {
        return bankAccountdestination;
    }

    public void setBankAccountdestination(BankAccount bankAccountdestination) {
        this.bankAccountdestination = bankAccountdestination;
    }



    public void TransferMoney(long number,BankAccount destination,BankAccount source)
    {
        this.bankAccountdestination=destination;
        this.bankAccountsource=source;
        if(number>bankAccountsource.getSold())
        {
            System.out.println("Insufficient sold");
        }
        else
        {
            bankAccountsource.setSold(bankAccountsource.getSold()-number);
            bankAccountdestination.setSold(bankAccountdestination.getSold()+number);
        }
    }
}
