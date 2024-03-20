package com.machine.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        AtmOperationInterf op=new AtmOperationImpl();
        int atmnumber=12345;
        int atmpin=1234;

        Scanner in=new Scanner(System.in);
        System.out.println("Welcome to ATM Machine !!");
        System.out.println("Enter ATM Number: ");
        int atmNunber=in.nextInt();
        System.out.println("Enter Pin: ");
        int pin=in.nextInt();
        if((atmnumber==atmNunber) && (atmpin==pin)){
            while (true){
                System.out.println("1.View Available Balance");
                System.out.println("2.Withdraw Amount");
                System.out.println("3.Deposit Amount");
                System.out.println("4.View Ministatements");
                System.out.println("5.Exit");
                System.out.println("Enter your Choice: ");
                int ch=in.nextInt();
                if(ch==1){
                    op.viewBalance();
                } else if (ch==2){
                    System.out.println("Enter amount to withdraw: ");
                    double withdrawAmount=in.nextDouble();
                    op.withdrawAmount(withdrawAmount);
                } else if(ch==3){
                    System.out.println("Enter Amount to Deposit :");
                    double depositAmount=in.nextDouble();
                    op.depositAmount(depositAmount);
                } else if(ch==4){
                    op.viewMiniStatement();
                } else if (ch==5){
                    System.out.println("Collect your ATM Card! ");
                    System.out.println("Thank you for using ATM Machine!!");
                    System.exit(0);
                } else {
                    System.out.println("Please Enter Correct choice");
                }
            }
        } else {
            System.out.println("Incorrect ATM number or pin");
            System.exit(0);
        }
    }
}
