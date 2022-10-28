package model;

public class Person {

    public int typeId;
    public int id;
    public String fullName;
    public String contactNumber;
    public TypePhone typePhone;
    private String idBuilding;
    private int idApartment;

    public Person(int typeId, int id, String fullName, String contactNumber, TypePhone typePhone, String idBuilding, int idApartment){
        this.typeId = typeId;
        this.id = id;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.typePhone = typePhone;
        this.idBuilding = idBuilding;
        this.idApartment = idApartment;
    }

    public int getTypeId(){
        return typeId;

    }

    public int getId(){
        return id;
    }

    public String getName(){
        return fullName;
    }

    public String contactNumber(){
        return contactNumber;
    }

    public TypePhone getTypePhone(){
        return typePhone;
    }

    public String getIdBuilding(){
        return idBuilding;
    }

    public int getIdApartment(){
        return idApartment;
    }


    
}
