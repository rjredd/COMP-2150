package lab2;

/**
 * A running 
 * 
 * @author Riley Redd
 */
public class Start
{
    public static void main(String[] args)
    {
        RationalNumber fraction1 = new RationalNumber(1, 2);
        RationalNumber fraction2 = new RationalNumber(7, 6);
        
        System.out.println("fraction1 = " + fraction1);
        System.out.println("fraction2 = " + fraction2);
        System.out.println();
        System.out.println("Addition test case:");
        System.out.println(fraction1.Addition(fraction2));
        System.out.println();
        System.out.println("Subtraction test case:");
        System.out.println(fraction1.Subtraction(fraction2));
        System.out.println();
        System.out.println("Multiplication test case:");
        System.out.println(fraction1.Multiplication(fraction2));
        System.out.println();
        System.out.println("Division test case:");
        System.out.println(fraction1.Division(fraction2));
        System.out.println();
        System.out.println("Reciprocal test case:");
        System.out.println(fraction1.Reciprocal());
        System.out.println();
        System.out.println("Negative test case:");
        System.out.println(fraction1.Negative());
        System.out.println();
        System.out.println("toString test case:");
        System.out.println("Method toString() is demonstrated by every other test case.");
        System.out.println();
        System.out.println("asDecimal test case:");
        System.out.println(fraction1.asDecimal());
        System.out.println();
        System.out.println("Zero in denominator test case:");
        @SuppressWarnings("unused")
        RationalNumber fraction3 = new RationalNumber(1, 0);
    }
}
