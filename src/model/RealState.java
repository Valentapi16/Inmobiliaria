package model;

import model.Building;
import model.Apartment;
import model.Person;
import model.TypePhone; 

public class RealState {
    
    public static final int ALL_APARTMENTS = 10;
    public static final int ALL_BUILDINGS = 5;
    public static final int ALL_PEOPLE = 20;

    private Building[] allBuildings;
    private Apartment[] allApartments;
    private Person[] allPerson;
    private Building building;
    private Apartment apartment;
    private Person person;
    private TypePhone typePhone;

    public RealState(){

		allBuildings = new Building[ALL_BUILDINGS];
		allApartments = new Apartment[ALL_APARTMENTS];
		allPerson =  new Person[ALL_PEOPLE]; 
	}

    public Building getBuilding(){
		return building;
	}
	public Apartment getApartment(){
		return apartment;
	}
	public Person getperson(){
		return person;
	}
	public Building[] getBuildings(){
		return allBuildings;
	}
	public Apartment[] getApartments(){
		return allApartments;
	}
	public Person[] getPersons(){
		return allPerson; 
	}
	public TypePhone getTypePhone(){
		return typePhone; 
	}
	public void setTypePhone(int typePhone){
		if(typePhone == 1 ){
			this.typePhone = TypePhone.HOME;
		} else if (typePhone ==2){
			this.typePhone = TypePhone.OFFICE;
		}else if(typePhone ==3){
			this.typePhone = TypePhone.MOVIL;
		}else if(typePhone ==4){
			this.typePhone = TypePhone.FAMILY;
		}else if(typePhone ==5){
			this.typePhone = TypePhone.OTHER; 
		}
	}

    public String createBuilding(String idBuilding, String location){

        String msj ="It is not possible to register this building";
        boolean isEmpty = false;
        Building newBuilding = new Building(idBuilding, location);
        for(int i = 0; i< ALL_BUILDINGS && !isEmpty; i ++){
            if(allBuildings[i]==null){
                allBuildings[i] = newBuilding;
                isEmpty = true;
                msj = "The Building has been register";
            }
        }
        return msj;
    }

    public int searchBuilding(String idBuilding){
        int pos = -1;
        boolean isFound = false;
        for(int i= 0; i<ALL_BUILDINGS && !isFound; i++){
            if(allBuildings[i] != null && allBuildings[i].getId().equalsIgnoreCase(idBuilding)){
               pos = i;
               isFound = true; 
            }
        }
        return pos;
    }

    public String createApartment(String idBuilding,String idApartment, int numberOfRooms, int numberOfBathRooms, boolean isThereBalcony, int monthlyValue){

        String msj ="It is not possible to register this apartment";
        boolean isEmpty = false;
        Apartment newApartment = new Apartment(monthlyValue, idBuilding, numberOfRooms, isThereBalcony, numberOfBathRooms, monthlyValue) ;
        for(int i = 0; i< ALL_APARTMENTS && !isEmpty; i ++){
            if(allApartments[i]==null){
                allApartments[i] = newApartment;
                isEmpty = true;
                msj = "The Building has been register";
            }
        }
        return msj;
    }

    public String registerApartmentToBuilding(String idBuilding, int idApartment, int numberOfRooms, int numberOfBathRooms, boolean isThereBalcony, int monthlyValue){
        String msj="";
        Apartment newApartment = new Apartment(idApartment, idBuilding, numberOfRooms, isThereBalcony, numberOfBathRooms, monthlyValue);
        int buildingPos= searchBuilding(idBuilding);
        if(buildingPos != -1){
            msj = allBuildings[buildingPos].addApartmentWithObject(newApartment);
        }else{
            msj = "This building doesnt exists";
        }
        return msj;
    }

    public String createOwner(int typeId, int id, String fullName, String contactNumber, int typePhone, int countNumber, String bankName, String idBuilding, int idApartment){

        String msj ="It is not possible to register an owner";
        boolean isEmpty = false;
        setTypePhone(typePhone);
        TypePhone phone = getTypePhone();
        Owner newOwner = new Owner(typeId, id, fullName, contactNumber, phone, countNumber, bankName, idBuilding, idApartment) ;
        for(int i = 0; i< ALL_PEOPLE && !isEmpty; i ++){
            if(allPerson[i] ==null){
                allPerson[i] = newOwner;
                isEmpty = true;
                msj = "The Owner has been register";
            }
        }
        return msj;
    }

    public String registerOwnerToApartment(int typeId, int id, String fullName, String contactNumber, int typePhone, int countNumber, String bankName, String idBuilding, int idApartment){
        String msj = "";
        setTypePhone(typePhone);
        TypePhone phone= getTypePhone();
        Owner newOwner = new Owner(typeId, id, fullName, contactNumber, phone, countNumber, bankName, idBuilding, idApartment);
        int buildingPos = searchBuilding(idBuilding);
        if(buildingPos !=-1){
            msj= allBuildings[buildingPos].addOwnerWithObject(newOwner, idApartment);
        }else{
            msj = "This owner doesnt exists";
        }
        return msj;
    }

    public String createTenant(int typeId, int id, String fullName, String contactNumber, int typePhone,String idBuilding, int idApartment){

        String msj ="It is not possible to register an owner";
        boolean isEmpty = false;
        setTypePhone(typePhone);
        TypePhone phone = getTypePhone();
        Tenant newTenant = new Tenant(typeId, id, fullName, contactNumber, phone, idBuilding, idApartment) ;
        for(int i = 0; i< ALL_PEOPLE && !isEmpty; i ++){
            if(allPerson[i] ==null){
                allPerson[i] = newTenant;
                isEmpty = true;
                msj = "The Owner has been register";
            }
        }
        return msj;
    }
    public String registerTenantToApartment(int typeId, int id, String fullName, String contactNumber, int typePhone, String idBuilding, int idApartment){
        String msj = "";
        setTypePhone(typePhone);
        TypePhone phone= getTypePhone();
        Tenant newtTenant = new Tenant(typeId, id, fullName, contactNumber, phone, idBuilding, idApartment);
        int buildingPos = searchBuilding(idBuilding);
        if(buildingPos !=-1){
            msj= allBuildings[buildingPos].addTenantWithObject(newtTenant, idApartment);
        }else{
            msj = "This Tenant doesnt exists";
        }
        return msj;
    }
    public String availableApartments(String idBuilding){

		String msj = "this building does not exist... "; 
		int posBuilding= searchBuilding(idBuilding); 

		if(posBuilding >=0){
			int amount= allBuildings[posBuilding].amountAvalible();
			msj = "the number of apartments available is... " + amount;
		}
		return msj; 
	}

    public String valueByApartmentsForBuilding(String idBuilding){
		String msj = "";
		int posBuilding = searchBuilding(idBuilding); 
		
		if(posBuilding >=0){
			int price= allBuildings[posBuilding].valueByApartments(); 
			msj = " the total value to receive for the apartments is ... " + price;
		}else{
			msj = "this building does not exist... "; 
		}
		
		return msj;
 	}


 	public String avalibleApartment(String idBuilding, int idApartment){

 		String msj = "";
		int posBuilding = searchBuilding(idBuilding);
		if(posBuilding <0){
			msj = "this building does not exist"; 
		} else{
			msj = allBuildings[posBuilding].availableApto(idApartment);
		}
		
		return msj; 

 	}
    

}
