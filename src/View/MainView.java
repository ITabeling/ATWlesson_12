// The File I/O Project Code
// Created by Roger deBry
// Date last modified: Jule 3, 2017

package View;

import java.util.Scanner;
import Model.*;
import fileio.FileIO;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;


public class MainView 
{
    private String menu;
    private String string;
    //Assignment says to delete Scanner 
    //commented out Scanner keyboard per instructions 
    //Scanner keyboard = new Scanner(System.in);
    Rectangle myRectangle = null;
    Circle myCircle = null;
    Triangle myTriangle = null;
    
    
    BufferedReader keyboard = FileIO.getInFile();
    PrintWriter console = FileIO.getOutFile();
    // The constructor - initializes the menu
    public MainView()
    {
        menu = "\n"
             + "\n 1 - Create a Rectangle Object"
             + "\n 2 - Create a Circle Object"
             + "\n 3 - Create a Triangle Object"
             + "\n 4 - Display the Rectangle Object"
             + "\n 5 - Display the Circle Object"
             + "\n 6 - Display the Triangle Object"
             + "\n 7 - Quit"
             + "\n 8 - Get saved Object"
             + "\n 9 - Save Object";
    }
    
    // The displayMenu method
    // outputs the menu
    public void displayMenu()
    {
        this.console.println(menu);
    }
    
    // The getOption method
    // Gets the user's input and returns it
    // Will loop until there is a valid choice
 
    public int getOption() throws IOException
    {
        int inputValue = 0;
        do
        {   // I honnestly have no idea what to do with lines 66-67??
            this.console.println("Enter an option (1-9): ");
            // when trying to run program stops here and line 78 of FileIO
            inputValue = Integer.parseInt(string);//Instructions says should be "inputValue = this.keyboard.readLine();
           string = keyboard.readLine();
            // changed from (inputValue < 1 || inputValue > 7)
            if(inputValue < 1 || inputValue > 9)
            {
                ErrorView.display(this.getClass().getName(),
                                    "Invalid selection.");
            }
      // changed from (inputValue < 1 || inputValue > 7)  
        } while(inputValue < 1 || inputValue > 9);
        return inputValue;
    }
    
    // The doAction method
    // executes the code for the selected action
    // ????????????takes int but calls for double???????????
    public void doAction(int option)
    {
        switch(option)
        {
            
            case 1:
            // create a Rectangle object if one has not been created
                if(myRectangle == null)
                {
                    this.console.println("Creating a Rectangle object.");
                    this.console.println("Please input the width of your rectangle: ");
                    double wide = keyboard.nextDouble();
                    this.console.println("Please enter the length of your rectangle: ");
                    double len = keyboard.nextDouble();
                    
                    myRectangle = new Rectangle( );
                    myRectangle.setWidth(wide);
                    myRectangle.setLength(len);//??len or length????
                }
                else
                {
                    ErrorView.display(this.getClass().getName(),
                            "\nA rectangle object has already been created.");
                }
                break;
            case 2:
             // create a Circle object if one has not been created
                if(myCircle == null)
                {
                    this.console.println("Creating a Circle object.");
                    this.console.println("Please input the radius of your circle: ");
                    double wide = keyboard.nextDouble();
                    
                    myCircle = new Circle( );
                    myCircle.setRadius(wide);
                }
                else
                {
                    ErrorView.display(this.getClass().getName(),
                            "\nA circle object has already been created.");
                }
                break; 
            case 3:
                // create a Triangle object if one has not been created
                if(myTriangle == null)
                {
                    this.console.println("Creating a Triangle object.");
                    this.console.println("Please input the base of your triangle: ");
                    double base = keyboard.nextDouble();
                    this.console.println("Please enter the height of your triangle: ");
                    double height = keyboard.nextDouble();
                    
                    myTriangle= new Triangle( );
                    myTriangle.setBase(base);
                    myTriangle.setHeight(height);
                }
                else
                {
                    ErrorView.display(this.getClass().getName(),
                            "\nA triangle object has already been created.");
                }
                break;
            case 4:
                if(myRectangle != null)
                {
                    this.console.println("Here is your rectangle. ");
                    this.console.println("It is " + myRectangle.getWidth() + " units wide.");
                    this.console.println("It is " + myRectangle.getLength() + " units long.");
                    this.console.println("The rectangle has an area of " + myRectangle.getArea() + " square units"); 
                }
                else
                {
                    ErrorView.display(this.getClass().getName(),
                            "No rectangle has been created yet.");
                }
                break;
            case 5:
                if(myCircle != null)
                {
                    this.console.println("Here is your circle. ");
                    this.console.println("Its radius is " + myCircle.getRadius() + " units.");
                    this.console.println("The circle has an area of " + myCircle.getArea() + " square units"); 
                }
                else
                {
                    ErrorView.display(this.getClass().getName(),
                            "No cicle has been created yet.");
                }
                break; 
            case 6:
                if(myTriangle != null)
                {
                    this.console.println("Here is your triangle. ");
                    this.console.println("It is " + myTriangle.getBase() + " units wide.");
                    this.console.println("It is " + myTriangle.getHeight() + " units high.");
                    this.console.println("The triangle has an area of " + myTriangle.getArea() + " square units"); 
                }
                else
                {
                    ErrorView.display(this.getClass().getName(),
                            "No triangle has been created yet.");
                }
                break;
            
            case 7:        
            break; 
            
            case 8 : // get existing object
                this.getExistingObject();
                break;
                
            case 9 : // save the current object
                this.saveObject();
                break;
        }
    }

    

    // this code is pulled from page 25 (startSavedGame())
    private void getExistingObject() {
        this.console.println("\n\nEnter the file pathe for file where the object"
                + "is saved");
        // should go away after adding control code from assignment
        //commented out (I think this is in wrong location??)
        String filePath = this.getInput();
        
        try {
            //get an existing object
            MainView.getSavedObject(filePath);
           
        } catch (Exception ex) {
            ErrorView.display("MainView", ex.getMessage());
        }
        
        //display menu (I don't think we need this code or it needs modified)
        MainView menu = new MainView();
        menu.displayMenu();
    }

    private void saveObject() {
        
        this.console.println("\n\nEnter the file path for file where the object"
                                 +"is to be saved");
        String filePath = this.getInput();
        
        try {
            MainView.saveObject(FileIO.getExisitingObject(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainView", ex.getMessage());
            
        }
        /*why is there a second one of these
        String filePath = this.getInput();
        // Instructions say to implement the Control Layer function (we dont have one)
        */    
}        
    /*commented out (this code is from page 27 has issue with lines
    227 and 233 (MainViewException wants to create new class
    
                 // assignment has Game game (does not work???)
    public static void saveGame(MainView object, String filepath)
            throws MainViewException {
        try( FileOutputStream fops = new FileOutputStream(filepath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);
            output.writeObject(object);
        }
        catch(Exception e){
            throw new MainViewException(e.getMessage());
        }
    }*/
     // this block has an issue with MainViewException (wants to create class)
    // errors on lines 253 and 262 (this code is from page 26)
    public static void getSavedObject(String filepath) {
                    //throws MainViewException
                            MainView object = null;
        
        try( FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            object = (MainView) input.readObject();
        }
        catch(Exception e) {
            //throw new MainViewException(e.getMessage());
        }
    //FileIO.setCurrentObject(object);
}

    private String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
