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

    public String addTenantWithObject(Tenant tenant, int idApartment){

		String msj = "Maximum capacity reached in this Building."; 
		boolean isEmpty = false; 
		for(int i = 0; i <ALL_APARTMENTS && !isEmpty; i++){
			if(apartments[i] != null && apartments[i].getIdApartment() == idApartment){
				apartments[i].setTenant(tenant);
				isEmpty = true; 
				msj = "The new Tenant has been register"; 
			} else{
				msj = "This Tenant does not exist"; 
			}
		}

		return msj; 
	}
    public int amountAvalible(){
		int amount =0; 
		for(int i=0; i < ALL_APARTMENTS; i++){
			if(apartments[i] == null){
				amount++; 
			}
		}
		return amount; 
	}
	/**
	 * valueByApartments: tells us the value for apartments 
	 * @return int: the total price of theapartments.
	 */

	public int valueByApartments(){
		int price = 0; 
		for(int i=0;i <ALL_APARTMENTS; i++){
			if(apartments[i] != null){
				price += apartments[i].getMonthlyValue(); 
			}
		}
		return price; 
	}
	/**
	 * avalibleApartment: say if a specific apartment is available or not . 
	 * @param idApartment: int: is the id of the apartment.
	 * @return msj: String: a confirm message.
	 */

	public String availableApto(int idApartment){
		String msj = ""; 
		int posApartment = searchApartment(idApartment); 
		if(posApartment < 0){
			msj = "this apartment does not exist"; 
		} else if( apartments[posApartment] != null &&  apartments[posApartment].getTenant() == null){
			msj= "the apartment is available";
		} else{
			msj = "the apartment isnot available"; 
		}

		return msj; 

	}

	public int searchApartment(int idApartment){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < ALL_APARTMENTS && !isFound; i++ ){
			if( apartments[i] != null && apartments[i].getIdApartment() == idApartment){
				pos = i; 
				isFound = true; 

			}
		}

		return pos; 
	}
}