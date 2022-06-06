package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {
    Scanner scanner=new Scanner(System.in);
    ArrayList<Client> clients=new ArrayList<Client>();
    public void RunMainApp()
    {
        while (true)
        {

            Run();

        }
    }

    private void Run()
    {
        System.out.println("Select a number to start the application");
        System.out.println("1...Register");
        System.out.println("2...Login");
        System.out.println("3...Exit");
        int selectNumber=scanner.nextInt();


            switch (selectNumber)
            {
                case 1:
                    System.out.println("Create a Client");
                    Client client=new Client();
                    client.CreateClient();
                    this.clients.add(client);
                    break;
                case 2:
                    System.out.println("Login");
                    Login();
                    break;
                case 3:
                    System.out.println("Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter a valid option");
            }
    }
    private void Login()
    {
        System.out.println("Login");
        System.out.println("1...Enter the password");
        int selectNumber=scanner.nextInt();
        BankAccount account=GetAccountfromClient(selectNumber);
        if(account!=null)
        {
            BankAccountOptions(account);
        }
        else
        {
            System.out.println("The bank account wasn't found");
        }



    }
    private BankAccount GetAccountfromClient(int pin)
    {
        BankAccount account=new BankAccount();
        for(Client client:clients) {
            account= client.SearchBankAccountPIN(pin);
            if(account!=null)
            {
                break;
            }
        }
        if(account!=null)
        {
            return account;
        }
        else
        {
            return null;
        }
    }
    private void BankAccountOptions(BankAccount bankAccount)
    {
        while(true) {
            System.out.println("Select the option");
            System.out.println("1...Check the sold");
            System.out.println("2...Add Money");
            System.out.println("3...withdraw money");
            System.out.println("4...Transfer");
            System.out.println("5...Back");
            int selectNumber = scanner.nextInt();
            switch (selectNumber) {
                case 1:
                    System.out.println("Check the sold");
                    System.out.println("The current sold is " + bankAccount.getSold());
                    break;
                case 2:
                    System.out.println("Add Money");
                    bankAccount.AddMoneyBanckAccount();
                    break;
                case 3:
                    System.out.println("Withdraw Money");
                    bankAccount.WithdrawMoney();
                    break;
                case 4:
                    System.out.println("Transfer");
                    TransferMoney(bankAccount);
                    break;
                case 5:
                    System.out.println("Back");
                    Run();
                default:
                    System.out.println("Enter a valid option");
            }
        }
    }
    private void TransferMoney(BankAccount account)
    {
        System.out.println("Transfer Money");
        System.out.println("Enter the account number");
        scanner.nextLine();
        String a=scanner.nextLine();
        System.out.println("The account number is "+a);
        BankAccount bankAccount= GetAccountFromAccountNumber(a);
        if(bankAccount!=null)
        {
            System.out.println("The account is valid");
            System.out.println("You can transfer money");
            Tranzaction tranzaction=new Tranzaction();
            System.out.println("Enter the amount of money");
            long money=scanner.nextLong();
            tranzaction.TransferMoney(money,bankAccount,account);

        }
        else
        {
            System.out.println("Invalid account number");
        }



    }
    private BankAccount GetAccountFromAccountNumber(String number)
    {
        BankAccount account=new BankAccount();
        for(Client client:clients) {
            account= client.SearchBankAccountNumber(number);
            if(account!=null)
            {
                break;
            }
        }
        if(account!=null)
        {
            return account;
        }
        else
        {
            return null;
        }
    }
}
