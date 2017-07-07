/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author Ian Tabeling
 */
public interface ViewInterface {
    
    public void display();
    public String getInput();
    public int getOption();
    public void doAction(int option);
    
}
