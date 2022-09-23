package jdbc_maven;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMain {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		

		boolean b = true;
		while (b == true) {
			System.out.println(
					"choose from the list->->-> \n1..insert prodect\n2..update product\n3..delete product\n4..get product\n5..get all list\n6..exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("enter product id");
				int productid = scanner.nextInt();
				System.out.println("enter product name");
				String name = scanner.next();
				System.out.println("enter product price");
				double price = scanner.nextDouble();
				System.out.println("enter product manufacture");
				String manufacture = scanner.next();
				System.out.println("enter product discount");
				double discount = scanner.nextDouble();
				System.out.println("enter product waranty");
				String warranty = scanner.next();
				System.out.println("enter product date of manufacture ");
				String mfd = scanner.next();
				System.out.println("enter product gst ");
				double gst = scanner.nextDouble();

				Product p = new Product();
				ProductDAO pdao = new ProductDAO();
				p.setProductid(productid);
				p.setName(name);
				p.setPrice(price);
				p.setManufacture(manufacture);
				p.setDiscount(discount);
				p.setWarranty(warranty);
				p.setMfd(mfd);
				p.setGst(gst);
				Product r = pdao.insertProduct(p);
				System.out.println(r.getProductid() + " is Saved");
				break;
			}
			case 2: {
				System.out.println("enter product id");
				int productid = scanner.nextInt();
				System.out.println("enter product name");
				String name = scanner.next();
				Product p = new Product();
				ProductDAO pdao = new ProductDAO();
				p.setProductid(productid);
				p.setName(name);
				pdao.updateProduct(p);
				break;
			}
			case 3: {
				System.out.println("enter product id");
				int productid = scanner.nextInt();
				ProductDAO pdao = new ProductDAO();
				String result = pdao.deleteProduct(productid);
				System.out.println(result);
				break;
			}
			case 4:{
				System.out.println("enter product id");
				int productid = scanner.nextInt();
				ProductDAO pdao = new ProductDAO();
				Product product = pdao.getProduct(productid);
				System.out.println(product.getName());
				break;
			}
			case 5:{
				ProductDAO pdao = new ProductDAO();
				List l = pdao.getAllProduct();
				System.out.println(l);
				break;
			}
			case 6:{
				b=false;
				break;
			}

			}
		}

	}
}
