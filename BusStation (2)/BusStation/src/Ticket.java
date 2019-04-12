import java.io.Serializable;

public class Ticket implements Serializable {
	private String type;
	private double price;
	private String tripID;
	private int ticketID;
	
	
	
	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public String getType()
	{
		return type;
		
	}

	public void setType(String type)
	{
		this.type = type;
		
	}
	

	public double getPrice()
	{
		return price;
		
	}

	public void setPrice(double price)
	{
		this.price = price;
		
	}
	
	
	public String getTripID()
	{
		return tripID;
		
	}

	public void setTripID(String tripID)
	{
		this.tripID = tripID;
		
	}
}
