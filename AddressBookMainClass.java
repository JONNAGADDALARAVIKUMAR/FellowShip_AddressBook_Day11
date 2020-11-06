package day11;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMainClass {
	static AddressBookManupulator familyAddressBook = new AddressBookManupulator();//family Address Book
	static AddressBookManupulator friendsAddressBook = new AddressBookManupulator();//Friends Address Book
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		HashMap<String, HashMap> addressBooks = new HashMap<String, HashMap>();//Stores Multiple Address Books
		HashMap<String, DetailsCollector> oneListContacts = new HashMap<String, DetailsCollector>();//Stores Single AddressBook
		
		
		System.out.println("\n\tWelcome to Address Book Progrem");
		
		
	       
	    while (true) {
	        System.out.println( "1: for family \n" +
	        					"2: for friend \n" +
	                    		"3: To Search\n" +
	        					"4: Exit");
	        int selectedOption = scan.nextInt();
	            
	        switch (selectedOption) {
	        case 1:
	        	oneListContacts = familyAddressBook.userChoice();
	            addressBooks.put("Family", oneListContacts);
	            break;
	        case 2:
	        	oneListContacts = friendsAddressBook.userChoice();	
	        	addressBooks.put("Friend", oneListContacts);   
	        	break;
	        case 3:
	        	search();
	        	break;
	        case 4:
	        	System.out.println("\n\tTerminated");
	        	break;
	        } 
	        if(selectedOption == 4)
	        	break;
	    }
	}

	private static void search() {
		
		 System.out.println("\n1.Search by City\n2.Search by State");
		 int search = scan.nextInt();
		 switch (search) {
		 
		    case 1:
		    	System.out.print("Enter City : ");
		    	String city = scan.next();
		    	System.out.println("COntacts in "+city+" are");
		    	familyAddressBook.searchByCity(city);
		    	friendsAddressBook.searchByCity(city);
		    	break;
		    case 2:
		    	System.out.print("Enter State : ");
		    	String state = scan.next();
		    	System.out.println("COntacts in "+state+" are");
		    	familyAddressBook.searchByState(state);
		    	friendsAddressBook.searchByState(state);
		    	break;
		    default:
		    	System.out.println("\nInvalid Entry\n");
		    	break;
		}		
	}
}
