/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

// The Rectangle class
// Represents two dimensional rectangle objects
// This is a JavaBean class
public class Rectangle implements Serializable
{
    // Data mmkbers of the class
    private double width;
    private double length;
    
    // default constructor - this constructor does nothing
    public Rectangle() {}
    
    // The getWidth method
    // returns the width of the rectangle object
    public double getWidth()
    {
        return width;
    }
    
    // The getLength method
    // returns the length of the rectangle object
    public double getLength()
    {
        return length;
    }
    
    // the setWidth method
    // stores a width value in the object
    public void setWidth(double _width)
    {
        width = _width;
    }
    
    // the setLength method
    // stores a length value in the object
    public void setLength(double _length)
    {
        length = _length;
    }  
    
    // the getArea method
    // calculates and returns the area of the rectangle
    public double getArea()
    {
        return length * width;
    }
    
}
