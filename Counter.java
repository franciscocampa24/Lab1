/**
 * The counter class implements a counter that will roll over to the initial
 * value when it hits the maximum value.
 * 
 * @author Charles Hoot 
 * @version 5.0
 */
public class Counter
{
    // Private data fields
    private int currentValue;
    private int minimumValue;
    private int maximumValue;
    private boolean rolledOver;

    /**
     * The default constructor for objects of class Counter.
     * Minimum is 0 and the maximum is the largest possible integer.
     */
    public Counter()
    {
        currentValue = 0; // Start with the minimum value
        minimumValue = 0;
        maximumValue = Integer.MAX_VALUE;
        rolledOver = false;
    }
    
    /**
     * The alternate constructor for objects of class Counter.
     * The minimum and maximum values are given as parameters.
     * The counter starts at the minimum value.
     * @param min The minimum value that the counter can have
     * @param max The maximum value that the counter can have
     */
    public Counter(int min, int max)
    {
        if (min <= max) {
            minimumValue = min;
            maximumValue = max;
            currentValue = min; // Start with the minimum value
            rolledOver = false;
        } else {
            throw new IllegalArgumentException("Minimum value cannot be greater than maximum value.");
        }
    }
    
    /**
     * Determine if two counters are in the same state
     *
     * @param otherObject the object to test against for equality
     * @return true if the objects are in the same state
     */
    public boolean equals(Object otherObject)
    {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }

        Counter otherCounter = (Counter) otherObject;

        return currentValue == otherCounter.currentValue &&
               minimumValue == otherCounter.minimumValue &&
               maximumValue == otherCounter.maximumValue &&
               rolledOver == otherCounter.rolledOver;
    }

    /**
     * Increases the counter by one
     */
    public void increase()
    {
        if (currentValue == maximumValue) {
            currentValue = minimumValue; // Roll over to the minimum value
            rolledOver = true;
        } else {
            currentValue++;
            rolledOver = false;
        }
    }
 
    /**
     * Decreases the counter by one
     */
    public void decrease()
    {
        if (currentValue == minimumValue) {
            currentValue = maximumValue; // Roll over to the maximum value
            rolledOver = true;
        } else {
            currentValue--;
            rolledOver = false;
        }
    }
    
    /**
     * Get the value of the counter
     *
     * @return the current value of the counter
     */
    public int value()
    {
        return currentValue;
    }
    
    /**
     * Accessor that allows the client to determine if the counter
     * rolled over on the last count
     *
     * @return true if the counter rolled over
     */
    public boolean rolledOver()
    {
        return rolledOver;
    }
    
    /**
     * Override the toString method to provide a more informative
     * description of the counter
     *
     * @return a descriptive string about the object
     */
    public String toString()
    {
        return "Counter [currentValue=" + currentValue +
               ", minimumValue=" + minimumValue +
               ", maximumValue=" + maximumValue +
               ", rolledOver=" + rolledOver + "]";
    }
}
