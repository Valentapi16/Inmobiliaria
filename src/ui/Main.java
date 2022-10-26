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
		"<---o+o--->welcome to the Real Estate <---o+o--->\n\n" +
				"1. Register a bulding,\n" +
				"2. Register apartment.\n" +
				"3. Register owner.\n" + 
				"4. Register tenant.\n" +
				"5. consult how many apartments are available in a building.\n" +
				"6. consult the monthly value to receive for the rented apartments in a building.\n" +
				"7. consult if a particular apartment is available.\n" +
				"8. consult the number of apartments that a person has leased.\n" +
				"9. consult the total rental value a landlord would receive for the apartments he owns.\n" +
				"0. Exit. "; 

	}
	public void executeOption(int option){
		String msj, fullName, id, location, bankName = "";  
		int idApartment,numberOfRooms, numberOfBathRooms, isThereBalcony, typeId, contactNumber,countNumber = 0;
		int cellphoneType=0; 
		boolean hasBalcony = false;
		int priceApartment =0;  

		switch(option){
	
			case 1: 
				
            break;

			case 2:  
				

				break; 

			case 3: 
				
				
				
				break;

			case 4:

				


				break;

			case 5:
				

				break; 

			case 6:
				

				break;

			case 7: 
				

				break;

			case 8: 
			
				break; 

			case 9:
				

				break; 

			case 0: 
				System.out.println("Exit program.");
				break; 

			default: 
				System.out.println("Invalid Option");
				break; 
		}
	}
	/**
	 * validateIntegerOption: this method validates that the option entered by the user is actually an integer data type
	 * @return option: is a int option. 
	 */
	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}
	
}
