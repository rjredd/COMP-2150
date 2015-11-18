package programmingassignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NetflixFileReader
{
    public static ArrayList<Media> getList()
    {
        // 10528 lines in .txt file.
        ArrayList<Media> tempList = new ArrayList<Media>(10530);

        // The location as a string for visibility and cleanliness.
        String location = "src\\programmingassignment2\\NetflixUSA_Oct15_cleaned.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(location)))
        {
            for (String line; (line = br.readLine()) != null;)
            {
                String[] lineSplit = line.split("[()|,]");

                String lineTitle = "";
                
                if (lineSplit.length > 4)
                {
                    int count = lineSplit.length;
                    int loop = 0;
                    String tempString = "";
                    
                    do
                    {
                        tempString = lineSplit[loop];
                        count--;
                        loop++;
                    } while (count > 4);
                    
                    lineTitle = tempString.trim();
                }
                
                
                
                Media newMedia = null;

                char charCheck = line.charAt(line.length() - 1);

                if (charCheck == 's' || charCheck == 'n' || charCheck == 't'
                        || charCheck == 'e' || charCheck == 'l')
                {
                    Series tempMedia = new Series();

                    tempMedia.setTitle(lineTitle);
                    tempMedia.setYear(lineSplit[1].trim());
                    tempMedia.setAvg(lineSplit[3].trim());
                    tempMedia.setEpisodecount(lineSplit[4].trim());

                    newMedia = tempMedia;
                } else
                {
                    Movie tempMedia = new Movie();

                    tempMedia.setTitle(lineTitle);
                    tempMedia.setYear(lineSplit[1].trim());
                    tempMedia.setAvg(lineSplit[3].trim());

                    if (charCheck == 'm' || charCheck == 'r')
                    {
                        tempMedia.setMovieLength(lineSplit[4].trim());
                    } else
                    {
                        tempMedia.setMovieLength("Undefined");
                    }
                    newMedia = tempMedia;
                }

                tempList.add(newMedia);
            }
        } catch (IOException e)
        {
            System.out.println("Something happened when reading the file!");
        }

        return tempList;
    }
}
