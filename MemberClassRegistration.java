package lab.pkg4.gym.management.system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class MemberClassRegistration extends Line{
    private String memberId;
    private String classId;
    private String status;
    private LocalDate registrationDate;
    
    public MemberClassRegistration(String memberId,String classId,LocalDate registrationDate,String status)
    {
        this.classId=classId;
        this.memberId=memberId;
        this.registrationDate=registrationDate;
        this.status=status;
    }

    public String getMemberID ()
    {
        return this.memberId;
    }
    public String getClassID ()
    {
        return this.classId;
    }
    public LocalDate getRegistrationDate()
    {
        return this.registrationDate;
    }
    
    @Override
    public String lineRepresentation() {
        return this.memberId+","+this.classId+","+this.registrationDate+","+this.status;
    }

    @Override
    public String getSearchKey() {
        return this.memberId+this.classId;
        
    }
    
    
}
