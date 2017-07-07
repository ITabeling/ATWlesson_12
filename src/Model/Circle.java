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
public class Circle implements Serializable
{
    // Data mmkbers of the class
    private double radius;

    
    // default constructor - this constructor does nothing
    public Circle() {}
    
    // The getWidth method
    // returns the width of the rectangle object
    public double getRadius()
    {
        return radius;
    }
    
    // the setRadius method
    // stores a width value in the object
    public void setRadius(double _radius)
    {
        radius = _radius;
    }
    
    // the getArea method
    // calculates and returns the area of the object
    public double getArea()
    {
        return Math.PI * radius * radius;
    }    
    
}
