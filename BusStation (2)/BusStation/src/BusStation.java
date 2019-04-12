import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class BusStation {
	
private ObservableList<Trips> tableTrips =FXCollections.observableArrayList(); // save contents of adminTable
private ObservableList<Vehicles> tableVehicles =FXCollections.observableArrayList();
private ObservableList<Driver> tableDrivers =FXCollections.observableArrayList();
private ObservableList<User> tableUser =FXCollections.observableArrayList();
private Manager manager ;
private int tripID ;
private int vehicleID ;
private int driverID ;
private int userID ;
private int ticketID ;
 
	
	public void saveAll() throws IOException
	{
	

				ObjectOutputStream out1 = new ObjectOutputStream(new FileOutputStream("Trips.txt"));
				ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("Vehicles.txt"));
				ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("Drivers.txt"));
				ObjectOutputStream out4 = new ObjectOutputStream(new FileOutputStream("Users.txt"));

				
				int size1 = tableTrips.size();
				int size2 = tableVehicles.size();
				int size3 = tableDrivers.size();
				int size4 = tableUser.size();
				int i =0;
				
				while(i<size1)
				{
					
					out1.writeObject(tableTrips.get(i));
					i++;
					
				}
				i=0;

				while(i<size2)
				{
					out2.writeObject(tableVehicles.get(i));
					i++;
					
				}
				
				i=0;
				while(i<size3)
				{
					
					out3.writeObject(tableDrivers.get(i));
					i++;
					
				}
				
				i=0;
				while(i<size4)
				{
					
					out4.writeObject(tableUser.get(i));
					i++;
					
				}
		
		
	}
	
	
	public void loadAll() throws IOException
	{

		ObjectInputStream in1 = new ObjectInputStream(new FileInputStream("Trips.txt"));
		ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("Vehicles.txt"));
		ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("Drivers.txt"));
		ObjectInputStream in4 = new ObjectInputStream(new FileInputStream("Users.txt"));
		
		
		while(true)
		{
			try { 
			Trips trip = (Trips)in1.readObject();
			tableTrips.add(trip);}
			
			catch (Exception eofe){ 
				break;
			}
		}
		
		
		
		while(true)
		{
			try { 
			Vehicles vehicle = (Vehicles)in2.readObject();
			tableVehicles.add(vehicle);}
			
			catch (Exception eofe){ 
				break;
			}
		}
		
		
		while(true)
		{
			try { 
			Driver driver = (Driver)in3.readObject();
			tableDrivers.add(driver);}
			
			catch (Exception eofe){ 
				break;
			}
		}
		
		
		while(true)
		{
			try { 
			User user = (User)in4.readObject();
			tableUser.add(user);}
			
			catch (Exception eofe){ 
				break;
			}
		}
		
		
		
		
		
	}
	public Manager getmanager(){
		return manager;
	}
	
	public void setmanager(){
		manager = new Manager("Mayar",8588,"0000");
	}
	
	
	
	public ObservableList<User> getTableUser()
	{
		return tableUser;
		
	}
	
	
	public void setTableUser(ObservableList<User> tableTrips)
	{
		this.tableUser =  tableUser;
		
	}
	
	
	
	public ObservableList<Trips> getTableTrips()
	{
		return tableTrips;
		
	}
	
	
	public void setTableTrips(ObservableList<Trips> tableTrips)
	{
		this.tableTrips =  tableTrips;
		
	}
	
	public ObservableList<Driver> getTableDriver()
	{
		return tableDrivers;
		
	}
	
	public void setTableDrivers(ObservableList<Driver> tableDrivers)
	{
		this.tableDrivers =  tableDrivers;
		
	}
	
	
	public ObservableList<Vehicles> getTableVehicles()
	{
		return tableVehicles;
		
	}
	
	public void setTableVehicles(ObservableList<Vehicles> tableVehicles)
	{
		this.tableVehicles =  tableVehicles;
		
	}
	

	
	public int updateAndGetVehicleID()
	{
		int i = tableVehicles.size()-1;
		if(i!=-1)
		vehicleID = tableVehicles.get(i).getVehicleID();
		else
			i=0;
		vehicleID++;
		return vehicleID;
		
	}
	
	public int updateAndGetUserID()
	{
	

		
		userID++;
		return userID;
		
	}
	
	public int updateAndGetTripID()
	{
		int i = tableTrips.size()-1;
		if(i!= -1)
		tripID = tableTrips.get(i).getTripID();
		else i=0;
		tripID++;
		return tripID;
		
	}
	
	public int updateAndGetdriverID()
	{
		int i = tableDrivers.size()-1;
		
		if(i!= -1)
		driverID = tableDrivers.get(i).getId();
		
		else
			i=0;
		driverID++;
		return driverID;
		
	}
	



}
