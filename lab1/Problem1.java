package lab1;

/**
 * This is a toy class for homework purposes.
 * (isOrdered HW Problem)
 * 
 * @author Riley Redd
 */
public class Problem1
{

    public static void main(String[] args)
    {
        // Basic Test laid out in the assignment.
        System.out.println(isOrdered("abcdefg"));
        System.out.println(isOrdered("aabcdefg"));
        System.out.println(isOrdered("abcDefg"));
    }

    /**
     * This checks the ASCII values of each letter in a string to see if they are in
     * ascending order (1, 2, 3, 6, 7, 10, 89, etc.)
     * 
     * @param a    a string with only uppercase and lowercase letters. (NO Spaces or Special Chars.) 
     * @return     whether or not the string is in an ascending ASCII order or not.
     */
    private static boolean isOrdered(String a)
    {
        int check = 0; // Assigns check to a number below the alphabet of the ASCII Byte 
        
        for(int loop = 0; loop < a.length(); loop++) // runs through each char in a string
        {
            if(check < (int)a.charAt(loop)) // is check less than the ASCII value of current char?
            {
                check = (int)a.charAt(loop); // sets check to the ASCII value of the current char
            }
            else // check was larger than current char ASCII value
            {
                return false; // The String FAILED it's ASCII order test
            }
        }
        return true; // The String SUCCEEDED it's ASCII order test
    }
    
}
