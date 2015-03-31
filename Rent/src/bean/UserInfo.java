package bean;


public class UserInfo{
	//adding more attributes
    private int userid;
    private String username ;
    private String password;
    private String address;
    private String name;
    private String email;

    //default constructor
    public UserInfo(){
    }
    
    //constructor
    public UserInfo(int userid, String username, String password, String address, String name, String email){
    	this.userid = userid;
    	this.username = username;
    	this.password = password;
    	this.address = address;
    	this.name = name;
    	this.email = email;
    }
    
    public void setUserId(int userid){
    	this.userid = userid;
    }
    public int getUserId(){
    	return this.userid;
    }
    
    public void setUserName(String username){
    	this.username = username;
    }
    public String getUserName(){
    	return this.username;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
    public String getPassword(){
    	return this.password;
    }
    
    public void setAddress(String address){
    	this.address = address;
    }
    public String getAddress(){
    	return this.address;
    }
 
    //first + last??
    public void setName(String name){
    	this.name = name;
    }
    public String getName(){
    	return this.name;
    }
    
    public void setEmail(String email){
    	this.email = email;
    }
    public String getEmail(){
    	return this.email;
    }
}