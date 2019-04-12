import java.io.Serializable;

public class Vehicles implements Serializable {
	
	private String name;
	private int seats;
	private int capacity;
	private boolean busy = false;
	private int vehicleID;
	private String tripID ;
	

	public String getName ()
	{
		
		return name;
	}
	
	public void setName (String name)
	{
		
		this.name = name;
	}
	
	
	public String getTripID ()
	{

		return tripID;
	}
	
	public void setTripID (String tripID)
	{
		
		this.tripID = tripID;
	}
	
	
	
	public int getSeats ()
	{
		
		return seats;
	}
	
	public void setSeats (int seats)
	{
		
		this.seats = seats;
	}
	
	
	public int getcapacity ()
	{
		
		return capacity;
	}
	
	public void setCapacity (int capacity)
	{
		
		this.capacity = capacity;
	}

	
	
	public boolean getBusy ()
	{
		
		return busy;
	}
	
	public void setBusy (boolean busy)
	{
		
		this.busy = busy;
	}
	
	public int getVehicleID ()
	{
		
		return vehicleID;
	}
	
	public void setVehicleID (int vehicleID)
	{
		
		this.vehicleID = vehicleID;
	}
	
	
	
	
	
	
	
}
