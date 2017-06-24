import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by khalidsaid on 23.06.17.
 * Just a simple Anagram assignment that was assesed by Finn.no and I got sent this task by a friend. So
 * I wanted to try and solve it my way :)
 *
 */
public class Anagram {
    private Scanner scr;
    private ArrayList<String> list = new ArrayList<>();

    /**
     * A method that reads the entire file and puts every word in a ArrayList.
     */
    public void readFile() {
        try {
            scr = new Scanner(new File("ang.txt"));

            while (scr.hasNextLine()) {
                String word = scr.next();
                list.add(word);
            }
            scr.close();

        } catch (Exception ex) {
            System.out.println("Error Message: " + ex.getMessage());
        }

    }

    /**
     * I created a simple method that allows me to find the length of each word in the ArrayList, so that
     * I can check them if maybe these two words are an anagram.
     */

    public void checkLength() {

        for (int i = 0; i < list.size(); i++) {
             String firstword  = list.get(i);

            for (int k = 1; k < list.size(); k++) {
                 String secondword = list.get(k);


                if (firstword.length() == secondword.length()){
                    checkAnagram(firstword, secondword);

                }

            }
        }


    }

    /**
     *  In this method i'm checking if the both words that was sent from checkLenght method
     *  are really indeed anagrams of eachother. If they are then the method will print the words
     *  in to the terminal.
     *
     */
    
    public void checkAnagram(String firstword, String secondword){
        int count = 0;

        for (int i = 0; i < firstword.length(); i++){

            for (int k = 0; k < firstword.length(); k++){

                if (firstword.charAt(i) == secondword.charAt(k) && firstword != secondword) {
                   count++;

                   if (count == firstword.length() ){
                       list.remove(secondword);
                       System.out.println(firstword + " - " + secondword);
                   }
                }



            }

        }

    }

   //
    public void run(){
        readFile();
        checkLength();
    }

    public static void main(String[] args) {
        Anagram a = new Anagram();
        a.run();
    }
}
