/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380;

import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class TransactionTest {
    public static void main(String[] args)
    {
        Model m = new Model();
        m.writeTransactionToFile("USD", "1","Yuan", "5");
        m.writeTransactionToFile("USD", "1","Yuan", "6");
        m.writeTransactionToFile("USD", "1","Yuan", "7");
        
        ArrayList<Transaction> a = m.readTransactionsFromFile();
        for(Transaction f : a)
        {
            System.out.println(f.print());
        }
    }
}
