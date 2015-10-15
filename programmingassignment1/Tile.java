package programmingassignment1;

/**
 * A toy class for making a low-level console-based Minesweeper.
 * 
 * @author Riley Redd
 */
public class Tile
{
    private boolean isCovered, isMarked, containsMine;
    private int adjacentMineCount;

    /* ############ Getters and Setters ############ */

    /**
     * @return the isCovered
     */
    public boolean isCovered()
    {
        return isCovered;
    }

    /**
     * @param isCovered
     *            the isCovered to set
     */
    public void setCovered(boolean isCovered)
    {
        this.isCovered = isCovered;
    }

    /**
     * @return the isMarked
     */
    public boolean isMarked()
    {
        return isMarked;
    }

    /**
     * @param isMarked
     *            the isMarked to set
     */
    public void setMarked(boolean isMarked)
    {
        this.isMarked = isMarked;
    }

    /**
     * @return the containsMine
     */
    public boolean isContainsMine()
    {
        return containsMine;
    }

    /**
     * @param containsMine
     *            the containsMine to set
     */
    public void setContainsMine(boolean containsMine)
    {
        this.containsMine = containsMine;
    }

    /**
     * @return the adjacentMineCount
     */
    public int getAdjacentMineCount()
    {
        return adjacentMineCount;
    }

    /**
     * @param adjacentMineCount
     *            the adjacentMineCount to set
     */
    public void setAdjacentMineCount(int adjacentMineCount)
    {
        this.adjacentMineCount = adjacentMineCount;
    }

    /* ######## End of Getters and Setters ######### */

    public Tile(boolean hasMine)
    {
        this.setCovered(true);
        this.setMarked(false);
        this.setContainsMine(hasMine);
        this.setAdjacentMineCount(0);
    }

    @Override
    public String toString()
    {
        if (this.getAdjacentMineCount() == -1)
        {
            return "Ø";
        }
        if (this.isCovered())
        {
            if (this.isMarked())
                return "√";
            return "■";
        } else if (this.isContainsMine())
            return "X";
        else
            return this.getAdjacentMineCount() + "";
    }
}

// (char)127 == 