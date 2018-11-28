
package csc4380;

//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.SQLException;

/**
 *This is the controller class, which is responsible for creating the methods that
 * are called when the components in the view class are selected, and communicating with the 
 * model class to pull user info, country info, and exchange rates.
 */
public class Controller {
    
    private static Model m;
    
    //Constructor for Model class. It is passed in an instance of the model, so it 
    //able to communicate with the database
    public Controller(Model model)
    {
        m = model;
    } 

    //This method gets the value in the left textbox and converts it to USD, and then it takes 
    //The value in USD and converts it to the currency from the right drop down.
    public void btnConvert(View v)
    {
    	// At this point can I distinguish between english and spanish? q
    	System.out.println("Convert Button");
    	
        double leftVal = convertToUSD(Double.parseDouble(v.getLeftText()), v.getLeftDropDown());
        System.out.println(leftVal);
        double rightVal = convertToNewCurrency(leftVal, v.getRightDropDown());
        System.out.println(""+rightVal);
        v.setRightVal(""+rightVal);
        m.setLastConversion(v.getRightDropDown());
        v.updateConver(v.getRightDropDown());
    }
    
    
    //Sets every text box to "", to reset the screen when clear is selected
    public void btnClear (View v)
    {
        v.setLeftVal("");
        v.setRightVal("");
    }
    
    
    //This method takes the values of the two drop down's and swaps them with each other
    public void btnSwap(View v)
    {
        String temp = v.getRightDropDown();
        v.setRightDropDown(v.getLeftDropDown());
        v.setLeftDropDown(temp);
    }
    
    //This method takes the user preference for country and writes it to the database
    public void btnEditProf(View v) {
        m.setNative(v.country);
    }
    
   
    
    //this method creates a user in the database based on the username and password in the view,
    //And then it set's the user's status in the view class to the value of status in the model class.
    public void btnSignup(View v)
    {
        m.createUser(v.getSignUpUser(), v.getSignUpPass());
        v.setStatus(m.getStatus());
        m.setNative(v.getCountry());
        
    }
    
    //This method calls the login method located in the model class and passes in the 
    //username and password from the view class. After setting the status, it checks to 
    //verify that login was successful; if it was, then it tells the view class to unlock
    //the profile tab
    public void btnLogin(View v)
    {
        m.login(v.getLoginUser(), v.getLoginPass());
        v.setStatus(m.getStatus());
        if(m.getStatus().equals("login success")) {
            v.unlockProfile();
            v.loadUserInfo(m.getUserInfo());
            v.setLeftDropDown(m.getCurrency());
        } else
            v.lockProfile();
    }
    
    
    
    //This is helper method for this class, which takes in a value of currency
    //rate and converts that value to USD and returns the result.
    private double convertToUSD(double d, String rate)
    {
        double xchgRate = m.getExchangeRate(rate);
        return d*xchgRate;
    }
    
    //This is a helper method for this class, which takes in a value of currency
    //in USD and converts it to currency rate
    private double convertToNewCurrency(double d, String rate)
    {
        //The following method should return exch rate to go from USD to "rate"
        double xchgRate = 1/m.getExchangeRate(rate);
        return d*xchgRate;
    }
    
    public void btnDelete(View v) {
        m.deleteUser();
        //v.goHome();
    }


    
}
