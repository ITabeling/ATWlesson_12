/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import fileio.FileIO;
import java.io.PrintWriter;

/**
 *
 * @author Ian Tabeling
 */
public class ErrorView 
{
    
    private static final PrintWriter errorFile = FileIO.getOutFile();
    private static final PrintWriter logFile = FileIO.getLogFile();

    public static void display(String className, String errorMessage) {
        
        errorFile.println(
                  "----------------------------------------------"
                  + "\n- ERROR -" + errorMessage
                  + "\n-------------------------------------------");
        
         // log error
         logFile.println(className + " - " + errorMessage);
    }
}
