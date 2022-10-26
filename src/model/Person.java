package model;

public class Person {

    public String typeId;
    public String id;
    public String fullName;
    public String contactNumber;
    public TypePhone typePhone;

    public Person(String typeId, String id, String fullName, String contactNumber, TypePhone typePhone){
        this.typeId = typeId;
        this.id = id;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.typePhone = typePhone;
    }


    
}
