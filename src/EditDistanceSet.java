import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Class to do the Edit Distance algorithm based on a HashSet
 */
public class EditDistanceSet {
    
    private final char[] LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private HashSet<String> dictionary = new HashSet<>();
    private ArrayList<String> finalWords = new ArrayList<>();
    
    /**
     * Instantiates a new Edit Distance.
     *
     * @param filename the filename for the dictionary
     */
    public EditDistanceSet(String filename) {
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
    
    /**
     * Is the letter replacing a valid transformation
     *
     * @param start the current word
     * @param end   the potential next word in the sequence
     * @param steps the number of steps left
     *
     * @return the boolean
     */
    public boolean isValidTransformation(String start, String end, int steps) {
        if(start.equals(end)) {
            return true;
        }
        
        if(steps == 0) {
            return false;
        }
        
        ArrayList<String> changedWords = changeLetter(start);
        
        for(String changedWord : changedWords) {
            if(isValidTransformation(changedWord, end, steps - 1)) {
                finalWords.add(0, changedWord);
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Change letter in the String
     *
     * @param word the word
     *
     * @return the list of words in the dictionary that are a letter off from 'word'
     */
    public ArrayList<String> changeLetter(String word) {
        ArrayList<String> newWords = new ArrayList<>();
        
        String newWord = "";
        
        for(int i = 0; i < word.length(); i++) {
            for(char letter : LETTERS) {
                newWord = word.substring(0, i) + letter + word.substring(i + 1);
                
                if(dictionary.contains(newWord) && !newWord.equals(word)) {
                    newWords.add(newWord);
                }
            }
        }
        
        return newWords;
    }
    
    /**
     * Determines if the supplied input is valid and if so, prints list
     *
     * @param start the current word
     * @param end   the potential next word in the sequence
     * @param steps the number of steps left
     */
    public void printList(String start, String end, int steps) {
        finalWords = new ArrayList<>();
        boolean ifPossible = isValidTransformation(start, end, steps);
        
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
}
