package backend;

public class Member extends User {
    private String memberId;
    private String name;
    private String membershipType;
    private String email;
    private String phoneNumber;
    private String status;

    public Member(String memberId, String name, String membershipType, String email, String phoneNumber, String status) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.membershipType=membershipType;
        this.memberId=memberId;
        this.status=status;
    }

    @Override
    public String lineRepresentation() {
        return this.memberId+","+this.name+","+this.membershipType+","+this.email+","+this.phoneNumber+","+this.status;
    }

    @Override
    public String getSearchKey() {
       return this.memberId;
    }
    
}
