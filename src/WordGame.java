import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGame {
    
    char[] letters;
    private ArrayList<String> dictionary;
    private ArrayList<String> finalWords;
    private ArrayList<String> newWords;
    
    public WordGame(String filename) {
        dictionary = new ArrayList<String>();
        finalWords = new ArrayList<String>();
        letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        
        String word = "";
        
        try(Scanner inFile = new Scanner(new File(filename))) {
            while(inFile.hasNextLine()) {
                word = inFile.nextLine();
                dictionary.add(word);
            }
        }
        
        catch(FileNotFoundException e) {
            System.out.println("There was a problem opening the file.");
            System.exit(0);
        }
    }
    
    public boolean transformation(String start, String end, int steps) {
        if(start.equals(end)) {
            return true;
        }
        
        if(steps == 0) {
            return false;
        }
        
        ArrayList<String> changedWords = changeLetter(start);
        
        for(int i = 0; i < changedWords.size(); i++) {
            if(transformation(changedWords.get(i), end, steps - 1)) {
                finalWords.add(0, changedWords.get(i));
                return true;
            }
        }
        
        return false;
    }
    
    public void printList(String start, String end, int steps) {
        boolean ifPossible = transformation(start, end, steps);
        
        if(ifPossible) {
            finalWords.add(0, start);
            
            for(int i = 0; i < finalWords.size() - 1; i++) {
                System.out.print(finalWords.get(i) + " -> ");
            }
            
            System.out.println(finalWords.get(finalWords.size() - 1));
        }
        
        else {
            System.out.println("This is impossible.");
        }
    }
    
    public ArrayList<String> changeLetter(String word) {
        newWords = new ArrayList<String>();
        
        String newWord = "";
        
        for(int i = 0; i < word.length(); i++) {
            for(int j = 0; j < letters.length; j++) {
                newWord = word.substring(0, i) + letters[j] + word.substring(i + 1, word.length());
                
                if(dictionary.contains(newWord) && !newWord.equals(word)) {
                    newWords.add(newWord);
                }
            }
        }
        
        return newWords;
    }
}
