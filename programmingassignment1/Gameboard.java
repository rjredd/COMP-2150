package programmingassignment1;

public class Gameboard
{
    private int sideLength;
    private Tile[][] board;

    /**
     * @return the sideLength
     */
    public int getSideLength()
    {
        return sideLength;
    }

    /**
     * @param newSideLength
     *            the sideLength to set
     */
    public void setSideLength(int newSideLength)
    {
        if (newSideLength > 20)
        {
            this.sideLength = 20;
            System.out.println("Size set to 20x20 (Max Size)");
        } else if (newSideLength < 4)
        {
            this.sideLength = 4;
            System.out.println("Size set to 4x4 (Min Size)");
        } else
            this.sideLength = newSideLength;
    }

    public Gameboard(int boardSize)
    {
        this.setSideLength(boardSize);

        board = new Tile[this.getSideLength() + 2][this.getSideLength() + 2];

        /*
         * These 3 lines make a blank board to be interacted with so that the
         * player cannot lose on the first turn.
         */
        for (int i = 1; i <= this.getSideLength(); i++)
            for (int j = 1; j <= this.getSideLength(); j++)
                board[i][j] = new Tile(false);
    }

    public void generateNewBoard(int firstX, int firstY)
    {
        int maxMineCount = (int) ((this.getSideLength() * this.getSideLength())
                / 4);
        int currentMineCount = 0;

        do
        {
            for (int i = 1; i <= this.getSideLength(); i++)
            {
                for (int j = 1; j <= this.getSideLength(); j++)
                {
                    if (i != firstX - 1 && j != firstY - 1)
                    {
                        if (currentMineCount < maxMineCount)
                        {
                            if ((Math.random() * 100) < 25)
                            {
                                board[i][j] = new Tile(true);
                                currentMineCount++;
                            } else
                                board[i][j] = new Tile(false);
                        } else
                            board[i][j] = new Tile(false);
                    }
                }
            }
        } while (currentMineCount < maxMineCount);
    }

    public void uncover(int posX, int posY)
    {
        // Uncovers the Tile at the specified location (so long as it is covered).
        if (board[posX][posY].isCovered())
        {
            board[posX][posY].setCovered(false);

            int mineCount = 0;

            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (i != 0 && j != 0)
                    {
                        if (board[posX + i][posY + j] != null
                                && board[posX + i][posY + j].isContainsMine())
                        {
                            mineCount++;
                        }
                    }
            
            board[posX][posY].setAdjacentMineCount(mineCount);
        }
    }

    public void changeMarked(int posX, int posY)
    {
        // Flips the isMarked boolean at the specified location.
        board[posX][posY].setMarked(!board[posX][posY].isMarked());
    }

    /*
     * -1 = loss 0 = running 1 = win
     */
    public int gameState()
    {
        for (int i = 1; i <= this.getSideLength(); i++)
            for (int j = 1; j <= this.getSideLength(); j++)
            {
                // Has a mine tile been uncovered?
                if (board[i][j].isContainsMine() && !board[i][j].isCovered())
                {
                    return -1;
                }
            }

        // At this point no mine has been uncovered.
        for (int i = 1; i <= this.getSideLength(); i++)
            for (int j = 1; j <= this.getSideLength(); j++)
            {
                // Are there any unmarked covered tiles left?
                if (board[i][j].isCovered() && !board[i][j].isMarked())
                {
                    return 0;
                }
            }

        // At this point should be no unmarked covered tiles AND no uncovered
        // mines.
        for (int i = 1; i <= this.getSideLength(); i++)
            for (int j = 1; j <= this.getSideLength(); j++)
            {
                // Are there any marked covered tiles left?
                if (board[i][j].isCovered() && board[i][j].isMarked())
                {
                    // Is it not a mine?
                    if (!board[i][j].isContainsMine())
                    {
                        return 0;
                    }
                }
            }

        // there are no uncovered mines AND all covered tiles should be marked
        // and contain mines.
        // You win.
        return 1;
    }

    @Override
    public String toString()
    {
        String boardAsString = "╔";

        for (int i = 1; i <= (this.getSideLength() * 2) - 1; i++)
            boardAsString += "═";

        boardAsString += "╗\r\n";

        for (int i = 1; i <= this.getSideLength(); i++)
        {
            boardAsString += "║";
            for (int j = 1; j <= this.getSideLength(); j++)
            {
                boardAsString += board[i][j];
                if (j <= this.getSideLength() - 1)
                    boardAsString += " ";
            }
            boardAsString += "║\r\n";
        }

        boardAsString += "╚";

        for (int i = 1; i <= (this.getSideLength() * 2) - 1; i++)
            boardAsString += "═";

        boardAsString += "╝";

        return boardAsString;
    }
}