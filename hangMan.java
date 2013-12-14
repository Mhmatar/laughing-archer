import javax.swing.JOptionPane;

import java.util.*;

public class hangMan               // This is a very simple hang man game. 
                                   //User is prompted to enter the Difficulty Level. A random word of the selected collection will be picked
                                   // User to guess the word
{
    public static void main (String a [])

    {

        String word = null;
        int wrongGuess;
        String wordCollection [][] = {
        		
        		  {"knife", "spoon", "fork", "Plate"},

                { "associate", "captivate", "refactoring" },

                };
 
        String level = JOptionPane.showInputDialog ("Select Level : 1 for BEGINNER,2 for ADVANCED");
        
        int intLevel = Integer.parseInt(level);
        if(intLevel > wordCollection.length)

        {
            System.out.println("Please enter a valid Level :1 for BEGINNER,2 for ADVANCED");

            return;

        }

        String pickedArray[] = wordCollection[intLevel];

        String[] difficultyMsg = {"Beginner Level : Let's Start!", "Advanced Level : Let's Start!"};

        System.out.println(difficultyMsg[intLevel]);
        
        Collections.shuffle( Arrays.asList ( pickedArray ));
        
                           word = pickedArray[ (int) Math.random() * pickedArray.length];

        char[] hidden = new char[word.length()];

        for(int i = 0; i < word.length(); i++)

            hidden[i] = '_';

        char[] digit = word.toCharArray();


        Scanner letterProvided = new Scanner(System.in);

        wrongGuess = 0;

        do {


            System.out.print("The word is : ");

            for(int i = 0; i < word.length(); i++)

                System.out.print(hidden[i]);

  
            System.out.print("\nPlease enter a letter: ");


            String letter = letterProvided.nextLine().toLowerCase();

            char guess = letter.charAt(0);

            boolean correctGuess = false;

    
            for(int j = 0; j < word.length(); j++)

            {

             

                if(guess == digit[j])

                {

                 
                    hidden[j] = guess;

            
                  correctGuess = true; 
                  
                    if ( j== word.length())
                    	
                    { System.out.print("Good Job! You Guessed it right!");}

                }

            }

            if(!correctGuess)

                wrongGuess++;

        }   while(wrongGuess < 5);   

    }

}
