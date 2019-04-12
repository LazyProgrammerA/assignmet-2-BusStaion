import java.io.Serializable;

public abstract  class Employee implements Serializable{
	protected String name;
	protected int id;
	protected String password;
	
	
	public String getName() {
		return name ;
	}
public void setName(String name) {
	this.name= name;
}

public int getId() {
	return id ;
}
public void setID(int id ) {
this.id= id;
}

public String getPassword() {
	return password ;
}
public void setPassword(String password) {
this.password=password;
}




}
