/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csc4380;

import java.beans.*;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aaron
 */
public class DatabaseBean implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private String sampleProperty;
    
    private PropertyChangeSupport propertySupport;
    
    private Connection con;
    private java.sql.Statement st;
    private ResultSet rs;
    private String  jdbc_drivers = "com.mysql.jdbc.Driver";
    
    
    public DatabaseBean() {
        propertySupport = new PropertyChangeSupport(this);
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
    
    public void setNativeCountry(String s, String currUser)
    {
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3db", "root", "trailblazers");
            st = con.createStatement();
            st.executeUpdate("UPDATE user_info SET nativeCountry = '"+s+"' WHERE username = '"+currUser+"'");

            //if (rs.next()) {
            //    System.out.println(rs.getString(1));
            //}

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Exception Caught");
               
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
    }
    
    
    public double getExchangeRate(String rate)
    {
        double x = 1;
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3db", "root", "trailblazers");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM exchange_rates1 WHERE Currency_name = '"+rate+"'");

            if (rs.next()) {
                System.out.println(Double.parseDouble(rs.getString(3)));
                x = Double.parseDouble(rs.getString(3));
            }

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Exception Caught");
               
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
        return x;
    }

    
    public String createUser(String uName, String password)
    {
        String tempStatus = "";
         try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3db", "root", "trailblazers");
            st = con.createStatement();
            st.executeUpdate("INSERT INTO user_info (username, password, nativeCountry, lastConversion) VALUES ('"+uName+"', '"+password+"', 'US', 'EURO')");
            tempStatus ="signup success";
            

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               tempStatus = "signup failed";
               
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
         return tempStatus;
    }
    
    
    public String login(String uName, String password, Model m)
    {
        String tempStatus = "";
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3db", "root", "trailblazers");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM user_info WHERE username = '"+uName+"' AND password = '"+password+"'");

            if (rs.next()) {
                m.setCurrent_user(rs.getString(1));
                m.setCurrent_native(rs.getString(3));
                m.setCurrent_lastConver(rs.getString(4));
                tempStatus ="login success";
            } else {
                tempStatus = "login failed";
            }

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               tempStatus = "login failed";
               
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
        return tempStatus;
    }
    
    
    String setLastConversion(String currency, String currentUser)
    {
        String tempStatus = "";
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3db", "root", "trailblazers");
            st = con.createStatement();
            if(!currentUser.equals(""))
                st.executeUpdate("UPDATE user_info SET lastConversion = '"+currency+"' WHERE username = '"+currentUser+"'");


        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               tempStatus = "login failed";
               
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
        return tempStatus;
    }

    String deleteUser(String currentUser) {
        String tempStatus = "";
        try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3db", "root", "trailblazers");
            st = con.createStatement();
            st.executeUpdate("DELETE FROM user_info WHERE username = '"+currentUser+"'");


        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               tempStatus = "signup failed";
               
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
        return tempStatus;
    }

String getCurrency(String n){
    try {
            System.setProperty("jdbc.drivers", jdbc_drivers);
 
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project3db", "root", "trailblazers");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM country_info WHERE Country_name = '"+n+"'");

            if (rs.next()) {
                return rs.getString(2);
            } else {
                return "US Dollar";
            }

        } catch (SQLException ex) {
            //Logger lgr = Logger.getLogger(Version.class.getName());
            //lgr.log(Level.SEVERE, ex.getMessage(), ex);
               Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
               //setStatus("login failed");
               
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
               // Logger lgr = Logger.getLogger(Version.class.getName());
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
                //lgr.log(Level.WARNING, ex.getMessage(), ex);
                            }
        }
        return "US Dollar";
  }
    
}
