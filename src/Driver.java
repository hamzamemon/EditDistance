public class Driver {
    
    public static void main(String[] args){
        Stopwatch stopwatch = new Stopwatch();
        
        WordGame game = new WordGame("wordlist.txt");
        WordGameExp exp = new WordGameExp("wordlist.txt");
    
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
