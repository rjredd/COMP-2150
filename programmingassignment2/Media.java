package programmingassignment2;

public abstract class Media
{
    private String title, year, averageRating;

    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    public void setYear(String newYear)
    {
        this.year = newYear;
    }

    public void setAvg(String newAvg)
    {
        this.averageRating = newAvg;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getYear()
    {
        return this.year;
    }

    public String getAvg()
    {
        return this.averageRating;
    }
    
    @Override
    public String toString()
    {
        return this.getTitle() + " (" + this.getYear() + ") | " + this.getAvg() + ", ";
    }
}
