package backend;

import java.time.LocalDate;

public class MemberClassRegistration extends Line{
    private String memberId;
    private String classId;
    private String status;
    private LocalDate registrationDate;
    
//    CONSTRUCTOR
    public MemberClassRegistration(String memberId,String classId,LocalDate registrationDate,String status)
    {
        this.classId=classId;
        this.memberId=memberId;
        this.registrationDate=registrationDate;
        this.status=status;
    }
    
//    SETTERS & GETTERS
    public void setRegistrationStatus(String status){
        this.status = status;
    }
    public LocalDate getRegistrationDate(){
        return this.registrationDate;
    }
    public String getMemberID ()
    {
        return this.memberId;
    }
    public String getClassID ()
    {
        return this.classId;
    }

//    METHODS
    
    @Override
    public String lineRepresentation() {
        return this.memberId+","+this.classId+","+this.registrationDate+","+this.status;
    }

    @Override
    public String getSearchKey() {
        return this.memberId+this.classId;
        
    }
    
    
}
