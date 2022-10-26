package model;

public class Owner extends Person {

    public String countNumber;
    public String bankName;

    public Owner(String typeId, String id, String fullName, String contactNumber, TypePhone typePhone, String countNumber, String bankName){
        super(typeId,id,fullName,contactNumber,typePhone);
        this.countNumber = countNumber;
        this.bankName = bankName;
    }
    
}
