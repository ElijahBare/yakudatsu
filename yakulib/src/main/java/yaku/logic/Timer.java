package yaku.logic;

/**
 * The `Timer` class provides a simple mechanism for measuring time intervals and managing delays.
 * It allows tracking elapsed time and determining whether a specified delay has been reached.
 */
public class Timer {
    private long current;

    /**
     * Constructs a new `Timer` object and initializes the current time to the current system time.
     */
    public Timer(){
        this.current = System.currentTimeMillis();
    }

    /**
     * Checks if the specified delay has been reached since the timer was last reset.
     *
     * @param delay the delay in milliseconds to check against.
     * @return true if the specified delay has been reached, false otherwise.
     */
    public boolean hasReached(long delay){
        return System.currentTimeMillis() - current >= delay;
    }

    /**
     * Resets the timer by updating the current time to the current system time.
     */
    public void reset(){
        this.current = System.currentTimeMillis();
    }

    /**
     * Returns the current time of the timer in milliseconds.
     *
     * @return the current time of the timer in milliseconds.
     */
    public long getCurrent() {
        return current;
    }
}
