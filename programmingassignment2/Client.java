package programmingassignment2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client
{

    public static void main(String[] args)
    {
        ArrayList<Media> masterList = NetflixFileReader.getList();
        ArrayList<Filter> filterList = new ArrayList<Filter>();

        Scanner keyboard = new Scanner(System.in);

        boolean runProgram = true;

        do
        {
            boolean addFilters = true;

            do
            {
                Filter newFilter = new Filter();

                System.out.print('\u000C');
                System.out.println("Please make a selection. (1-4)");
                System.out.println("1. Genre = Movie");
                System.out.println("2. Genre = Series");
                System.out.println("3. Search by Title");
                System.out.println("4. Year > ####");
                System.out.println("5. Year < ####");
                System.out.println("6. Rating > #.# Stars");
                System.out.println("7. Rating < #.# Stars");

                int field = keyboard.nextInt();

                switch (field)
                {
                case 1:
                    newFilter.setField("Genre");
                    newFilter.setRelation(0);
                    newFilter.setTarget("Movie");
                    break;
                case 2:
                    newFilter.setField("Genre");
                    newFilter.setRelation(0);
                    newFilter.setTarget("Series");
                    break;
                case 3:
                    newFilter.setField("Title");
                    newFilter.setRelation(0);

                    System.out.print('\u000C');
                    System.out.println(
                            "Please enter the title you wish to search for. (case sensitive)");
                    System.out
                            .println("!!!WARNING!!! include all punctuation!");
                    newFilter.setTarget(keyboard.nextLine());
                    break;
                case 4:
                    newFilter.setField("Year");
                    newFilter.setRelation(1);

                    System.out.print('\u000C');
                    System.out.println(
                            "Please enter year you wish to be the minimum case. (4-digit number)");
                    int minYear = keyboard.nextInt();

                    if (minYear < 1000 || minYear >= 10000)
                    {
                        enterToContinue("Your number is not a 4 digit number!");
                        continue;
                    }

                    newFilter.setTarget(minYear + "");
                    break;
                case 5:
                    newFilter.setField("Year");
                    newFilter.setRelation(-1);

                    System.out.print('\u000C');
                    System.out.println(
                            "Please enter year you wish to be the maximum case. (4-digit number)");
                    int maxYear = keyboard.nextInt();

                    if (maxYear < 1000 || maxYear >= 10000)
                    {
                        enterToContinue("Your number is not a 4 digit number!");
                        continue;
                    }

                    newFilter.setTarget(maxYear + "");
                    break;
                case 6:
                    newFilter.setField("Rating");
                    newFilter.setRelation(1);

                    System.out.print('\u000C');
                    System.out.println(
                            "Please enter the minimum avg rating. (0.0-5.0)");
                    double minStars = keyboard.nextDouble();

                    if (minStars < 0.0 || minStars > 5.0)
                    {
                        enterToContinue("Your input number is not applicable!");
                        continue;
                    }

                    newFilter.setTarget(minStars + "");
                    break;
                case 7:
                    newFilter.setField("Rating");
                    newFilter.setRelation(-1);

                    System.out.print('\u000C');
                    System.out.println(
                            "Please enter the maximum avg rating. (0.0-5.0)");
                    double maxStars = keyboard.nextDouble();

                    if (maxStars < 0.0 || maxStars > 5.0)
                    {
                        enterToContinue("Your input number is not applicable!");
                        continue;
                    }

                    newFilter.setTarget(maxStars + "");
                    break;
                default:
                    continue;
                }

                filterList.add(newFilter);

                System.out.print('\u000C');
                System.out.println(
                        "Would you like to add more filters? ('y' or 'n')");

                String answer = keyboard.next();
                answer.toLowerCase();

                if (answer == "y")
                {
                    // Do nothing, thus restarting the loop.
                } else if (answer == "n")
                {
                    System.out.print('\u000C');
                    System.out.println("Starting Search.");
                    addFilters = false;
                } else
                {
                    System.out.print('\u000C');
                    System.out.println(
                            "I don't know what you want to do, so I starting the search.");
                    addFilters = false;
                }

            } while (addFilters);

            ArrayList<Media> searchList = (ArrayList<Media>) masterList.clone();

//            for (int i = 0; i < masterList.size(); i++)
//                searchList.set(i, masterList.get(i));

            for (int i = 0; i < filterList.size(); i++)
            {
                if (searchList.isEmpty())
                {
                    enterToContinue("No items in list match your inquiry.");
                    break;
                }

                switch (filterList.get(i).getField())
                {
                case "Genre":
                    for (int j = 0; j < searchList.size(); j++)
                    {
                        if (!searchList.get(j).getType()
                                .equals(filterList.get(i).getTarget()))
                        {
                            searchList.remove(j);
                            System.out.println(searchList.get(j));
                        }
                    }
                    break;
                case "Title":
                    for (int j = 0; j < searchList.size(); j++)
                    {
                        if (!searchList.get(j).getTitle()
                                .equals(filterList.get(i).getTarget()))
                            searchList.remove(j);
                    }
                    break;
                case "Year":
                    for (int j = 0; j < searchList.size(); j++)
                    {
                        if (filterList.get(i).getRelation() > 0)
                        {
                            if (searchList.get(j).getYear().length() > 4)
                            {
                                String[] yearArray = searchList.get(j).getYear()
                                        .split("[-]");
                                
                                if (Integer.parseInt(yearArray[1]) < 
                                    Integer.parseInt(filterList.get(i).getTarget()))
                                    searchList.remove(j);
                            } else
                            {
                                if (Integer.parseInt(searchList.get(j).getYear()) < 
                                        Integer.parseInt(filterList.get(i).getTarget()))
                                        searchList.remove(j);
                            }
                        } else
                        {
                            if (searchList.get(j).getYear().length() > 4)
                            {
                                String[] yearArray = searchList.get(j).getYear()
                                        .split("[-]");
                                
                                if (Integer.parseInt(yearArray[0]) > 
                                    Integer.parseInt(filterList.get(i).getTarget()))
                                    searchList.remove(j);
                            } else
                            {
                                if (Integer.parseInt(searchList.get(j).getYear()) > 
                                        Integer.parseInt(filterList.get(i).getTarget()))
                                        searchList.remove(j);
                            }
                        }
                    }
                    break;
                case "Rating":
                    for (int j = 0; j < searchList.size(); j++)
                    {
                        searchList.get(j).setAvg(searchList.get(j).getAvg().replaceAll("[^\\d.]", ""));
                        System.out.println(searchList.get(j).getAvg());
                        System.out.println(searchList.get(j));
                        Double filterStars = Double.parseDouble(filterList.get(i).getTarget());
                        Double searchStars = Double.parseDouble(searchList.get(j).getAvg());
                        
                        if (filterList.get(i).getRelation() > 0)
                        {
                            if (searchStars < filterStars)
                                searchList.remove(j);
                        } else
                        {
                            if (searchStars > filterStars)
                                searchList.remove(j);
                        }
                    }
                    break;
                }
            }

            if (!searchList.isEmpty())
            {
                System.out.print('\u000C');
                System.out.println("Your Search Results:");
                
                for (int i = 0; i < searchList.size(); i++)
                    System.out.println(searchList.get(i));
            }

            System.out.print('\u000C');
            System.out.println(
                    "Would you like to do another search? ('y' or 'n')");

            String answer = keyboard.next();
            answer.toLowerCase();

            if (answer == "y")
            {
                // Do nothing, thus restarting the loop.
            } else if (answer == "n")
            {
                System.out.print('\u000C');
                System.out.println("Exiting.");
                runProgram = false;
            } else
            {
                System.out.print('\u000C');
                System.out.println(
                        "I don't know what you want to do, so I am exiting.");
                runProgram = false;
            }

        } while (runProgram);

        keyboard.close();
    }

    public static void enterToContinue(String message)
    {
        System.out.print('\u000C');
        System.out.println(message);

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Press enter to continue...");
        keyboard.nextLine();

        keyboard.close();
    }
}
