package jdbc_maven;

import java.util.Scanner;

public class MobileDOADriver {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter mobile id");
		int id = scanner.nextInt();
//		System.out.println("enter mobile name");
//		String name= scanner.next();
//		System.out.println("enter mobile brand");
//		String brand= scanner.next();
//		System.out.println("enter mobile color");
//		String color= scanner.next();
//		System.out.println("enter mobile price");
//		double price= scanner.nextDouble();
//		System.out.println("enter mobile ram");
//		int ram = scanner.nextInt();
//		System.out.println("enter mobile manufacture");
//		String manufacture= scanner.next();
		Mobile m = new Mobile();
		MobileDOA md = new MobileDOA();		
		 m.setId(id);
//		 m.setName(name);
//		 m.setBrand(brand);
//		 m.setColor(color);
//		 m.setPrice(price);
//		 m.setRam(ram);
//		 m.setManufacturer(manufacture);
		 
		// md.insertMobileObj(m);
		 //md.updateMobileObj(m);
		 Mobile mob = md.deleteMobileObj(id);
		//System.out.println(mob.getName());;
		//Mobile mob1 =md.getMobileObj(id);
		//System.out.println(mob1.getName());;
		 
		 
		
	}
	
	
}
