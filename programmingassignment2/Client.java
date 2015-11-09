package programmingassignment2;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Client
{
    
    public static void main(String[] args)
    {
//        ArrayList<Media> masterList = NetflixFileReader.getList();
        
        HelloAndGoodbye frame = new HelloAndGoodbye();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
