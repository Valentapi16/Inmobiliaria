package model;

public class Owner extends Person {

    public int countNumber;
    public String bankName;

    public Owner(int typeId, int id, String fullName, String contactNumber, TypePhone typePhone, int countNumber, String bankName, String idBuilding, int idApartment){
        super(typeId,id,fullName,contactNumber,typePhone, idBuilding, idApartment);
        this.countNumber = countNumber;
        this.bankName = bankName;
    }

    public int getCountNumber(){
        return countNumber;
    }

    public String getBankName(){
        return bankName;
    }
    
}
