package lab4;

/**
 * A Toy class for the purpose of a homework assignment.
 * 
 * @author Riley Redd
 */
public class Client
{
    public static void main(String[] args)
    {
        // Create and initialize an array of 5 Computer Objects
        Computer[] computers = new Computer[5];
        computers[0] = new Desktop("Average Processor", 4, 256, 512);
        computers[1] = new Laptop("WTF Procesor", 64, 4096, 17.1f);
        computers[2] = new Laptop("A processor", 2, 128, 13.1f);
        computers[3] = new Desktop("The Good One", 8, 512, 1024);
        computers[4] = new Desktop("The Big-Momma", 32, 2048, 4096);

        // Sort the Computer Objects.
        aSortingMethod(computers);
        
        // Print out each of the computer objects to the command line.
        for(int i = 0; i < computers.length; i++)
        {
            System.out.println(computers[i]);
        }
    }

    /**
     * Did my sorting here to keep the main method clean.
     * A simple Brute Force sorting algorithm.
     * Changes the parameter obj directly.
     * 
     * !Uses non-OOP paradigm Code!
     * 
     * @param aComputerArray
     */
    private static void aSortingMethod(Computer[] aComputerArray)
    {
        boolean flag = true;
        Computer tempObj;

        whileloop:
        while (flag)
        {
            for (int i = 0; i < aComputerArray.length; i++)
            {
                if (i < aComputerArray.length - 1)
                {
                    if (aComputerArray[i].compareTo(aComputerArray[i + 1]) > 0)
                    {
                        tempObj = aComputerArray[i];
                        aComputerArray[i] = aComputerArray[i + 1];
                        aComputerArray[i + 1] = tempObj;
                        continue whileloop;
                    }
                }
            }
            
            flag = false;
        }
    }
}
