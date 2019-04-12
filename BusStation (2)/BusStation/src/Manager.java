import java.io.Serializable;

public class Manager extends Employee implements Serializable {
 
	
	public  Manager(String name,int id ,String password) {
		this.name=name;
		this.id=id;
		this.password=password;
	}
}
