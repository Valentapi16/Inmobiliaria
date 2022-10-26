package model;

import model.Apartment;

public class Building {

    public static final int ALL_APARTMENTS = 10;

    private String id;
    private String location;

    private Apartment[] apartments;
    private Apartment apartment;

    public Building(String id, String location){
        this.id = id;
        this.location = location;

        apartments = new Apartment[ALL_APARTMENTS];
    }

    public Apartment[] getApartments(){
		return apartments; 
	}

	public Apartment getApartment(){
		return apartment; 
	}
	public String getId(){
		return id; 
	}

    public String addApartmentWithObject(Apartment apartment){

		String msj = "There are no more apartments available"; 
		boolean isEmpty = false; 
		for(int i = 0; i <ALL_APARTMENTS && !isEmpty; i++){
			if(apartments[i] == null){
				apartments[i] = apartment; 
				isEmpty = true; 
				msj = "The new apartment has been registered"; 
			}
		}

		return msj; 
	}

    public String addOwnerWithObject(Owner owner, int idApartment){

		String msj = "Maximum capacity reached in this Building."; 
		boolean isEmpty = false; 
		for(int i = 0; i <ALL_APARTMENTS && !isEmpty; i++){
			if(apartments[i] != null && apartments[i].getIdApartment() == idApartment){
				apartments[i].setOwner(owner); 
				isEmpty = true; 
				msj = "The new owner has been register"; 
			} else{
				msj = "this apartment does not exist"; 
			}
		}

		return msj; 
	}
}