package jdbc_maven;

import java.util.Scanner;

public class DAOMain2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the id");
		int id = scanner.nextInt();
//		System.out.println("enter the name");
//		String name = scanner.next();
//		System.out.println("enter the address");
//		String address = scanner.next();
//		System.out.println("enter phonenumber");
//		long phone = scanner.nextLong();
//		System.out.println("enter pincode");
//		int pin = scanner.nextInt();
//		Person person = new Person();
		DAO dao = new DAO();
//		person.setId(id);
//		person.setName(name);
//		person.setAddress(address);
//		person.setPhone(phone);
//		person.setPin(pin);
		// dao.updatePersonObj(person);

		// dao.savedPersonObj(person);
		Person person = dao.getPersonObj(id);
		System.out.println(person.getId());
		System.out.println(person.getName());
		System.out.println(person.getAddress());
		System.out.println(person.getPhone());
		System.out.println(person.getPin());

	}
}
