package lab1;

/**
 * This is a toy class for homework purposes.
 * (GATTACCA problem)
 * 
 * @author Riley Redd
 */
public class Problem3
{

    public static void main(String[] args)
    {
        // basic testing laid out in instructions.
        System.out.println(compress("AAAaaCTGGGTCGTTAaGGGGCGG"));
    }

    /**
     *     This method takes a string and runs though it once, taking count of
     * consecutive character usage. It creates a new string whilst running though
     * the original.
     * 
     * @param s    An uncompressed String
     * @return     A string compressed using the "simple compression scheme". :P
     */
    public static String compress(String s)
    {
        String finishedString = "" + s.charAt(0); // Starts with the first char, ALWAYS
        int count = 1; // count should never be less than 1
        
        for (int loop = 0; loop < s.length(); loop++)
        {
            // index start protection
            if (loop == 0)
            {
                continue;
            }
            
            // the current and previous char are the same
            if (s.charAt(loop) == s.charAt(loop - 1))
            {
                count++;
                
                // End of string handling.
                if (loop == s.length() - 1)
                {
                    finishedString += count;
                    break;
                }
            }
            else // The current and previous char are NOT the same
            {
                if (count > 1)
                {
                    finishedString += count;
                }
                
                finishedString += s.charAt(loop); //new letter start.
                count = 1; // reset count.
            }
        }
        
        return finishedString;
    }
}
