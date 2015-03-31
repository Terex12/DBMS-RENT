package bean;


public class ProductInfo{
	private int proid;
	private int cateid;
	private String proname;
	private float price;
	private int sold;
	private int stock;
	private int rate;
	private String pic;
	
	 //default constructor
	public ProductInfo(){
		
	}
	
	//constructor
	public ProductInfo(int proid, int cateid, String proname, float price, int sold, int stock, int rate, String pic){
		this.proid = proid;
		this.cateid = cateid;
		this.proname = proname;
		this.price = price;
		this.sold = sold;
		this.stock = stock;
		this.rate = rate;	//0~5
		this.pic = pic;
	}
	
	public void setProId(int proid){
		this.proid = proid;
	}
	public int getProId(){
		return this.proid;
	}
	
	public void setCateId(int cateid){
		this.cateid = cateid;
	}
	public int getCateId(){
		return this.cateid;
	}
	
	public void setProName(String proname){
		this.proname = proname;
	}
	public String getProName(){
		return this.proname;
	}
	
	public void setPrice(float price){
		this.price = price;
	}
	public float getPrice(){
		return this.price;
	}
	
	public void setSold(int sold){
		this.sold = sold;
	}
	public int getSold(){
		return this.sold;
	}
	
	public void setStock(int stock){
		this.stock = stock;
	}
	public int getStock(){
		return this.stock;
	}
	
	public void setRate(int rate){
		this.rate = rate;
	}
	public int getRate(){
		return this.rate;
	} 
	
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}