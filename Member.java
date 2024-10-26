package trainer;


public class Member extends User {
    private String memberId;
    private String membershipType;
    private String status;

    public Member(String name, String email, String phoneNumber) {
        super(name, email, phoneNumber);
        this.membershipType=membershipType;
        this.memberId=memberId;
        this.status=status;
    }

    @Override
    String lineRepresentation() {
        return this.memberId+","+this.name+","+this.membershipType+","+this.email+","+this.phoneNumber+","+this.status;
    }

    @Override
    String getSearchKey() {
       return this.memberId;
    }
    
}
