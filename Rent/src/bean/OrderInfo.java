package bean;

public class OrderInfo{
	private int oid;
	private String username;
	private int userid;
	private String proname;
	private int proid;
	private int quantity;
	private float price;
	private float sum;
	private int rate;
	
	 //default constructor
	public OrderInfo(){
	}
	
	public int getOrderid(){
		return this.oid;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsename(){
		return this.username;
	}
	
	public void setUserid(int userid){
		this.userid = userid;
	}
	public int getUseid(){
		return this.userid;
	}
	
	public void setProname(String proname){
		this.proname = proname;
	}
	public String getProname(){
		return this.proname;
	}
	
	public void setProid(int proid){
		this.proid = proid;
	}
	public int getProid(){
		return this.proid;
	}
	
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}
	public int getQuantity(){
		return this.quantity;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	public float getPrice(){
		return this.price;
	}
	
	public void setSum(float sum){
		this.sum = sum;
	}
	public float getSum(){
		return this.sum;
	}
	
	public void setRate(int rate){
		this.rate = rate;
	}
	public int getRate(){
		return this.rate;
	}
	
	
	
}