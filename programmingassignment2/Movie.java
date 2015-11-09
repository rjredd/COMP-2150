package programmingassignment2;

public class Movie extends Media
{
    private String movieLength;
    
    public void setMovieLength(String newMovieLength)
    {
        this.movieLength = newMovieLength;
    }
    
    public String getMovieLength()
    {
        return this.movieLength;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + this.getMovieLength();
    }
}
