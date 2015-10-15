package programmingassignment1;

/**
 * A toy class for making a low-level console-based Minesweeper.
 * 
 * @author Riley Redd
 */
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

    /**
     * Creates a new Gameboard with extra space around the sides.
     * 
     * @param boardSize
     *            how large you want the board to be.
     */
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

    /**
     * This method handles generating the gameboard in such a way so that the
     * first slot never has a bomb Honors problem 1
     * 
     * @param firstX
     * @param firstY
     */
    public void generateNewBoard(int firstY, int firstX)
    {
        int[] maxMineCount = { 0, 0, 0, 0, 4, 6, 9, 12, 16, 20, 25, 30, 36, 42,
                49, 56, 64, 72, 81, 90, 100 };
        int currentMineCount = 0;

        while (currentMineCount < maxMineCount[this.getSideLength()])
        {
            for (int i = 1; i <= this.getSideLength(); i++)
            {
                for (int j = 1; j <= this.getSideLength(); j++)
                {
                    // 25% chance of bomb spawn
                    if ((Math.random() * 100) < 25
                            && !board[i][j].isContainsMine())
                    {
                        board[i][j] = new Tile(true);
                        currentMineCount++;
                    } else
                        board[i][j] = new Tile(false);

                }
            }
        }

        board[firstX][firstY] = new Tile(false);

        for (int i = 1; i <= this.getSideLength(); i++)
        {
            for (int j = 1; j <= this.getSideLength(); j++)
            {
                board[i][j].setAdjacentMineCount(this.checkNeighbors(i, j));
                System.out.println(board[i][j].getAdjacentMineCount());
            }
        }

        this.uncover(firstY, firstX);
    }

    /**
     * This method uncovers the tile at the specified location. !!!cannot be
     * uncovered!!!
     * 
     * @param yPos
     *            a Y position on the board of play.
     * @param xPos
     *            an X position on the board of play.
     */
    public void uncover(int posY, int posX)
    {
        // Uncovers the Tile at the specified location (so long as it is
        // covered).
        if (board[posX][posY].getAdjacentMineCount() == 0)
        {
            this.revealZeros(posX, posY);
        } else if (board[posX][posY].isCovered())
            board[posX][posY].setCovered(false);
    }

    /**
     * This method switches the boolean isMarked of the tile at current
     * position.
     * 
     * @param yPos
     *            a Y position on the board of play.
     * @param xPos
     *            an X position on the board of play.
     */
    public void changeMarked(int posY, int posX)
    {
        if (this.board[posX][posY].isCovered())
        {
            // Flips the isMarked boolean at the specified location.
            board[posX][posY].setMarked(!board[posX][posY].isMarked());
        } else
        {
            System.out.println("This location is already uncovered!");
        }
    }

    /**
     * This method keeps the game running so long as the detailed questions are
     * met correctly.
     * 
     * @return -1 if lose || 0 if running || 1 if win
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

    /**
     * This method recursively opens all 0 tiles cardinally adjacent to calling
     * tile. Honors problem 2
     * 
     * @param xPos
     *            an X position on the board of play.
     * @param yPos
     *            a Y position on the board of play.
     */
    private void revealZeros(int xPos, int yPos)
    {
        if (this.board[xPos][yPos] != null
                && this.board[xPos][yPos].getAdjacentMineCount() == 0
                && this.board[xPos][yPos].isCovered()
                && !this.board[xPos][yPos].isContainsMine())
        {
            this.board[xPos][yPos].setCovered(false);
            revealZeros(xPos + 1, yPos);
            revealZeros(xPos - 1, yPos);
            revealZeros(xPos, yPos - 1);
            revealZeros(xPos, yPos + 1);
        }
    }

    /**
     * This method counts mines in neighboring tiles. Honors Problem 2
     * 
     * @param xPos
     *            an X position on the board of play.
     * @param yPos
     *            a Y position on the board of play.
     * @return the number of mines in the adjacent tiles (0-8)
     */
    private int checkNeighbors(int xPos, int yPos)
    {
        int check = 0;

        for (int i = -1; i <= 1; i++)
        {
            for (int j = -1; j <= 1; j++)
            {
                if (this.board[xPos + i][yPos + j] != null)
                {
                    if (this.board[xPos + i][yPos + j].isContainsMine())
                        check++;
                }
            }
        }

        return check;
    }

    /**
     * This method creates a new gameboard to show mismarked tiles. Honors
     * problem 3
     * 
     * @return Gameboard with mismarked tiles noted.
     */
    public Gameboard endGame()
    {

        Tile[][] endGame = new Tile[this.getSideLength()
                + 2][this.getSideLength() + 2];

        for (int i = 1; i <= this.getSideLength(); i++)
            for (int j = 1; j <= this.getSideLength(); j++)
                endGame[i][j] = this.board[i][j];

        for (int i = 1; i <= this.getSideLength(); i++)
        {
            for (int j = 1; j <= this.getSideLength(); j++)
            {
                if (endGame[i][j].isMarked() && !endGame[i][j].isContainsMine())
                {
                    endGame[i][j].setAdjacentMineCount(-1);
                }
                endGame[i][j].setCovered(false);
            }
        }

        Gameboard finalBoard = new Gameboard(this.getSideLength());
        finalBoard.board = endGame;

        return finalBoard;
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