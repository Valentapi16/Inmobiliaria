package ui;

import java.util.Scanner;
import model.RealState;

public class Main{


	private Scanner reader; 
	private RealState realState; 

	public Main(){
		reader = new Scanner(System.in); 
		realState  = new RealState(); 

	}
	
	
	public RealState getRealState(){
		return realState; 
	}

	
	public Scanner getReader(){
		return reader;
	}

	public static void main(String[] args){
		Main main = new Main(); 
		int option = 0; 
		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);
					

		}while(option != 0);

		main.getReader().close();
	}

	
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println(printMenu());
		option = validateIntegerOption();
		return option; 
	}
	public String printMenu(){
		return 
		"<<<<<Welcome to the Real Estate>>>>> \n\n" +
				"1. Register a bulding\n" +
				"2. Register apartment.\n" +
				"3. Register owner.\n" + 
				"4. Register tenant.\n" +
				"5. consult how many apartments are available in a building.\n" +
				"6. consult the monthly value to receive for the rented apartments in a building.\n" +
				"7. consult if a particular apartment is available.\n" +
				"0. Exit. "; 

	}
	public void executeOption(int option){
		String msj, fullName,idBuilding, location, bankName = "";  
		int idApartment,id,typePhone,typeId,monthlyValue,numberOfRooms, numberOfBathRooms,balcony,countNumber = 0;
		// voy a cambiar el tipo de dato con el que representas el contactNumber, por un long 
		// que es un valor entero ... pero mas grande. 
		long contactNumber = 0;
		boolean isThereBalcony = false;


		switch(option){
	
			case 1: 
            System.out.println("If you want to register a building, enter the building id:");
            idBuilding = reader.next();
            System.out.println("Enter the location that will have the apartments");
            location = reader.next();
            msj = realState.createBuilding(idBuilding, location);
			
            System.out.println(msj);
            break;

			case 2:
				System.out.println("Enter the id building of the apartment");
				idBuilding = reader.next();
				System.out.println("Enter the apartment id:");
				idApartment = validateIntegerOption();
				System.out.println(idApartment);
				if(idApartment<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}
				System.out.println("How many rooms will have the apartment: ");
				numberOfRooms = validateIntegerOption();  

				if(numberOfRooms<0){
					System.out.println("Only valid options please "); 
					break;

				}
				System.out.println("How many bathrooms will have the apartment: ");
				numberOfBathRooms = validateIntegerOption(); 
				if(numberOfBathRooms<0){
					System.out.println("Only valid options please"); 
					break;

				}
				System.out.println("If the apartment has balcony, digit 1 yes or 2 not"); 
				balcony= validateIntegerOption(); 

				if(balcony>2 || balcony<= 0){
					System.out.println("Only valid options please\n"); 
					break; 
				} else if( balcony == 1){
					isThereBalcony = true; 

				} else if( balcony == 2 ){
					isThereBalcony = false; 
				}
				System.out.println("How much is the price of the rental");
				monthlyValue = validateIntegerOption(); 

				if(monthlyValue<0){
					System.out.println("enter a valid option.... xD"); 
					break;

				}


				msj = realState.registerApartmentToBuilding(idBuilding, idApartment, numberOfRooms, numberOfBathRooms, isThereBalcony, monthlyValue);
				realState.createApartment(idBuilding, bankName, numberOfRooms, numberOfBathRooms, isThereBalcony, monthlyValue);
				
				System.out.println(msj);  
				
				break; 

			case 3: 
               System.out.println("Digit the typeId, 1 CC, 2 NIT, 3 NIP, 4 CE, 5 Other"); 
                typeId= validateIntegerOption(); 

                if(typeId > 5 || typeId <=0){
                System.out.println("Only valid options\n");
                break;
                }
				// acá, estas pidiendo un id que entiendo yo es el id del owner
				// en el constructor del owner el id es un String no un entero acá hay una 
				// incosistencia con los tipos de datos. 
				System.out.println("Digit the identification number: ");
				id = validateIntegerOption();

				if(id<0){
					System.out.println("Only valid options please"); 
					break;

				}
				System.out.println("Which is the name of the owner: \n");
				fullName = reader.next();
				// acá pasa lo mismo, le pides el número de contacto y lo validas como
				// un entero pero en el constructor es un String 
				// Ahora, el error que me manifiestas es porque el tipo de dato con el que 
				// representas la información es un int, y el valor que le pasas por consola 
				// (de mas de 10 digitos) es muy pequeño para poder representarlo 
				// por eso usamos un valor entero mas grande, un long 
				System.out.println("Digit the contact number:");
				contactNumber = validateLongOption();

				if(contactNumber<0){
					System.out.println("Only valid options"); 
					break;

				}
				System.out.println("Digit the phone type, 1 Home, 2 Office, 3 Movil, 4 Family, 5 Other"); 
				typePhone= validateIntegerOption(); 

				if(typePhone >5 || typePhone <=0){
					System.out.println("Only valid options\n");
					break;
				}
				System.out.println("Digit the account number");
				countNumber = validateIntegerOption(); 
                System.out.println("Enter the location that will have the apartments");
                location = reader.next();
				if(countNumber<0){
					System.out.println("Only valid options"); 
					break;

				}
				System.out.println("Digit the bank name");
				bankName = reader.next();
				System.out.println("Digit the id building of the apartment is located");
				idBuilding= reader.next();
				System.out.println("Digit the apartment identification");
				idApartment = validateIntegerOption();

				if(idApartment<0){
					System.out.println("Only valid options"); 
					break;

				} 
				
	
				msj = realState.registerOwnerToApartment(typeId, idBuilding, fullName, fullName, typePhone, location, bankName, idBuilding, idApartment);
				// estas pasando dos veces el atributu idBuilding, el owner debería recivir un String id,
				// en el segundo párametro 
				realState.createOwner(typeId, idBuilding, fullName, fullName, typePhone, location, bankName, idBuilding, idApartment);
				
				System.out.println(msj);

				break;

			case 4:
                System.out.println("Digit the typeId, 1 CC, 2 NIT, 3 NIP, 4 CE, 5 Other"); 
                typeId= validateIntegerOption(); 

                if(typeId >5 || typeId <=0){
                System.out.println("Only valid options\n");
                break;
                }
				System.out.println("type the document number ");
				id = validateIntegerOption();

				if(id<0){
					System.out.println("Only valid options"); 
					break;

				}
				System.out.println("Write the tenants name: ");
				fullName = reader.next();
				System.out.println("Digit contact number");
				contactNumber = validateIntegerOption();
				if(contactNumber<0){
					System.out.println("Only valid options"); 
					break;

				}
				System.out.println("Digit the phone type, 1 home, 2 office, 3 movil, 4 family, 5 other"); 
				typePhone= validateIntegerOption(); 

				if(typePhone >5 || typePhone <=0){
					System.out.println("this isnot a valid option\n");
					break;
				}

				System.out.println("type the building id where is the apartment");
				idBuilding= reader.next();
				System.out.println("Digit the apartment id: ");
				idApartment = validateIntegerOption();

				if(idApartment<0){
					System.out.println("Only valid options"); 
					break;

				}

				msj = realState.registerTenantToApartment(typeId, idBuilding, fullName, bankName, typePhone, idBuilding, idApartment);
				System.out.println(msj); 
				break;

			case 5:
             System.out.println("This is the option for the amount of apartments available\n");
             System.out.println("Digit id building");
             idBuilding = reader.next(); 

             msj = realState.availableApartments(idBuilding);
             System.out.println(msj);

				break; 

			case 6:
                System.out.println(" the total monthly value to receive for the apartments\n"); 
				System.out.println("type id building");
				idBuilding = reader.next();

				msj = realState.valueByApartmentsForBuilding(idBuilding);
				System.out.println(msj); 

				

				break;

			case 7: 
				System.out.println("Digit the id building of the aparment located");
				idBuilding = reader.next();
				System.out.println("Digit id apartment");
				idApartment = validateIntegerOption();

				if(idApartment<0){
					System.out.println("Only valid options"); 
					break;

				}

				msj = realState.avalibleApartment(idBuilding, idApartment);
				System.out.println(msj); 
				

				break;

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}
	
	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}


	// este método valida si la entrada del 
	// reader es un tipo de dato long 
	public long validateLongOption(){
		long option = 0; 

		if(reader.hasNextLong()){
			option = reader.nextLong(); 
		}
		else{
 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}
	
}
