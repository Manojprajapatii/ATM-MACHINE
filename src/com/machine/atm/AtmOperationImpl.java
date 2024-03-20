package com.machine.atm;

import java.util.LinkedHashMap;
import java.util.Map;

public class AtmOperationImpl implements AtmOperationInterf {
    ATM atm=new ATM();
    Map<Double,String> ministmt=new LinkedHashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is: "+atm.getBalance());
    }

    @Override
    public void withdrawAmount(double withdrawAmount) {
        System.out.println("Only 200 and 500 Notes Available");
        if (withdrawAmount>=500){
            if (withdrawAmount<=atm.getBalance()){
                ministmt.put(withdrawAmount,"Amount Withdrawn");
                System.out.println("Collect the Case "+withdrawAmount);
                atm.setBalance(atm.getBalance()-withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !");
            }
        } else if (withdrawAmount%200==0) {
            if (withdrawAmount<=atm.getBalance()){
                ministmt.put(withdrawAmount,"Amount Withdrawn");
                System.out.println("Collect the Case "+withdrawAmount);
                atm.setBalance(atm.getBalance()-withdrawAmount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !");
            }
        } else{
            System.out.println("Please enter the valid amount");
        }

    }

    @Override
    public void depositAmount(double depositAmount) {
        ministmt.put(depositAmount,"Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
    }

    @Override
    public void viewMiniStatement() {
        System.out.println("view statements: ");
        for (Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
    }
}
