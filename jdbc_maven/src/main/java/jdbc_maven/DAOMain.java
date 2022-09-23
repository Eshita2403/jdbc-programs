package jdbc_maven;

import java.util.Scanner;

public class DAOMain {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
//	System.out.println("enter the id");
//	int id =scanner.nextInt();
//	System.out.println("enter the name");
//	String name = scanner.next();
//	System.out.println("enter the address");
//	String address = scanner.next();
//	System.out.println("enter phonenumber");
//	long phone = scanner.nextLong();
//	System.out.println("enter pincode");
//	int pin =scanner.nextInt();
	
	DAO dao = new DAO();
	boolean b = true;
	while(b) {
		System.out.println("choose from the given list \n1..insert person\n2..update person\n3..delete person\n4..get person");
		int choice = scanner.nextInt();
		switch(choice) {
		case 1:{
			System.out.println("enter the id");
			int id =scanner.nextInt();
			System.out.println("enter the name");
			String name = scanner.next();
			System.out.println("enter the address");
			String address = scanner.next();
			System.out.println("enter phonenumber");
			long phone = scanner.nextLong();
			System.out.println("enter pincode");
			int pin =scanner.nextInt();
			String result = dao.savedPerson(id, name, address, phone, pin);
			System.out.println(result);
			break;
			}
			
		case 2:{
			System.out.println("enter the id to be updated");
			int id =scanner.nextInt();
			System.out.println("enter the name");
			String name = scanner.next();
			System.out.println("enter the address");
			String address = scanner.next();
			System.out.println("enter phonenumber");
			long phone = scanner.nextLong();
			System.out.println("enter pincode");
			int pin =scanner.nextInt();
			String result1 = dao.updatePerson(id, name, address, phone, pin);
			System.out.println(result1);
			break;
			}
		case 3:{
			System.out.println("enter the id to delete");
			int id =scanner.nextInt();
			dao.deletePerson(id);
			break;
			
			 }
		case 4:{
			System.out.println("enter the id");
			int id =scanner.nextInt();
			String result1 = dao.getPerson(id);
			System.out.println(result1);
			break;
			}
		
		default: b=false;
			
		 
		}
	}
	
	

	
	
}
}
