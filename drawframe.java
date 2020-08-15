/*
Grace Hofferber
Jennifer Burg
CSC 111 Project 5
23.4.18

This class creates for rectangles in a window and makes them different colors.
 */

package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class DrawFrame extends JPanel{

    public void paintComponent(Graphics g){
        Graphics2D graphicObj = (Graphics2D) g;
        setSize(300,300);
        Rectangle2D.Double checker = new Rectangle2D.Double(0,0,100,100); //creating a rectangle
        graphicObj.setColor(Color.darkGray);
        graphicObj.fill(checker);
        setVisible(true);
        Graphics2D graphicObj2 = (Graphics2D) g;
        setSize(250,250);
        Rectangle2D.Double checker2 = new Rectangle2D.Double(0,0,75,75); //creating a smaller to fit within the previous rectangle
        graphicObj2.setColor(Color.lightGray);
        graphicObj2.fill(checker2);
        setVisible(true);
        Graphics2D graphicObj3 = (Graphics2D) g;
        setSize(200,200);
        Rectangle2D.Double checker3 = new Rectangle2D.Double(0,0,50,50); //creating a smaller to fit within the previous rectangles
        graphicObj3.setColor(Color.darkGray);
        graphicObj3.fill(checker3);
        setVisible(true);
        return;


    }




}
