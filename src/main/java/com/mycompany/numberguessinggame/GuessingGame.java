/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.numberguessinggame;
import java.io.*;
import java.util.Random;
import java.util.Arrays;

/**
 * This is a number guessing game.
 * @author Benjamin Bowen
 */
public class GuessingGame {
    
    public static void main(String[] args) {
        
        giveIntro(); // give intro
        if (playOrNot() == 1) { // you must accept to play
            playTheGame(); // play the game
        }
        
    } // end of main()
    
    /**
     * Give the introduction to the number guessing game.
     */
    public static void giveIntro() {
        
        System.out.println("NUMBER GUESSING GAME");
        System.out.println("--------------------");
        System.out.println(" - The random number is in [1, 20]");
        System.out.println(" - Enter your guess");
        System.out.println(" - See if your guess is too high or too low");
        System.out.println(" - Then change your guess");
        System.out.println(" - The computer will tell you how many attempts");
        System.out.println("   you took to guess the number");
        
    } // end of giveIntro()
    
    public static int playOrNot() {
        
        int number = 0;
        System.out.println("Enter 1 to play. Enter 2 to exit.");
        
        try {
        
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String response = r.readLine();
            
            if (response.equals("1")) {
                number = 1;
            } else if (response.equals("2")) {
                number = 2;
            } else {
                
                System.out.println("Error: Please give a valid input.");
                playOrNot(); // redo the playOrNot() prompt and process
                
            }
            
        } catch(IOException ioe) {
            System.err.println("Input Output Exception");
            return 0;
        } // end of try and catch
        
        return number;
        
    } // end of playOrNot()
    
    public static void playTheGame() {
        
        Random random = new Random();
        int randomNumber = random.nextInt(20) + 1; // random integers from 0 to 19, plus 1
        String yourGuess = "0"; // start your guess at something 100% wrong
        int attempts = 1; // start at 1 attempt
        int yourGuessToInt = 0;
        
        try {
            
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            
            while (yourGuessToInt != randomNumber) { // while your guess != random number
                
                System.out.println("Enter your guess (or q for quit)");
                yourGuess = r.readLine(); // get your guess
                
                if (yourGuess.equals("q")) { // if you want to quit
                    
                    System.out.println("You quit after " + attempts + " attempt(s). The random number is " + randomNumber + ".");
                    break;
                    
                }
            
                try {
                    
                    yourGuessToInt = Integer.parseInt(yourGuess.trim());
                    
                    if (yourGuessToInt == randomNumber) { // equal
                        System.out.println("Bingo! It took you " + attempts + " attempt(s) to guess the number.");
                    } else if (yourGuessToInt > randomNumber && yourGuessToInt < 20) { // too high, in range
                        System.out.println("Your guess of " + yourGuess + " is too high.");
                    } else if (yourGuessToInt > 20 || yourGuessToInt < 1) { // out of range
                        System.out.println("Your guess of " + yourGuess + " is out of range. It must be in [1, 20].");
                    } else { // too low, in range
                        System.out.println("Your guess of " + yourGuess + " is too low.");
                    } // end of if statement
                    
                } catch(NumberFormatException nfe) {
                    System.err.println("Number Format Exception");
                } // end of try and catch
                
                attempts++;
                
            } // end of while loop
            
        } catch(IOException ioe) {
            System.err.println("Input Output Exception! ");
        } // end of try and catch
        
    } // end of playTheGame()
    
} // end of class