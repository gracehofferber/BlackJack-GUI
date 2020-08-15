/*
Grace Hofferber
Jennifer Burg
CSC 111 Project 5
23.4.18

The main class creates the window that the user will see.
 */

package com.company;
import javax.swing.JFrame;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Creates myFrame and its components
       MainFrame myFrame = new MainFrame();
        myFrame.getContentPane().setBackground(Color.lightGray);
       myFrame.setTitle("BlackJack");
        // Terminate program when window closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Resize window to fit components
        myFrame.pack();
        // Display window
        myFrame.setVisible(true);

        return;
    }
 }
