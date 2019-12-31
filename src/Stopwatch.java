/**
 * A class to measure time elapsed.
 */

public class Stopwatch {
    private static final double NANOS_PER_SEC = 1_000_000_000.0;
    private long startTime = 0L;
    private long stopTime = 0L;
    
    /**
     * start the stop watch.
     */
    public void start() {
        startTime = System.nanoTime();
    }
    
    /**
     * stop the stop watch.
     */
    public void stop() {
        stopTime = System.nanoTime();
    }
    
    /**
     * elapsed time in seconds.
     *
     * @return the time recorded on the stopwatch in seconds
     */
    public double time() {
        return (stopTime - startTime) / NANOS_PER_SEC;
    }
    
    public String toString() {
        return "Elapsed time: " + time() + " seconds.";
    }
}
