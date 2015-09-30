package lab4;

public abstract class Computer implements Comparable
{
    private String processor;
    private int gbOfRAM, gbOfHardDrive;
    
    /**
     * @return the processor
     */
    public String getProcessor()
    {
        return processor;
    }
    /**
     * @param processorName the processor to set
     */
    public void setProcessor(String processorName)
    {
        processor = processorName;
    }
    /**
     * @return the gbOfRAM
     */
    public int getGbOfRAM()
    {
        return gbOfRAM;
    }
    /**
     * @param gbAmount the gbOfRAM to set
     */
    public void setGbOfRAM(int gbAmount)
    {
        if (gbAmount > 0)
        {
            gbOfRAM = gbAmount;
        }
        else
        {
            gbOfRAM = 2;
            System.out.println("cannot have 0 or negative GB of RAM.");
            System.out.println("This computer now has 2 GB of RAM.");
        }
    }
    /**
     * @return the gbOfHardDrive
     */
    public int getGbOfHardDrive()
    {
        return gbOfHardDrive;
    }
    /**
     * @param gbAmount the gbOfHardDrive to set
     */
    public void setGbOfHardDrive(int gbAmount)
    {
        if (gbAmount > 0)
        {
            gbOfHardDrive = gbAmount;
        }
        else
        {
            gbOfHardDrive = 256;
            System.out.println("cannot have 0 or negative GB of HD Space.");
            System.out.println("This computer now has 256 GB of HD Space.");
        }
    }
    
    public Computer(String nameOfProcessor, int amountOfRAM, int amountOfHDSpace)
    {
        this.setProcessor(nameOfProcessor);
        this.setGbOfRAM(amountOfRAM);
        this.setGbOfHardDrive(amountOfHDSpace);
    }
    
    public abstract float getCost();
    
    @Override
    public int compareTo(Object o)
    {
        if (this.getCost() < ((Computer) o).getCost())
        {
            return -1;
        }
        else if (this.getCost() > ((Computer) o).getCost())
        {
            return 1;
        }
        else // this Computer obj. has same cost as other Computer obj.
        {
            return 0;
        }
    }
}
