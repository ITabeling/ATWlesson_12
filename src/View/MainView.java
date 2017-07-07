// The File I/O Project Code
// Created by Roger deBry
// Date last modified: Jule 3, 2017

package View;

import java.util.Scanner;
import Model.*;


public class MainView extends View
{
    private String menu;
    //Assignment says to delete Scanner 
    Scanner keyboard = new Scanner(System.in);
    Rectangle myRectangle = null;
    Circle myCircle = null;
    Triangle myTriangle = null;
    
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
  @Override
    public int getOption()
    {
        int inputValue = 0;
        do
        {
            this.console.println("Enter an option (1-7): ");
            // when trying to run program stops here and line 77 of FileIO
            inputValue = keyboard.nextInt();//Instructions says should be "inputValue = this.keyboard.readLine();
            // changed from (inputValue < 1 || inputValue > 7)
            if(inputValue < 1 || inputValue > 9)
            {
                ErrorView.display(this.getClass().getName(),
                                    "Invalid selection.");
            }
            
        } while(inputValue < 1 || inputValue > 7);
        return inputValue;
    }
    
    // The doAction method
    // executes the code for the selected action
    // ????????????takes int but calls for double???????????
    @Override
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

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private void getExistingObject() {
        this.console.println("\n\nEnter the file pathe for file where the object"
                + "is saved");
        
        String filePath = this.getInput();
    }

    private void saveObject() {
        
        this.console.println("\n\nEnter the file path for file where the object"
                                 +"is to be saved");
        
        String filePath = this.getInput();
        
    }
}
