/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingapplication;
import java.util.Scanner;
/**
 *
 * @author deepali_tiwari
 */
public class BankingApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankAccount ac = new BankAccount("Deepali","EN52");
        ac.showMenu();
    }
    
}

class BankAccount
{
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
    
    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }
    
    void deposit(int amount){
        if(amount != 0){
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited : "+previousTransaction);
        }
        else if(previousTransaction < 0){
            System.out.println("Withdraw : "+ Math.abs(previousTransaction));
        }
        else{
            System.out.println("No transcation occured.");
        }
    }
    void showMenu(){
        char option ='\0';
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome "+customerName+ " "+"Your ID is "+customerId);
        System.out.println("=======================================================================================");
        System.out.println("MENU");
        System.out.println("=======================================================================================");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
        
        do{
            System.out.println("=======================================================================================");
            System.out.println("Enter your choice :");
            System.out.println("=======================================================================================");
            option = sc.next().charAt(0);
            
            switch(option){
                case 'A' :
                    System.out.println("------------------------------------------------------");
                    System.out.println("Balance = "+balance);
                    System.out.println("------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'B' :
                    System.out.println("------------------------------------------------------");
                    System.out.println("Enter the amount to be deposit : ");
                    System.out.println("------------------------------------------------------");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("Rs."+amount+" "+"is deposited in your account.");
                    System.out.println("\n");
                    break;
                case 'C' :
                    System.out.println("------------------------------------------------------");
                    System.out.println("Enter the amount to withdraw : ");
                    System.out.println("------------------------------------------------------");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("Rs."+amount2+" "+"is withdraw from your account.");
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("------------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------------------------------");
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("------------------------------------------------------");
                    break;
                default:
                    System.out.println("Invalid option!!. Please enter again");
                    break;
            }
        }while(option != 'E');
        
        System.out.println("Thank you!!");
    }
}
