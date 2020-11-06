package day11;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMainClass 
{
	static AddressBookManupulator familyAddressBook = new AddressBookManupulator();//family Address Book
	static AddressBookManupulator friendsAddressBook = new AddressBookManupulator();//Friends Address Book
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		@SuppressWarnings("rawtypes")
		HashMap<String, HashMap> addressBooks = new HashMap<String, HashMap>();//Stores Multiple Address Books
		HashMap<String, DetailsCollector> oneListContacts = new HashMap<String, DetailsCollector>();//Stores Single AddressBook
		
		
		System.out.println("\n\tWelcome to Address Book Progrem");
		
		
	       
	    while (true) {
	        System.out.println("\n1: for family \n" +
	        					 "2: for friend \n" +
	                    		 "3: To Search\n" +
	        					 "4: TO Sort\n" +
	        					 "5: To Terminate");
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
	        	sort();
	        	break;
	        case 5:
	        	System.out.println("\n\tTerminated");
	        	break;
	        } 
	        if(selectedOption == 5)
	        	break;
	    }
	}

	private static void search() {
		
		 System.out.println("\n1.Search by City\n2.Search by State\n3.Count by City\n4.Count by State");
		 int search = scan.nextInt();
		 switch (search) {
		 
		    case 1:
		    	System.out.print("Enter City : ");
		    	String city = scan.next();
		    	System.out.println("Contacts in "+city+" are");
		    	familyAddressBook.searchByCity(city);
		    	friendsAddressBook.searchByCity(city);
		    	break;
		    case 2:
		    	System.out.print("Enter State : ");
		    	String state = scan.next();
		    	System.out.println("Contacts in "+state+" are");
		    	familyAddressBook.searchByState(state);
		    	friendsAddressBook.searchByState(state);
		    	break;
		    case 3:
		    	System.out.print("Enter City : ");
		    	String CityToCountContacts = scan.next();
		    	Long noOfFamilyContactsInCity = familyAddressBook.countByCity(CityToCountContacts);
		    	Long noOfFriendsContactsInCity = friendsAddressBook.countByCity(CityToCountContacts);
		    	System.out.println("\nNo of Contacts in "+CityToCountContacts+" are "+(noOfFamilyContactsInCity+noOfFriendsContactsInCity));
		    	break;
		    case 4:
		    	System.out.print("Enter State : ");
		    	String StateToCountContacts = scan.next();
		    	Long noOfFamilyContactsInState = familyAddressBook.countByState(StateToCountContacts);
		    	Long noOfFriendsContactsIntate = friendsAddressBook.countByState(StateToCountContacts);
		    	System.out.println("\nNo of Contacts in "+StateToCountContacts+" are "+(noOfFamilyContactsInState+noOfFriendsContactsIntate));
		    	break;
		    default:
		    	System.out.println("\nInvalid Entry\n");
		    	break;
		}		
	}
	private static void sort() { //Sorting
		
		System.out.println("\n1: Sort by First Name\n2: Sort by City\n3: Sort by State\n4: Sort by ZIP\n");
		int sortOption = scan.nextInt();
		
		boolean ifNotSorted = false;
		while(!ifNotSorted) {
			switch (sortOption) { 
		
				case 1: // Sorts by First Name
					System.out.println("\nSorted List of Contacts by First Name\n");
					familyAddressBook.sortByName();
					friendsAddressBook.sortByName();
					ifNotSorted = true;
					break;
				case 2: // Sorts by City
					System.out.println("\nSorted List of Contacts by City\n");
					familyAddressBook.sortByCity();
					friendsAddressBook.sortByCity();
					ifNotSorted = true;
					break;
				case 3: // Sorts by State
					System.out.println("\nSorted List of Contacts by State\n");
					familyAddressBook.sortByState();
					friendsAddressBook.sortByState();
					ifNotSorted = true;
					break;
				case 4: // Sorts by ZIP
					System.out.println("\nSorted List of Contacts by ZIP\n");
					familyAddressBook.sortByZip();
					friendsAddressBook.sortByZip();
					ifNotSorted = true;
					break;
				default :
					System.out.println("Enter Correct Option\n");
					sortOption = scan.nextInt();
					break;
			}
		}
	}
}
