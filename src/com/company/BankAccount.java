package com.company;

import java.util.Currency;
import java.util.Random;
import java.util.Scanner;

public class BankAccount {
    private final int accountNumberSize=10;
    private String currencyName;
    private long sold;
    private int pin;
    private String accountNumber;
    Random random = new Random();
    Scanner scanner=new Scanner(System.in);
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }
    public void CreateBankAccount()
    {
        System.out.println("Enter the currency");
        String currency=scanner.nextLine();
        this.currencyName=currency;
        System.out.println("The currency is "+currency);
        this.sold=0;
        System.out.println("The sold is by default set to 0");
        System.out.println("Enter the pin number");
        try {
            int pin = scanner.nextInt();
            this.pin=pin;
        }
        catch (Exception e)
        {
            System.out.println("Enter a valid pin ");
        }

        System.out.println("The pin is "+pin);
        this.accountNumber=GenerateRandomCardNumber();
        System.out.println("The card number is "+accountNumber);

    }
    private String GenerateRandomCardNumber()
    {
        String accountNumber="";
        for(int i=0;i<accountNumberSize;i++)
        {
            int number=random.nextInt(10);
            String temp=String.valueOf(number);
            accountNumber+=temp;
        }
        return accountNumber;
    }
    private void AddSold(long number_to_add)
    {
        this.sold+=number_to_add;

    }
    private void Withdraw(long number)
    {
        if(this.sold<number)
        {
            System.out.println("The sold is insufficient");
        }
        else
        {
            this.sold-=number;
        }

    }
    public BankAccount GetBankAccountNumber(String number)
    {
        if(number.equals(this.accountNumber))
        {
            return this;
        }
        else
        {
            return null;
        }
    }


    public BankAccount GetBankAccountPIN(int pin)
    {
        if(pin==this.pin)
        {
            return this;
        }
        else
        {
            return null;
        }
    }
    public void AddMoneyBanckAccount()
    {
        System.out.println("Enter the amount");
        try {
            long sold = scanner.nextLong();
            AddSold(sold);
        }
        catch (Exception exception)
        {
            System.out.println("Enter a valid sold ");
        }
    }
    public void WithdrawMoney()
    {
        System.out.println("Enter the amount");
        try
        {
            long sold=scanner.nextLong();
            Withdraw(sold);
        }
        catch (Exception exception)
        {
            System.out.println("Enter a valid number");
        }
    }



}
