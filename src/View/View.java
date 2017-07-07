/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import fileio.FileIO;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author IanandJenna
 */
public abstract class View implements ViewInterface {
    
    private String message;
    
    protected final BufferedReader keyboard = FileIO.getInFile();
    protected final PrintWriter console = FileIO.getOutFile();
    
    public View(){
        
    }
    
    
}
