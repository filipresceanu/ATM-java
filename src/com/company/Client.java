package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class Client {
    private String name;
    private ArrayList<BankAccount>accounts=new ArrayList<>();
    private String city;

    Scanner scanner=new Scanner(System.in);
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void CreateClient()
    {
        System.out.println("Enter the name");
        String name=scanner.nextLine();
        this.name=name;
        System.out.println("The name is "+name);
        System.out.println("Enter the address");
        String city=scanner.nextLine();
        this.city=city;
        System.out.println("The city is "+city);
        System.out.println("Create bank account");
        BankAccount account=new BankAccount();
        account.CreateBankAccount();
        accounts.add(account);

    }
    public  BankAccount SearchBankAccountNumber(String accountnumber)
    {
        BankAccount bankAccount=new BankAccount();
        for (BankAccount account:accounts) {
            bankAccount=account.GetBankAccountNumber(accountnumber);
            if(bankAccount!=null)
            {
                break;
            }

        }
        if(bankAccount!=null) {
            return bankAccount;
        }
        else
        {
            return null;
        }
    }

    public BankAccount SearchBankAccountPIN(int pin)
    {
        BankAccount bankAccount=new BankAccount();
        for (BankAccount account:accounts) {
            bankAccount=account.GetBankAccountPIN(pin);
            if(bankAccount!=null)
            {
                break;
            }

        }
        if(bankAccount!=null) {
            return bankAccount;
        }
        else
        {
            return null;
        }
    }
    

}
