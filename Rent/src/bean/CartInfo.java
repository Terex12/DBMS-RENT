package bean;

public class CartInfo {
	
	private int proid;		//product id
	private int userid;
	private String proname;
	private float price;
	private int number;
	
	public CartInfo(){
		
	}

	public int getId() {
		return proid;
	}

	public void setId(int id) {
		this.proid = id;
	}


	public int getUserId() {
		return userid;
	}
	public void setUserId(int uid) {
		this.userid = uid;
	}
	
	public String getProductName() {
		return proname;
	}

	public void setProductName(String proname) {
		this.proname = proname;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return number;
	}

	public void setQuantity(int number) {
		this.number = number;
	}

}