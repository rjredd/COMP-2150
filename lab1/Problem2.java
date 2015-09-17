package lab1;

/**
 * This is a toy class for homework purposes.
 * (trim/MyLittlePony HW Problem)
 * 
 * @author Riley Redd
 */
public class Problem2
{

    public static void main(String[] args)
    {
     // Basic Test laid out in the assignment. (plus 1 extra)
        System.out.println(trim("    Rainbow   Dash"));
        System.out.println(trim("Rainbow    Dash    "));
        System.out.println(trim(" Rainbow Dash "));
        System.out.println(trim("  Why  do  we     have a  brony  question?  "));
    }

    /**
     *     This method removes the spaces at the beginning of a string, scans through the
     * string for sections of non-spaces (and adds them to a blank string, adding a letter),
     * then removes the spaces at the end of the string.
     * 
     * NOTE: Works with any amount of words, be it 1 or 1000
     * 
     * @param s     The initial String to have extraneous spaces removed
     * @return      A String with no extraneous spaces
     */
    private static String trim(String s)
    {
        String trimmedString = "";
        
        for(int loop = 0; loop < s.length(); loop++) // Removes spaces at the front of String
        {
            if((int)s.charAt(loop) != 32 ) // if char at current index ISN'T a space
            {
                trimmedString = s.substring(loop);
                break;
            }
        }
        
        trimmedString += " "; // Adds a space for functionality purposes
        
        String tempString = trimmedString; // holder for trimmedString
        trimmedString = ""; // Resets trimmedString
        boolean spaceSection = false; //keeps track of whether the loop is on spaces or not.
        int wordStart = 0; // controls the substrings in the next for loop
        
        for(int loop = 0; loop < tempString.length(); loop++)
        {
            // If the character at the current index is a Space.
            if((int)tempString.charAt(loop) == 32)
            {
                if(spaceSection) // There are spaces previous to this one.
                {
                    continue;
                }
                else // This is the first space of this section
                {
                    // Adds the word of the previous index to trimmedString
                    trimmedString += tempString.substring(wordStart, loop);
                    if (tempString.length() - 1 != loop)
                    {
                        trimmedString += " "; // Adds a single space to the end of each word
                    }
                    
                    spaceSection = true; // The indexing variable is now on a section of spaces
                }
            }
            else // The character at the current index is NOT a space.
            {
                if(spaceSection) // This is the first non-space of this section
                {
                    spaceSection = false; // The indexing variable is now on a segment of non-spaces
                    wordStart = loop; // this is the starting index of the current word
                }
            }
        }
        
        for(int loop = (trimmedString.length() - 1); loop > 0; loop--) // Removes spaces at the back of String
        {
            if((int)trimmedString.charAt(loop) != 32 ) // if char at current index ISN'T a space
            {
                trimmedString = trimmedString.substring(0, loop + 1); 
                break;
            }
        }
        
        return trimmedString;
    }
    
}
