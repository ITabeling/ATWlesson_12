/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;
import View.ErrorView;
import View.MainView;   // import the MainView class
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.console;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileIO
{
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
      try{
          //open character stream files for end user input and output
          FileIO.inFile = new BufferedReader(new InputStreamReader(System.in));
          FileIO.outFile = new PrintWriter(System.out, true);
      
   
          // open log file
          String filePath = "log.txt";
          FileIO.logFile = new PrintWriter(filePath);
 
          //create StartProgramView and start the game
         /*StartProgramView startProgramView = new StartProgramView();
         startProgramView.display();
         return;*/
      }  catch (Throwable e){
          
               System.out.println("Exception:" + e.toString() + 
                                   "\nCause:" + e.getCause() +
                                    "\nMessage:" + e.getMessage());
               
               e.printStackTrace();;
      }
        finally {
          try {
              if (FileIO.inFile != null)
              FileIO.inFile.close();
              
              if (FileIO.outFile != null)
              FileIO.outFile.close();
              
              if (FileIO.logFile != null)
              FileIO.logFile.close();
          } catch (IOException ex) {
              System.out.println("Error closing files");
        
              return;
          }
            
      }
        MainView mmv = new MainView();
        int option = 0;
        do
        {
            mmv.displayMenu();
            option = mmv.getOption();
            if (option != 7)
            {
                mmv.doAction(option);
            }
        } while (option != 7);
        
    }
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        FileIO.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        FileIO.inFile = inFile;
    }
    
    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        FileIO.logFile = logFile;
    }
}
