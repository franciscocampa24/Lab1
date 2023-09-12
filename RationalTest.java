
import org.testng.annotations.Test;
import org.testng.Assert;


/**
 * RationalTest - A class that tests the Rational class.
 * 
 * @author Charles Hoot
 * @version 5.0
 * converted into testng tests by Shane McDonough <shane.mcdonough723@csuci.edu>
 */
public class RationalTest
{
public static void main(String[] args) {
    
}
    @Test
    public void testConstructor() throws Exception
    {
        // Trying default constructor
        Rational r0 = new Rational();
        Assert.assertEquals(r0.getNumerator(), 1, "Default numerator should be 1");
        Assert.assertEquals(r0.getDenominator(), 1, "Default denominator should be 1");

        // Constructing 2/5
        Rational r1 = new Rational(2, 5);
        Assert.assertEquals(r1.getNumerator(), 2, "Numerator should be 2");
        Assert.assertEquals(r1.getDenominator(), 5, "Denominator should be 5");

        // Trying 2/0
        try{
            new Rational(2, 0);
            Assert.fail("An exception should be thrown");
        }
        catch(ZeroDenominatorException e) {}

        // Trying 42/30
        Rational r2 = new Rational(42, 30);
        Assert.assertEquals(r2.getNumerator(), 7, "Numerator should be 7");
        Assert.assertEquals(r2.getDenominator(), 5, "Numerator should be 5");

        // Trying 6/-3
        Rational r3 = new Rational(6, -3);
        Assert.assertEquals(r3.getNumerator(), -2, "Numerator should be -2");
        Assert.assertEquals(r3.getDenominator(), 1, "Denominator should be 1");

        // Trying -6/-3
        Rational r4 = new Rational(-6, -3);
        Assert.assertEquals(r4.getNumerator(), 2, "Numerator should be 2");
        Assert.assertEquals(r4.getDenominator(), 1, "Denominator should be 1");
        
        // Trying -6/3
        Rational r5 = new Rational(-6, 3);
        Assert.assertEquals(r5.getNumerator(), -2, "Numerator should be -2");
        Assert.assertEquals(r5.getDenominator(), 1, "Denominator should be 1");
        
        // Trying 0/3
        Rational r6 = new Rational(0, 3);
        Assert.assertEquals(r6.getNumerator(), 0);
        Assert.assertEquals(r6.getDenominator(), 1);
    }
    
    
    @Test
    public void testNegate() throws Exception
    {
        String negate_err = ".negate should not negate it's owner but return a negated copy";

        // Negate 1/2
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.negate();
        Assert.assertEquals(r1.getNumerator(), 1, negate_err);
        Assert.assertEquals(r1.getDenominator(), 2);
        Assert.assertEquals(r2.getNumerator(), -1, negate_err);
        Assert.assertEquals(r2.getDenominator(), 2);

        // Negate -2/3
        r1 = new Rational(-2, 3);
        r2 = r1.negate();
        Assert.assertEquals(r1.getNumerator(), -2, negate_err);
        Assert.assertEquals(r1.getDenominator(), 3);
        Assert.assertEquals(r2.getNumerator(), 2, negate_err);
        Assert.assertEquals(r2.getDenominator(), 3);
    }
    


    @Test
    public void testInvert() throws Exception
    {
        String invert_err = ".invert should not invert it's owner but return an inverted copy";

        // Invert 1/2
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.invert();
        
        Assert.assertEquals(r1.getNumerator(), 1, invert_err);
        Assert.assertEquals(r1.getDenominator(), 2);
        Assert.assertEquals(r2.getNumerator(), 2, invert_err);
        Assert.assertEquals(r2.getDenominator(), 1);

        // Invert -2/3
        r1 = new Rational(-2, 3);
        r2 = r1.invert();
        Assert.assertEquals(r1.getNumerator(), -2, invert_err);
        Assert.assertEquals(r1.getDenominator(), 3);
        Assert.assertEquals(r2.getNumerator(), -3, invert_err);
        Assert.assertEquals(r2.getDenominator(), 2);

        // Invert 0/5
        r1 = new Rational(0, 5);
        try
        {
            r2 = r1.invert();
            Assert.fail("Should Throw ZeroDenominator Exception");
        }
        catch(ZeroDenominatorException e) {}
    }    
    
    @Test
    public void testAddSubtract() throws Exception
    {
        // Adding 1/2 and 1/2
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.add(r1);
        Assert.assertEquals(r1.getNumerator(), 1, "r1 should not be changed");
        Assert.assertEquals(r1.getDenominator(), 2, "r1 should not be changed");
        Assert.assertEquals(r2.getNumerator(), 1);
        Assert.assertEquals(r2.getDenominator(), 1);

        // Adding 4/7 and 3/5
        r1 = new Rational(4, 7);
        r2 = new Rational(3, 5);
        Rational r3 = r1.add(r2);
        Assert.assertEquals(r1.getNumerator(), 4);
        Assert.assertEquals(r1.getDenominator(), 7);
        Assert.assertEquals(r2.getNumerator(), 3);
        Assert.assertEquals(r2.getDenominator(), 5);
        Assert.assertEquals(r3.getNumerator(), 41);
        Assert.assertEquals(r3.getDenominator(), 35);
        
        // Adding 1/2 and 1/6
        r1 = new Rational(1, 2);
        r2 = new Rational(1, 6);
        r3 = r1.add(r2);
        Assert.assertEquals(r3.getNumerator(), 2);
        Assert.assertEquals(r3.getDenominator(), 3);

        // Subtracting 1/2 and 1/2
        r1 = new Rational(1, 2);
        r2 = r1.subtract(r1);
        Assert.assertEquals(r1.getNumerator(), 1, "r1 should not be changed");
        Assert.assertEquals(r1.getDenominator(), 2, "r1 should not be changed");
        Assert.assertEquals(r2.getNumerator(), 0);
        Assert.assertEquals(r2.getDenominator(), 1);

        // Subtracting 4/7 and 3/5
        r1 = new Rational(4, 7);
        r2 = new Rational(3, 5);
        r3 = r1.subtract(r2);
        Assert.assertEquals(r1.getNumerator(), 4);
        Assert.assertEquals(r1.getDenominator(), 7);
        Assert.assertEquals(r2.getNumerator(), 3);
        Assert.assertEquals(r2.getDenominator(), 5);
        Assert.assertEquals(r3.getNumerator(), -1);
        Assert.assertEquals(r3.getDenominator(), 35);
        
        // Subtracting 1/2 and 1/6
        r1 = new Rational(1, 2);
        r2 = new Rational(1, 6);
        r3 = r1.subtract(r2);
        Assert.assertEquals(r3.getNumerator(), 1);
        Assert.assertEquals(r3.getDenominator(), 3);
    }
    
    
    @Test
    public void testMultiplyDivide() throws Exception
    {
        // Multiply 1/2 and 1/2
        Rational r1 = new Rational(1, 2);
        Rational r2 = r1.multiply(r1);
        Assert.assertEquals(r1.getNumerator(), 1);
        Assert.assertEquals(r1.getDenominator(), 2);
        Assert.assertEquals(r2.getNumerator(), 1);
        Assert.assertEquals(r2.getDenominator(), 4);

        // Multiply 5/7 and 3/5
        r1 = new Rational(5, 7);
        r2 = new Rational(3, 5);
        Rational r3 = r1.multiply(r2);
        Assert.assertEquals(r1.getNumerator(), 5);
        Assert.assertEquals(r1.getDenominator(), 7);
        Assert.assertEquals(r2.getNumerator(), 3);
        Assert.assertEquals(r2.getDenominator(), 5);
        Assert.assertEquals(r3.getNumerator(), 3);
        Assert.assertEquals(r3.getDenominator(), 7);
        
        // Multiply 1/2 and 0/1
        r1 = new Rational(1, 2);
        r2 = new Rational(0, 1);
        r3 = r1.multiply(r2);
        Assert.assertEquals(r3.getNumerator(), 0);
        Assert.assertEquals(r3.getDenominator(), 1);
        
        // Dividing 1/2 by 1/2
        r1 = new Rational(1, 2);
        r2 = r1.divide(r1);
        Assert.assertEquals(r1.getNumerator(), 1);
        Assert.assertEquals(r1.getDenominator(), 2);
        Assert.assertEquals(r2.getNumerator(), 1);
        Assert.assertEquals(r2.getDenominator(), 1);

        // Dividing 4/7 by 3/28
        r1 = new Rational(4, 7);
        r2 = new Rational(3, 28);
        r3 = r1.divide(r2);
        
        Assert.assertEquals(r1.getNumerator(), 4);
        Assert.assertEquals(r1.getDenominator(), 7);
        Assert.assertEquals(r2.getNumerator(), 3);
        Assert.assertEquals(r2.getDenominator(), 28);
        Assert.assertEquals(r3.getNumerator(), 16);
        Assert.assertEquals(r3.getDenominator(), 3);
        
        // Dividing 1/2 by 1/6
        r1 = new Rational(1, 2);
        r2 = new Rational(1, 6);
        r3 = r1.divide(r2);
        
        Assert.assertEquals(r3.getNumerator(), 3);
        Assert.assertEquals(r3.getDenominator(), 1);
        
        // Dividing 1/2 by 0/1
        r1 = new Rational(1, 2);
        r2 = new Rational(0, 1);
        try
        {
            r3 = r1.divide(r2);
            Assert.fail("Should have thrown exception");
        }
        catch(ZeroDenominatorException e){}
    }
    
}

    