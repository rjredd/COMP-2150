package lab4;

public class Laptop extends Computer
{
    private float screenSize;
    
    /**
     * @return the screenSize
     */
    public float getScreenSize()
    {
        return screenSize;
    }

    /**
     * @param newScreenSize the screenSize to set
     */
    public void setScreenSize(float newScreenSize)
    {
        if (newScreenSize > 0)
        {
            screenSize = newScreenSize;
        }
        else
        {
            screenSize = 13;
            System.out.println("cannot have 0 or negative screen size.");
            System.out.println("This computer now has a 13 inch screen.");
        }
    }

    public Laptop(String nameOfProcessor, int amountOfRAM, int amountOfHDSpace
                , float sizeOfScreen)
    {
        super(nameOfProcessor, amountOfRAM, amountOfHDSpace);
        this.setScreenSize(sizeOfScreen);
    }

    @Override
    public float getCost()
    {
        return 300 + (8 * this.getGbOfRAM()) + (0.19f * this.getGbOfHardDrive())
                   + (13.83f * this.getScreenSize());
    }
    
    @Override
    public String toString()
    {
        return    "Laptop:\r\n"
                + "-------\r\n"
                + "CPU: " + this.getProcessor() + "\r\n"
                + "HDD: " + this.getGbOfRAM() + " GB \r\n"
                + "HDD: " + this.getGbOfHardDrive() + " GB\r\n"
                + "Screen: " + this.getScreenSize() + "\"\r\n"
                + "Cost: $" + this.getCost() + "\r\n";
    }
}
