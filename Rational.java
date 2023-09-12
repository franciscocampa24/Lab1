import java.lang.Math;

/**
 * A class that represents a rational number.
 * 
 * @author Charles Hoot
 * @version 5.0
 */
public class Rational {
    private int numerator;
    private int denominator;

    /**
     * The default constructor for objects of class Rational. Creates the rational
     * number 1.
     */
    public Rational() {
        numerator = 1;
        denominator = 1;
    }

    /**
     * The alternate constructor for objects of class Rational. Creates a rational
     * number equivalent to n/d.
     * 
     * @param n The numerator of the rational number.
     * @param d The denominator of the rational number.
     */
    public Rational(int n, int d) throws ZeroDenominatorException {
        if (d == 0) {
            throw new ZeroDenominatorException("Denominator can't be 0");
        }
        numerator = n;
        denominator = d;
        normalize();
    }

    /**
     * Get the value of the Numerator
     *
     * @return the value of the numerator
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * Get the value of the Denominator
     *
     * @return the value of the denominator
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Negate a rational number r
     * 
     * @return a new rational number that is negation of this number -r
     */
    public Rational negate() {
        return new Rational(-numerator, denominator);
    }

    /**
     * Invert a rational number r
     * 
     * @return a new rational number that is 1/r.
     */
    public Rational invert() throws ZeroDenominatorException {
        if (numerator == 0) {
            throw new ZeroDenominatorException("Cannot compute the reciprocal of 0");
        }
        return new Rational(denominator, numerator);
    }

    /**
     * Add two rational numbers
     *
     * @param other the second argument of the add
     * @return a new rational number that is the sum of this and the other rational
     */
    public Rational add(Rational other) throws ZeroDenominatorException {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator1 = this.numerator * other.denominator;
        int newNumerator2 = other.numerator * this.denominator;

        int sumNumerator = newNumerator1 + newNumerator2;

        return new Rational(sumNumerator, commonDenominator);
    }

    /**
     * Subtract a rational number t from this one r
     *
     * @param other the second argument of subtract
     * @return a new rational number that is r-t
     */
    public Rational subtract(Rational other) throws ZeroDenominatorException {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator1 = this.numerator * other.denominator;
        int newNumerator2 = other.numerator * this.denominator;

        int differenceNumerator = newNumerator1 - newNumerator2;
        return new Rational(differenceNumerator, commonDenominator);
    }

    /**
     * Multiply two rational numbers
     *
     * @param other the second argument of multiply
     * @return a new rational number that is the product of this object and the other rational.
     */
    public Rational multiply(Rational other) throws ZeroDenominatorException {
        int productNumerator = this.numerator * other.numerator;
        int productDenominator = this.denominator * other.denominator;

        return new Rational(productNumerator, productDenominator);
    }

    /**
     * Divide this rational number r by another one t
     *
     * @param other the second argument of divide
     * @return a new rational number that is r/t
     */
    public Rational divide(Rational other) throws ZeroDenominatorException {
        if (other.numerator == 0) {
            throw new ZeroDenominatorException("Cannot divide by zero.");
        }

        int quotientNumerator = this.numerator * other.denominator;
        int quotientDenominator = this.denominator * other.numerator;

        return new Rational(quotientNumerator, quotientDenominator);
    }

    /**
     * Put the rational number in normal form where the numerator
     * and the denominator share no common factors. Guarantee that only the
     * numerator is negative.
     */
    private void normalize() {
        int commonDivisor = gcd(Math.abs(numerator), Math.abs(denominator));
        numerator /= commonDivisor;
        denominator /= commonDivisor;
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * Recursively compute the greatest common divisor of two positive integers
     *
     * @param a the first argument of gcd
     * @param b the second argument of gcd
     * @return the gcd of the two arguments
     */
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    /**
     * Converts this object into a string
     * 
     * @return A string that contains the sign, the numerator, and the denominator
     */
    public String toString() {
        if (denominator == 1) {
            return Integer.toString(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }
}
