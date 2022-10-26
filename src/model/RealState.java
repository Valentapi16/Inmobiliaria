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
}
