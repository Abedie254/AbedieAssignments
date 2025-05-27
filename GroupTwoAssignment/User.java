public class User extends BaseModel{
	public String name;
	public Long idNumber;
	public String email;
	public String password;

	public User(String name, Long idNumber, String email, String password){
		this.name = name;
		this.idNumber = idNumber;
		this.email = email;
		this.password = password;
	}
	public User(){}

	public Long getId(){
		return this.id;
	}
	public Long getIdNumber(){
		return idNumber;
	}
	public void setIdNumber(Long idNumber){
		this.idNumber = idNumber;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String Password){
		this.password = Password;
	}
}
