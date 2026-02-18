import java.util.*;
class Account
{
    String AccountHolder;
    String AccountNumber;
    double balance;
    double amount;

    Account(String AccountHolder,String AccountNumber,double balance)
    {
        this.AccountHolder=AccountHolder;
        this.AccountNumber=AccountNumber;
        this.balance=balance;
    }
    public void deposit(double amount)
    {
        if (amount>0)
        {
            System.out.print("the current balance is : "+balance);
            balance+=amount;
          System.out.print("the updated balance is : "+balance);
        }
        else
        {
            System.out.print("Invalid amount");
        }
    }

    public void withdraw(double amount)
    {
        if(amount<=0)
        {
            System.out.print("invalid amount");

        }
        else if(amount>balance)
        {
            System.out.print("insufficient balance");
        }
        else{
             System.out.print("the current balance is : "+balance+"\n");
            balance=balance-amount;
            System.out.print("the updated balance is : "+balance);

        }
    }
    public double getBalance()
    {
        return balance;
    }
}

public class ATM
{
    public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       System.out.println("enter the name of the account holder: ");
       String AccountHolder=sc.nextLine();
       System.out.println("enter the account number: ");
       String AccountNumber=sc.nextLine();
       Account a1=new Account(AccountHolder, AccountNumber, 10000.00);
       System.out.print("choose options from the menu \n1.Withdraw \n2.Deposit \n3.check balance\n 4.exit\n");
       int choice=sc.nextInt();

       switch(choice)
       {
        case 1:
            System.out.print("Enter the amount to be withdraw: ");
            double amount=sc.nextDouble();
            a1.withdraw(amount);
            break;

        case 2:
            System.out.print("enter the amount to be deposited: ");
            amount= sc.nextDouble();
            a1.deposit(amount);
            break;
            
        case 3:
            System.out.print("the balance is: "+a1.getBalance());
            break;
        case 4:
            break;        
       }
    }
}