package programmingassignment2;

public class Series extends Media
{
    private String episodeCount;

    public Series()
    {
        this.setType("Series");
    }
    
    public void setEpisodecount(String newEpisodeCount)
    {
        this.episodeCount = newEpisodeCount;
    }

    public String getEpisodeCount()
    {
        return episodeCount;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + this.getEpisodeCount();
    }
}
