//This is the driver class that is reponsible for creating the instances of our
//Model, View, and Controller
package csc4380;

public class Driver {
    public static void main(String[] args)
    {
        Model m = new Model();
        Controller c = new Controller(m);
        View v = new View(c);
    }
}
