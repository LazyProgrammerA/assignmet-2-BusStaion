import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User implements Serializable {
	
	private ArrayList<Ticket> myTickets = new ArrayList<Ticket> ();
	private ArrayList<Trips> myTrips =new ArrayList<Trips>();
	
	private String name;
	private int ID;
	private String Password;
	
	public ArrayList<Trips> getMyTrips()
	{
		return myTrips;
		
	}
	
	
	public void addMyTrips(Trips trip)
	{
		myTrips.add(trip);
		
	}
	
	
	public void makeTicket (double price , String tripID , String type)
	{
		Ticket ticket = new Ticket();
		ticket.setPrice(price);
		ticket.setTripID(tripID);
		ticket.setType(type);
		
		if(myTickets.size() == 0)
			ticket.setTicketID(1);
		
		else ticket.setTicketID(myTickets.get(myTickets.size()-1).getTicketID()+1);
		
		myTickets.add(ticket);
		
		
	}
	
	
	public ArrayList<Ticket> getMyTickets()
	{
		return myTickets;
		
	}
	public void setname(String name){
		this.name=name;
	}
	
	public void setpassword(String password){
		this.Password=password;
	}
	
	public void setid(int id ){
		this.ID=id;
	}
public String getname() {
	return name;
}
public String getpassword() {
	return Password;
}
	
}
