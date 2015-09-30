package lab4;

public class Desktop extends Computer
{
    private int mbOfVRAM;
    
    /**
     * @return the mbOfVRAM
     */
    public int getMbOfVRAM()
    {
        return mbOfVRAM;
    }

    /**
     * @param mbAmount the mbOfVRAM to set
     */
    public void setMbOfVRAM(int mbAmount)
    {
        if(mbAmount > 0) // makes sure numbers are positive and not 0
        {
            mbOfVRAM = mbAmount;
        }
        else
        {
            mbOfVRAM = 128;
            System.out.println("cannot have 0 or negative MB of VRAM.");
            System.out.println("This computer now has 128 MB of VRAM.");
        }
    }

    public Desktop(String nameOfProcessor, int amountOfRAM, int amountOfHDSpace
                 , int amountOfVRAM)
    {
        super(nameOfProcessor, amountOfRAM, amountOfHDSpace);
        this.setMbOfVRAM(amountOfVRAM);
    }

    @Override
    public float getCost()
    {
        return 250 + (5.5f * this.getGbOfRAM()) + (0.1f * this.getGbOfHardDrive())
                + (0.3f * this.getMbOfVRAM());
    }
    
    @Override
    public String toString()
    {
        return    "Desktop:\r\n"
                + "-------\r\n"
                + "CPU: " + this.getProcessor() + "\r\n"
                + "HDD: " + this.getGbOfRAM() + " GB \r\n"
                + "HDD: " + this.getGbOfHardDrive() + " GB\r\n"
                + "VRAM: " + this.getMbOfVRAM() + " MB\r\n"
                + "Cost: $" + this.getCost() + "\r\n";
    }

}
