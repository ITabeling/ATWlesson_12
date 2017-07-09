// The File I/O Project Code
// Created by Roger deBry
// Date last modified: Jule 3, 2017

package View;

import Model.*;
import fileio.FileIO;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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
    
    
    private static BufferedReader keyboard = FileIO.getInFile();
    private static PrintWriter console = FileIO.getOutFile();
    private static PrintWriter logFile = null;

            
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
             + "\n 9 - Save Object"
             + "\n 10 - Rectangle Report";
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
            console.println("Enter an option (1-10): ");
            // when trying to run program stops here and line 78 of FileIO
            string = keyboard.readLine();
            inputValue = (int) Double.parseDouble(string);//Instructions says should be "inputValue = this.keyboard.readLine();
            
           
            // changed from (inputValue < 1 || inputValue > 7)
            if(inputValue < 1 || inputValue > 10)
            {
                ErrorView.display(this.getClass().getName(),
                                    "Invalid selection.");
            }
      // changed from (inputValue < 1 || inputValue > 7)  
        } while(inputValue < 1 || inputValue > 10);
        return inputValue;
    }
    
    // The doAction method
    // executes the code for the selected action
    // ????????????takes int but calls for double???????????
    public void doAction(int option) throws IOException
    {
        switch(option)
        {
            
            case 1:
            // create a Rectangle object if one has not been created
                if(myRectangle == null)
                {
                    console.println("Creating a Rectangle object.");
                    console.println("Please input the width of your rectangle: ");
                    String width = keyboard.readLine();
                    double wide = Double.parseDouble(width);
                    console.println("Please enter the length of your rectangle: ");
                    String length = keyboard.readLine();
                    double len = Double.parseDouble(length);
                  
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
                    console.println("Creating a Circle object.");
                    console.println("Please input the radius of your circle: ");
                    String radius = keyboard.readLine();
                    double rad = Double.parseDouble(radius);
                    
                    myCircle = new Circle( );
                    myCircle.setRadius(rad);
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
                    console.println("Creating a Triangle object.");
                    console.println("Please input the base of your triangle: ");
                    String bas = keyboard.readLine();
                    double base = Double.parseDouble(bas);
                //    double base = keyboard.nextDouble();
                    console.println("Please enter the height of your triangle: ");
                    String ht = keyboard.readLine();
                    double height = Double.parseDouble(ht);
                //    double height = keyboard.nextDouble();
                    
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
                    console.println("Here is your rectangle. ");
                    console.println("It is " + myRectangle.getWidth() + " units wide.");
                    console.println("It is " + myRectangle.getLength() + " units long.");
                    console.println("The rectangle has an area of " + myRectangle.getArea() + " square units"); 
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
                    console.println("Here is your circle. ");
                    console.println("Its radius is " + myCircle.getRadius() + " units.");
                    console.println("The circle has an area of " + myCircle.getArea() + " square units"); 
                }
                else
                {
                    ErrorView.display(this.getClass().getName(),
                            "No circle has been created yet.");
                }
                break; 
            case 6:
                if(myTriangle != null)
                {
                    console.println("Here is your triangle. ");
                    console.println("It is " + myTriangle.getBase() + " units wide.");
                    console.println("It is " + myTriangle.getHeight() + " units high.");
                    console.println("The triangle has an area of " + myTriangle.getArea() + " square units"); 
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
            
            case 10 : // print the Rectangle Report
                this.rptRectangle();
                break;
        }
    }

    

    // this code is pulled from page 25 (startSavedGame())
    private void getExistingObject() {
        console.println("\n\nEnter the file path for file where the object"
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
        console.println("\n\nEnter the file path for file where the object"
                                 +"is to be saved");
        String filePath = this.getInput();    
        
        try {
        // save the object to the specified file
        MainView.saveObject(FileIO.getExistingObject(), filePath);
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
        
        try(FileInputStream fips = new FileInputStream(filepath)) {
            ObjectInputStream input = new ObjectInputStream(fips);
            
            object = (MainView) input.readObject();
        }
        catch(Exception e) {
            //throw new MainViewException(e.getMessage());
            
        }
    //FileIO.setCurrentObject(object);
}

    private String getInput() {
        System.out.println("Invalid input");
        return null;
    } 

    private void rptRectangle() {
        System.out.println("Rectangle Report not available");
    }

    public MainView (String[] args) {
        try {
            // open character streams for input and output
            FileIO.inFile = new BufferedReader(new InputStreamReader(System.in));
            FileIO.outFile = new PrintWriter(System.out, true);
            
            // request log file path from user
            console.println("\n\nEnter the file path for file where the report"
                                 +"is to be saved");
            String rectLog = this.getInput();
            
            //open log file for Rectangle
            String filePath = rectLog;
            FileIO.logFile = new PrintWriter (filePath);
            
        } catch (Exception e) {
            System.out.println("Exception:  " + e.toString() +
                               "\nCause:  " + e.getCause() +
                               "\nMessage:  " + e.getMessage());
            e.printStackTrace();
    }
        finally {
            try {
                if (FileIO.inFile != null)
                    FileIO.inFile.close();
                if (FileIO.outFile != null)
                    FileIO.outFile.close();
                if (FileIO.logFile != null)
                    FileIO.logFile.close();
            }catch (IOException ex) {
                ErrorView.display(this.getClass().getName(),"Error closing files." + ex.getMessage());
                return;
            }
        }
    }
    
    /**
     *
     * @param dimensions
     * @param outputLocation
     */
    public void printRectangleReport(Rectangle dimensions,String outputLocation){
        
        // create BufferReader object for inout file
        try (PrintWriter out = new PrintWriter(logFile)) {
            
            // print title and column headings
            out.println("\n\n           My Rectangle Report          ");
            out.printf("%n%-20s%10s%10s", "Width", "Length", "Area");
            out.printf("%n%-20s%10s%10s", "-----", "------", "----");
            
            // print the dimensions of the rectangle
            for (Rectangle : dimensions) {
                out.printf("%n%-20s%10s%10s", myRectangle.getWidth(),
                                              myRectangle.getLength(), 
                                              myRectangle.getArea());
            }
            console.printf("\nCongratulations on a successful print!");
        
    }
    
    }
}
