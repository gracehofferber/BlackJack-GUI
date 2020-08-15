/*
Grace Hofferber
Jennifer Burg
CSC 111 Project 5
23.4.18

This class is where the game Black Jack is going to be played and how the window works. There will be a hit me, a stay and a start button which when
the user uses them they will act according to what their button says. Hit me will get the player the card. Stay will not give the player another card
and will do the dealers turn. The start button will start the game and give the player their initial two cards..
 */
package com.company;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.FileWriter;
import java.io.*;


public class PlayFrame extends JPanel implements ActionListener {
    private JButton Stay;
    private JButton hitMe;
    private JButton Start;
    private JTextArea Feedback;
    private JLabel FeedbackLabel;


    //initializing deck
  private  int[] deck = new int[52];
  private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
  private  String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10",
            "10", "10", "10", "11"};
  private  int[] dealerhand = new int[1];
  private   int[] playerhand = new int[1];
  private  int[] playerhand1 = new int[1];
  private  int[] dealerhand1 = new int[1];
  private   int[] playerhit = new int[3];
  private  int[] dealerhit = new int[3];
  private  int playerscore = 0;
  private int dealerscore = 0;

    //initializing deck

    public PlayFrame() {
        GridBagConstraints layoutConst;  // Used to specify GUI component layout

        // Set frame's title
        hitMe = new JButton("Hit me.");
        Stay = new JButton("Stay.");
        Start = new JButton("Start.");
        Feedback = new JTextArea(10, 20);
        Feedback.setEditable(false);
        Feedback.setLineWrap(true);
        Feedback.setWrapStyleWord(true);
        FeedbackLabel = new JLabel("BlackJack Game!");


        // Use a GridBagLayout
        setLayout(new GridBagLayout());

        // Create GridBagConstraints
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        hitMe.setFont(new Font("Papyrus", Font.BOLD, 15));
        hitMe.setBackground(Color.green);
        hitMe.setOpaque(true);
        hitMe.setBorderPainted(false);
        add(hitMe, layoutConst);
        hitMe.addActionListener(this);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        layoutConst.gridy = 0;
        Stay.setFont(new Font("Papyrus", Font.BOLD, 15));
        Stay.setBackground(Color.pink);
        Stay.setOpaque(true);
        Stay.setBorderPainted(false);
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(Stay, layoutConst);
        Stay.addActionListener(this);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        Start.setFont(new Font("Papyrus", Font.BOLD, 15));
        Start.setBackground(Color.orange);
        Start.setOpaque(true);
        Start.setBorderPainted(false);
        layoutConst.insets = new Insets(10, 10, 10, 10);
        add(Start, layoutConst);
        Start.addActionListener(this);


        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        layoutConst.insets = new Insets(10, 10, 10, 10);
        FeedbackLabel.setBackground(Color.lightGray);
        FeedbackLabel.setOpaque(true);
        add(FeedbackLabel, layoutConst);

        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10, 20, 10, 20);
        Feedback.append("Want to play BlackJack?");
        Feedback.append("\n");
        Feedback.append("Rule: Get as close as you can to 21, without going over. Click start and lets begin!");
        Feedback.append("\n");
        add(Feedback, layoutConst);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Feedback.getLineWrap();
        JButton sourceEvent = (JButton) event.getSource();

        if (sourceEvent == hitMe) { //when the hit me button is clicked.
            System.out.println("The 'Hit me' has been clicked!"); //tells programmer the button was clicked.
            if (playerscore < 21) {
                playerhit[0] = Integer.valueOf(values[deck[5] % 13]);
                int newcard = playerhit[0];
                int newplayer = playerscore + newcard;
                playerscore = newplayer;
                Feedback.append("You have been given: " + newcard);
                Feedback.append("\n");
                Feedback.append("The player's cards are: " + playerscore);
                Feedback.append("\n");
                if(playerscore == 21){
                    Feedback.append("Player has blackjack!");
                    Feedback.append("\n");
                    whoWon();
                    return;
                }
                else if (playerscore > 21) {
                    Feedback.append("Player has busted.");
                    Feedback.append("\n");
                } else if (playerscore < 21) { //second round of hit
                    Feedback.append("Would you like to hit or stay?");
                    Feedback.append("\n");

                }


            }//end of players turn.
            if (playerscore == 21) {
                Feedback.append("Player has BlackJack!");
                Feedback.append("\n");
            } else { //dealers turn.
                Feedback.append("It is now the dealers turn.");
                Feedback.append("\n");
                Feedback.append("Dealer's turn:");
                Feedback.append("\n");
                if (dealerscore <= 16) {
                    dealerhit[0] = Integer.valueOf(values[deck[8] % 13]); //gives the dealer another card
                    int newCard = dealerhit[0];
                    int newdealer = dealerscore + newCard;
                    dealerscore = newdealer;
                    Feedback.append("The dealer has been given a: " + newCard);
                    Feedback.append("\n");
                    Feedback.append("The dealer's cards are: " + newdealer);
                    Feedback.append("\n");
                } else {
                    Feedback.append("The dealer's final cards are: " + dealerscore);
                    Feedback.append("\n");
                }
            }
        whoWon();

        }// end of hit me


        else if (sourceEvent == Stay) {//when the stay button is clicked
            Feedback.removeAll();
            System.out.println("The 'Stay' button has been clicked!"); //tells programmer the button was clicked.
            Feedback.append("The player's cards are: " + playerscore);
            Feedback.append("\n");
            Feedback.append("It is now the dealers turn.");
            Feedback.append("\n");

              //dealers turn.
                Feedback.append("It is now the dealers turn.");
                Feedback.append("\n");
                Feedback.append("\n");
                Feedback.append("Dealer's turn:");
                Feedback.append("\n");
                if (dealerscore <= 16) {
                    dealerhit[0] = Integer.valueOf(values[deck[8] % 13]); //gives the dealer another card
                    int newCard = dealerhit[0];
                    int newdealer = dealerscore + newCard;
                    dealerscore = newdealer;
                    Feedback.append("The dealer has been given a: " + newCard);
                    Feedback.append("\n");
                    Feedback.append("The dealer's cards are: " + newdealer);
                    Feedback.append("\n");
                } else {
                    Feedback.append("The dealer's final cards are: " + dealerscore);
                    Feedback.append("\n");
                }
            whoWon();
        }// end of stay.

        else if (sourceEvent == Start) { //When the start button is clicked.
            System.out.println("The 'Start' button has been clicked!"); //Tells programer that the start button has been clicked. (Doesn't show up in the game window)
            startGame();
            Feedback.append("\n");
            System.out.println("Players Turn.");
            Feedback.append("The Player's cards are: " + playerscore);
            Feedback.append("\n");
            Feedback.append("Would you like to hit or stay?");
            Feedback.append("\n");
        } //end of start.

    } //end of actionListener.

    public void startGame(){
        for (int i = 0; i < deck.length; i++) {//initializing cards
            deck[i] = i;
        }
        for (int j = 0; j < deck.length; j++) {
            //shuffles.
            int index = (int) (Math.random() * deck.length);//randomizes cards
            int temp = deck[j];
            deck[j] = deck[index];
            deck[index] = temp;
        }
        dealerhand[0] = Integer.valueOf(values[deck[0] % 13]);
        dealerhand1[0] = Integer.valueOf(values[deck[2] % 13]);
        dealerscore = (dealerhand1[0] + dealerhand[0]);

        playerhand[0] = Integer.valueOf(values[deck[1] % 13]);
        playerhand1[0] = Integer.valueOf(values[deck[3] % 13]);
        playerscore = (playerhand1[0] + playerhand[0]);

    }
    public void whoWon() {
        if (dealerscore < 21 && playerscore < 21 || dealerscore == 21) {
            if (dealerscore > playerscore) {
                Feedback.append("The dealer has won!");
                Feedback.append("\n");
            } else if (playerscore > dealerscore || playerscore == 21) {
                Feedback.append("The player has won!");
                Feedback.append("\n");
            } else if (playerscore > 21 && dealerscore > 21) {
                Feedback.append("Both have busted.Tie!");
                Feedback.append("\n");
            }
        } else if (playerscore > 21 && dealerscore <= 21) {
            Feedback.append("The dealer has won!");
            Feedback.append("\n");
        } else if (dealerscore > 21 && playerscore <= 21) {
            Feedback.append("The player has won!");
            Feedback.append("\n");
        } else if (playerscore == dealerscore) {
            Feedback.append("Tie.");
            Feedback.append("\n");
        }
        Feedback.append("\n");
        Feedback.append("Would you like to play again? Click start?");
        Feedback.append("\n");
    }


    }



