package model;

import model.Owner;
import model.Tenant;

public class Apartment {

    public int idApartment;
    public String idBuilding;
    public int numberOfRooms;
    public int numberOfBathRooms;
    public boolean isThereBalcony;
    public double monthlyValue;
    private Owner owner;
    private Tenant tenant;

    public Apartment(int idApartment, String idBuilding,int numberOfRooms,boolean isThereBalcony,int numberOfBathRooms, double monthlyValue){
        this.idApartment = idApartment;
        this.idBuilding = idBuilding;
        this.numberOfRooms = numberOfRooms;
        this.numberOfBathRooms = numberOfBathRooms;
        this.isThereBalcony = isThereBalcony;
        this.monthlyValue = monthlyValue;

    }

    public String getIdBuilding(){
		return idBuilding; 
	}

	public int getIdApartment(){
		return idApartment;
	}

	public int getNumberaOfRooms(){
		return numberOfRooms;
	}

	public int getNumberOfBathrooms(){
		return numberOfBathRooms;
	}

	public boolean getBalcony(){
		return isThereBalcony;
	}
	public double getMonthlyValue(){
		return monthlyValue; 
	}
	public Owner getOwner(){
		return owner;
	} 
	public Tenant getTenant(){
		return tenant; 
	}
	public void setOwner(Owner owner){
		this.owner = owner; 
	}
	public void setTenant(Tenant tenant){
		this.tenant = tenant;
	}
    
}
