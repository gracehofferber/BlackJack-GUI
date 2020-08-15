/*
Grace Hofferber
Jennifer Burg
CSC 111 Project 5
23.4.18

This class is the Main Frame class and calls the play and draw classes..
 */

package com.company;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private DrawFrame drawFrame;
    private PlayFrame playFrame;

    public MainFrame(){ //conjoins the two frames so the user can see them.
        drawFrame = new DrawFrame();//calls draw frame class
        playFrame = new PlayFrame();//calls play frame class

        setLayout(new GridBagLayout());
        GridBagConstraints layoutConst = new GridBagConstraints();
//setting the size. and layout.
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        layoutConst.insets = new Insets(50,50,50,50);

        add(drawFrame, layoutConst);

        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(50,50,50,50);
        add(playFrame, layoutConst);
        pack();
    }
}
