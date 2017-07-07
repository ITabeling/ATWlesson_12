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
 * @author Ian Tabeling
 */
public abstract class View implements ViewInterface {
    
    private String message;
    
    protected final BufferedReader keyboard = FileIO.getInFile();
    protected final PrintWriter console = FileIO.getOutFile();
    // added the display function 7/7/17
    public void display() {
    String value;
    boolean done = false;
    
    do {
      this.console.println(this.message);// display the prompt message
      value = this.getInput();// get users selection
      done = this.doAction(value);// do action based on selection
    } while (!done);
  }
    
    public View(){
        
    }

    private boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

