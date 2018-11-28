/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380;

import java.beans.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class Model implements Serializable {
    
    private String url, user, password = "";
    private String current_user = "", current_native, current_lastConver;
    private String status;
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;

    
    DatabaseBean dbBean;
    
    
    
    public Model() {
        propertySupport = new PropertyChangeSupport(this);
        dbBean = new DatabaseBean();
    }
    
    
    
    
    public String getSampleProperty() {
        return sampleProperty;
    }
    
    public void setSampleProperty(String value) {
        String oldValue = sampleProperty;
        sampleProperty = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, sampleProperty);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    
    
    
    
    void setNative(String s) {
        
        dbBean.setNativeCountry(s, current_user);
    }
    
    
    /*
    //This method should take in a string, of the format "US Dollars", "British Pounds" , etc
    // and should be able to return the exchange rate from USD to String rate.
    */
    double getExchangeRate(String rate) {
        return dbBean.getExchangeRate(rate);
    }


    void createUser(String uName, String password) {
        
       status = dbBean.createUser(uName, password);
    }
    
    void login(String uName, String password) {
        status = dbBean.login(uName, password, this);
        
    }

    void setCurrent_user(String user) {
        current_user = user;
    }
    void setCurrent_native(String n) {
        current_native = n;
    }
    void setCurrent_lastConver(String lc) {
        current_lastConver = lc;
}

    String getPassword(String uName) {
        return "";
    }
    
    void setStatus(String s) {
        status = s;
    }
    
    String getStatus() {
        return status;
    }
    
    String[] getUserInfo() {
        String[] temp = {current_user, current_native, current_lastConver};
        return temp;
    }
    

    void setLastConversion(String currency) {
        String tempStatus = dbBean.setLastConversion(currency, current_user);
        if(tempStatus.equals("login failed"))
        {
            status = "login failed";
        }
        
    }
    
    void deleteUser() {
        String tempStatus = dbBean.deleteUser(current_user);
        if(tempStatus.equals("signup failed"))
        {
            status = "signup failed";
        }
        current_user = "";
        
    }
    
    String getCurrency() {
        return dbBean.getCurrency(current_native);
    }
    
    void writeTransactionToFile(String currFrm, String amtFrom, String currTo, String amtTo){
        Transaction t = new Transaction(current_user, currFrm, amtFrom, currTo, amtTo);
        try { 
  
            // Open given file in append mode. 
            String localDir = System.getProperty("user.dir");
            BufferedWriter out = new BufferedWriter(new FileWriter(localDir + "\\src\\resources\\transactions.txt", true)); 
            out.write(t.print());
            out.newLine();
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    }
    
    ArrayList<Transaction> readTransactionsFromFile() {
        //Searches through the logs for all transactions with this current user
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
        BufferedReader br = null;
        try {
            String localDir = System.getProperty("user.dir");
            br = new BufferedReader(new FileReader(localDir + "\\src\\resources\\transactions.txt"));
            String line;
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] transaction = line.split(",");

                Transaction t = new Transaction(transaction[0], transaction[1], transaction[2], transaction[3], transaction[4], transaction[5]);
                transactionList.add(t);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return transactionList;

    }
}
