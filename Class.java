package trainer;


public class Class extends Line {
    private String classId;
    private String className;
    private String trainId;
    private int duration;
    private int availableSeats;
    Class(String classId,String className,String trainId,int duration,int availableSeats)
    {
        this.classId=classId;
        this.className=className;
        this.trainId=trainId;
        this.duration=duration;
        this.availableSeats=availableSeats;
    }
    public int getAvailableSeats ()
    {
        return this.availableSeats;
    }
    public void setAvailableSeats (int availableSeats)
    {
        this.availableSeats=availableSeats;
    }

    @Override
    public String lineRepresentation() {
        return this.classId+","+this.className+","+this.trainId+","+this.duration+","+this.availableSeats;
    }

    @Override
    String getSearchKey() {
        return this.classId;
    }
    
}
