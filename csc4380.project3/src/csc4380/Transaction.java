/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author aaron
 */
public class Transaction {
 String userName, currencyFrom, amountFrom, currencyTo, amountTo, time; 

    public Transaction(String u, String cf, String af, String ct, String at) {
        userName = u;
        currencyFrom = cf;
        amountFrom = af;
        currencyTo = ct;
        amountTo = at;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");
        time = ZonedDateTime.now().format(formatter);
    }
    
    public Transaction(String t, String u, String cf, String af, String ct, String at) {
        userName = u;
        currencyFrom = cf;
        amountFrom = af;
        currencyTo = ct;
        amountTo = at;
        time = t;
    }
    
    public String print()
    {
        return time + "," + userName + "," + currencyFrom + "," + amountFrom + "," 
                + currencyTo + "," + amountTo;
    }
}
