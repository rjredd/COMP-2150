package programmingassignment1;

import java.util.Scanner;

/**
 * A toy class for making a low-level console-based Minesweeper.
 * 
 * @author Riley Redd
 */
public class GameClient
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        System.out.println("How large do you want the game to be (4-20)");
        Gameboard game = new Gameboard(keyboard.nextInt());
        
        System.out.println("please pick a tile to uncover "
                         + "Y:(1-" + game.getSideLength() + ") | "
                         + "X:(1-" + game.getSideLength() + ")");
        game.generateNewBoard(keyboard.nextInt(), keyboard.nextInt());
        
        while (game.gameState() == 0)
        {
            System.out.print('\u000C'); // new line feed char
            System.out.println(game);
            
            System.out.println("What would you like to do?\r\n"
                              +"Press 1 to uncover a tile.\r\n"
                              +"Press 2 to mark a tile.");
            switch(keyboard.nextInt())
            {
            case 1:
                System.out.println("please pick a tile to uncover "
                        + "Y:(1-" + game.getSideLength() + ") | "
                        + "X:(1-" + game.getSideLength() + ")");
                game.uncover(keyboard.nextInt(), keyboard.nextInt());
                break;
            case 2:
                System.out.println("please pick a tile to mark "
                        + "Y:(1-" + game.getSideLength() + ") | "
                        + "X:(1-" + game.getSideLength() + ")");
                game.changeMarked(keyboard.nextInt(), keyboard.nextInt());
                break;
            default:
                System.out.println("Please press '1' or '2'!");
            }
        }
        System.out.print('\u000C'); // new line feed char
        System.out.println(game);
        if (game.gameState() > 0)
            System.out.println("You Win!");
        else
        {
            System.out.println("You Lose.");
            System.out.println(game.endGame());
            System.out.print("Note: Ø shows a mismarked tile.");
        }
    }
}
