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
public class Triangle implements Serializable
{
    // Data mmkbers of the class
    private double base;
    private double height;
    
    // default constructor - this constructor does nothing
    public Triangle() {}
    
    // The getWidth method
    // returns the width of the rectangle object
    public double getBase()
    {
        return base;
    }
    
    // The getLength method
    // returns the length of the rectangle object
    public double getHeight()
    {
        return height;
    }
    
    // the setWidth method
    // stores a width value in the object
    public void setBase(double _base)
    {
        base = _base;
    }
    
    // the setLength method
    // stores a length value in the object
    public void setHeight(double _height)
    {
        height = _height;
    }  
    
    // the getArea method
    // calculates and returns the area of the rectangle
    public double getArea()
    {
        return .5 * base * height;
    }
    
}
