package model;

public class Owner extends Person {

    public String countNumber;
    public String bankName;

    public Owner(String typeId, String id, String fullName, String contactNumber, TypePhone typePhone, String countNumber, String bankName, String idBuilding, int idApartment){
        super(typeId,id,fullName,contactNumber,typePhone, idBuilding, idApartment);
        this.countNumber = countNumber;
        this.bankName = bankName;
    }

    public String getCountNumber(){
        return countNumber;
    }

    public String getBankName(){
        return bankName;
    }
    
}
