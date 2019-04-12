import java.io.Serializable;

public class Trips implements Serializable{
	private String source;
	private String destination;
	private int vehicleID;
	private String vehicleName;
	private double distance;
	private int seats;
	private String stops;
	private int tripID;
	private int driverID;
	private String driverName;
	private Vehicles vehicle;
	private Driver driver;
	
	private String type;
	


	
	public void setVehicle(Vehicles vehicle)
	{
		this.vehicle = vehicle;
	}
	
	public Vehicles getVehicle()
	{
		return vehicle;
	}
	
	

	
	public void setDriver(Driver driver)
	{
		this.driver = driver;
	}
	
	public Driver getDriver()
	{
		return driver;
	}

	
	
	
	
	public void setTripID(int tripID)
	{
		this.tripID = tripID;
	}
	
	public int getTripID()
	{
		return tripID;
	}
	
	
	public void setDistance(double distance)
	{
		this.distance = distance;
	}
	
	public double getDistance()
	{
		return distance;
	}

	public void setDriverID(int driverID)
	{
		this.driverID = driverID;
	}
	
	public int getDriverID()
	{
		return driverID;
	}
	
	public void setSeats(int seats)
	{
		this.seats = seats;
	}
	
	public int getSeats()
	{
		return seats;
	}
	
	
	
	public void setSource(String source)
	{
		this.source = source;
	}
	
	public String getSource()
	{
		return source;
	}

	
	public void setVehicleName(String vehicleName)
	{
		this.vehicleName = vehicleName;
	}
	
	public String getVehicleName()
	{
		return vehicleName;
	}
	

	public void setDriverName(String driverName)
	{
		this.driverName = driverName;
	}
	
	public String getDriverName()
	{
		return driverName;
	}

	
	
	public void setDestination(String destination)
	{
		this.destination = destination;
	}
	
	public String getDestination()
	{
		return destination;
	}

	
	public void setVehicleID(int vehicleID)
	{
		this.vehicleID = vehicleID;
	}
	
	public int getVehicleID()
	{
		return vehicleID;
	}

	
	public void setStops(String stops)
	{
		this.stops = stops;
	}
	
	public String getStops()
	{
		return stops;
	}

	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}

	
	

}
