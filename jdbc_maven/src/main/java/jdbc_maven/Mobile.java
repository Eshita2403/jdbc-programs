package jdbc_maven;

public class Mobile {
private int id;
private String name;
private String brand;
private String color;
private double price;
private int ram;
private String manufacturer;



public Mobile(int id, String name, String brand, String color, double price, int ram, String manufacturer) {

	this.id = id;
	this.name = name;
	this.brand = brand;
	this.color = color;
	this.price = price;
	this.ram = ram;
	this.manufacturer = manufacturer;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getRam() {
	return ram;
}
public void setRam(int ram) {
	this.ram = ram;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
@Override
public String toString() {
	return "[id=" + id + ", name=" + name + "\n brand=" + brand + "\n color=" + color + "\n price=" + price
			+ "\n ram=" + ram + "\n manufacturer=" + manufacturer + "]";
}

}
