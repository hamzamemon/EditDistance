/**
 * The main entry for the project
 */
public class Driver {
    
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Stopwatch stopwatch = new Stopwatch();
        
        EditDistanceList game = new EditDistanceList("wordlist.txt");
        EditDistanceSet exp = new EditDistanceSet("wordlist.txt");
        
        System.out.println("--- Using ArrayLists ---");
        
        System.out.println("tree to fall in 6");
        stopwatch.start();
        game.printList("tree", "fall", 6);
        stopwatch.stop();
        System.out.println(stopwatch);
        System.out.println();
        
        System.out.println("tree to fall in 4");
        stopwatch.start();
        game.printList("tree", "fall", 4);
        stopwatch.stop();
        System.out.println(stopwatch);
        System.out.println();
        
        /*System.out.println("stone to money in 10");
        stopwatch.start();
        game.printList("stone", "money", 10);
        stopwatch.stop();
        System.out.println(stopwatch);
        System.out.println();*/
        
        System.out.println("--- Using a HashSet ---");
        System.out.println("tree to fall in 6");
        stopwatch.start();
        exp.printList("tree", "fall", 6);
        stopwatch.stop();
        System.out.println(stopwatch);
        System.out.println();
        
        System.out.println("tree to fall in 4");
        stopwatch.start();
        exp.printList("tree", "fall", 4);
        stopwatch.stop();
        System.out.println(stopwatch);
        System.out.println();
        
        /*System.out.println("stone to money in 10");
        stopwatch.start();
        exp.printList("stone", "money", 10);
        stopwatch.stop();
        System.out.println(stopwatch);
        System.out.println();*/
    }
}
