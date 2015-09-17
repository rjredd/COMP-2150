package lab2;

/**
 * A Class to deal with simple integer-based rational numbers.
 * 
 * @author Riley Redd
 * @version 1.0.0
 * @
 */
public class RationalNumber
{
    private int numerator;
    private int denominator;

    
    
    /* ################# Getters and Setters ################# */

    public int getNumerator()
    {
        return numerator;
    }

    public void setNumerator(int possibleNumerator)
    {
        this.numerator = possibleNumerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public void setDenominator(int possibleDenominator)
    {
        if (possibleDenominator != 0)
        {
            this.denominator = possibleDenominator;
        } else
        {
            System.out.println("Zero cannot be used in the denominator.");
            System.err.println(
                    "Denominator set to 1. Now your rational number is an integer.");
            this.denominator = 1;
        }
    }

    /* ############### End of Getters and Setters ############### */

    
    
    public RationalNumber(int startNumerator, int startDenominator)
    {
        setNumerator(startNumerator);
        setDenominator(startDenominator);
        simplify();
    }

    /**
     * This method adds the calling RationalNumber object by the
     * otherRational RationalNumber object.
     * 
     * @param otherRational - A second RationalNumber object.
     * @return The sum of the calling object and otherRational 
     *         as a new RationalNumber Object.
     */
    public RationalNumber Addition(RationalNumber otherRational)
    {
        // These 3 integers are simply making both fractions share common denominators.
        int currentTempNumerator = this.getNumerator()
                * otherRational.getDenominator();
        int otherTempNumerator = otherRational.getNumerator()
                * this.getDenominator();
        // You only need 1 denominator (as either way you do it you get the same number)
        int tempDenominator = this.getDenominator()
                * otherRational.getDenominator();

        // Addition done here.
        return new RationalNumber(currentTempNumerator + otherTempNumerator,
                tempDenominator);
    }

    /**
     * This method subtracts the calling RationalNumber object by the
     * otherRational RationalNumber object.
     * 
     * @param otherRational - A second RationalNumber object.
     * @return The difference of the calling object and otherRational 
     *         as a new RationalNumber Object.
     */
    public RationalNumber Subtraction(RationalNumber otherRational)
    {
        // These 3 integers are simply making both fractions share common denominators.
        int currentTempNumerator = this.getNumerator()
                * otherRational.getDenominator();
        int otherTempNumerator = otherRational.getNumerator()
                * this.getDenominator();
        // You only need 1 denominator (as either way you do it you get the same number)
        int tempDenominator = this.getDenominator()
                * otherRational.getDenominator();

        // Subtraction done here.
        return new RationalNumber(currentTempNumerator - otherTempNumerator,
                tempDenominator);
    }

    /**
     * This method multiplies the calling RationalNumber object by the
     * otherRational RationalNumber object.
     * 
     * @param otherRational - A second RationalNumber object.
     * @return The product of the calling object and otherRational 
     *         as a new RationalNumber Object.
     */
    public RationalNumber Multiplication(RationalNumber otherRational)
    {
        return new RationalNumber(
                // Numerator = calling object and otherRationals numerators multiplied together.
                this.getNumerator() * otherRational.getNumerator(),
                // Denominator = calling object and otherRationals numerators multiplied together.
                this.getDenominator() * otherRational.getDenominator());
    }

    /**
     * This method divides the calling RationalNumber object by the
     * otherRational RationalNumber object.
     * 
     * @param otherRational - A second RationalNumber object.
     * @return The quotient of the calling object and otherRational 
     *         as a new RationalNumber Object.
     */
    public RationalNumber Division(RationalNumber otherRational)
    {
        // This simply does multiplication on the reciprocal of otherRational object.
        return Multiplication(otherRational.Reciprocal());
    }

    /**
     * This method flips the numerator and the denominator of the calling object, and puts
     * them in a new RationalNumber Object.
     * 
     * @return A RationalNumber as described above.
     */
    public RationalNumber Reciprocal()
    {
        return new RationalNumber(this.getDenominator(), this.getNumerator());
    }

    /**
     * This methods multiplies the calling objects numerator by -1
     * 
     * @return a RationalNumber the same as the calling object. Numerator x -1.
     */
    public RationalNumber Negative()
    {
        return new RationalNumber(this.getNumerator() * -1,
                this.getDenominator());
    }
    
    @Override
    public String toString()
    {
        // Overridden to return a String of the fraction's numerator. A forward slash.
        // And then the fraction's denominator.
        return this.getNumerator() + "/" + this.getDenominator();
    }
    
    public double asDecimal()
    {
        return ((double)this.getNumerator() / (double)this.getDenominator());
    }

    
    
    /* ##################### Miscellaneous ##################### */

    /*
     * Takes the current instance variables, calls gcd() on them, and changes
     * instance variables to simplest form.
     */
    private void simplify()
    {
        int gcd = gcd(this.getNumerator(), this.getDenominator()); // instance
                                                                   // variables
                                                                   // GCD
        setNumerator(this.getNumerator() / gcd); // Divide the Numerator by the
                                                 // GCD
        setDenominator(this.getDenominator() / gcd); // Divide the Denominator
                                                     // by the GCD
    }

    /**
     * Euclidean Algorithm to find Greatest Common Denominator
     * 
     * @param numA
     *            The numerator or denominator of a rational number
     * @param numB
     *            The numerator or denominator of a rational number
     * @return The Greatest Common Denominator
     */
    private int gcd(int numA, int numB)
    {
        int temp;
        while (numB != 0) // if the remainder is 0 (thus the GCD reached) end
                          // loop
        {
            temp = numB; // temp set up
            numB = numA % numB; // find the remainder of the two variables
            numA = temp; // flip equation
            // Repeat
        }
        return numA;
    }

    /* ################## End of Miscellaneous ################## */
}
