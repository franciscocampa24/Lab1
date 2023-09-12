import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * CounterTest - A class that tests the Counter class.
 * 
 * @author Charles Hoot
 * @version 5.0
 * converted into testng tests by Shane McDonough <shane.mcdonough723@csuci.edu>
 */
public static void main(String[] args) {

}
public class CounterTest
{

    /**
     * testConstructor - test if the appropriate exception is thrown
     */

    @Test
    public void testConstructor() throws Exception
    {
        // test valid constructor params
        new Counter(10, 11); // shouldn't fail
        // test invalid constructor params
        try{
            new Counter(10, 10); // should fail
            Assert.fail("no exception thrown"); // fail if no exception
        }catch(CounterInitializationException e){}
        try{
            new Counter(11, 10); // should fail
            Assert.fail("no exception thrown"); // fail if no exception
        }catch(CounterInitializationException e){}
    }

    /**
     * testEquals - test the equals method
     */
    @Test
    public void testEquals() throws Exception
    {
        Counter c1 = new Counter(10,20);
        Counter c2 = new Counter(10,20);        
        Counter c3 = new Counter(11,20);
        Counter c4 = new Counter(10,21);
        Assert.assertEquals(c1, c2, "If they have the same values they are equal");
        Assert.assertNotEquals(c1, c3, "If they don't have the same values they aren't equal");
        Assert.assertNotEquals(c1, c4, "If they don't have the same values they aren't equal");
    }
    

    /**
     * testToString - test the toString method
     */
    @Test
    public void testToString() throws Exception
{
    Counter c = new Counter(1, 9);
    String result = c.toString();
    Assert.assertEquals(result, "1", "ToString result should be '1'");
    Assert.assertEquals(c.value(), 1);
    Assert.assertFalse(c.rolledOver());
}
    
    /**
     * testIncrease - verify that the increase method works
     */

    @Test
    public void testIncrease() throws Exception
    {
        Counter c1 = new Counter(10,11);
        Counter c2 = new Counter(-1,1);
        Counter c3 = new Counter(-10,30);
        c1.increase();
        Assert.assertEquals(c1.value(), 11, "The number after 10 is 11");
        Assert.assertFalse(c1.rolledOver(), "Should not roll over yet");
        c1.increase();
        Assert.assertEquals(c1.value(), 10, "After 11 it cycles back to 10");
        Assert.assertTrue(c1.rolledOver(), "It should roll over now");
        c1.increase();
        Assert.assertEquals(c1.value(), 11, "The number after 10 is 11");
        Assert.assertFalse(c1.rolledOver(), "Should not roll over again");
        // increasing c2 until it rolls over
        int count = 0;
        while(!c2.rolledOver())
        {
            c2.increase();
            count++;
        }
        Assert.assertEquals(c2.value(), -1, "After rolling over it should be the min (-1)");
        Assert.assertEquals(count, 3, "It should take only 3 increases");
        // Increasing counter 3 until it rolls over
        count = 0;
        while(!c3.rolledOver())
        {
            c3.increase();
            count++;
        }
        Assert.assertEquals(c3.value(), -10, "After rolling over it should be the min (-10)");
        Assert.assertEquals(count, 41, "It should take 41 increases");
    }
    
    /**
     * testDecrease - verify that the decrease method works
     */

    @Test
    public void testDecrease() throws Exception
    {
        Counter c1 = new Counter(10,11);
        Counter c2 = new Counter(-1,1);
        Counter c3 = new Counter(-10,30);
        // decrease once
        c1.decrease();
        Assert.assertEquals(c1.value(), 11, "Bad value");
        Assert.assertTrue(c1.rolledOver(), "Should roll over");
        // decrease again
        c1.decrease();
        Assert.assertEquals(c1.value(), 10, "Bad value");
        Assert.assertFalse(c1.rolledOver(), "Shouldn't roll over");
        // decrease a 3rd time
        c1.decrease();
        Assert.assertEquals(c1.value(), 11, "Bad value");
        Assert.assertTrue(c1.rolledOver(), "Should roll over");
        // Decrease counter 2 twice, then decrease counter 2 until it rolls over again
        int count = 0;
        c2.decrease();
        c2.decrease();
        while(!c2.rolledOver())
        {
            c2.decrease();
            count++;
        }
        Assert.assertEquals(c2.value(), 1, "Bad value");
        Assert.assertEquals(count, 2, "Wrong number of decreases");
        // Decrease counter 3 twice, then decrease counter 3 until it rolls over again
        count = 0;
        c3.decrease();
        c3.decrease();
        while(!c3.rolledOver())
        {
            c3.decrease();
            count++;
        }
        Assert.assertEquals(c3.value(), 30, "Bad value");
        Assert.assertEquals(count, 40, "Wrong number of decreases");
    }
    
    
    /**
     * testCombined - test combinations of the increase and decrease methods
     */
    @Test
    public void testCombined() throws Exception
    {
        Counter c1 = new Counter(10,20);
        Counter c2 = new Counter(10,20);
        Counter c3 = new Counter(10,20);
        // TESTING combinations of the increase and decrease methods
        // Increasing counter 2 once
        c2.increase();
        Assert.assertNotEquals(c1, c2, "c1 does not equal c2 because c2 has been incremented");
        // Decreasing counter 2 once
        c2.decrease();
        Assert.assertEquals(c1, c2, "c1 does equal c2 because c2 has been incremented and then decremented");
        // Decreasing then increasing counter 3
        c3.decrease();
        c3.increase();
        Assert.assertNotEquals(c1, c3, "c1 and c3 should differ in rollover");
    }
}
