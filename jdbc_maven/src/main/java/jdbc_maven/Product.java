package jdbc_maven;

public class Product {
	private int productid;
	private String name;
	private double price;
	private String manufacture;
	private double discount;
	private String warranty;
	private String mfd;
	private double gst;
	

	public Product() {
	}

//	public Product(int productid, String name, double price, String manufacture, double discount, String warranty,
//			String mfd, double gst) {
//		this.productid = productid;
//		this.name = name;
//		this.price = price;
//		this.manufacture = manufacture;
//		this.discount = discount;
//		this.warranty = warranty;
//		this.mfd = mfd;
//		this.gst = gst;
//	}
	
	@Override
	public String toString() {
		return "[productid=" + productid + "\n name=" + name + "\n price=" + price + "\n manufacture="
				+ manufacture + "\n discount=" + discount + "\n warranty=" + warranty + "\n mfd=" + mfd + "\n gst=" + gst
				+ "]";
	}

	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getWarranty() {
		return warranty;
	}
	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}
	public String getMfd() {
		return mfd;
	}
	public void setMfd(String mfd) {
		this.mfd = mfd;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	
	
	
}
