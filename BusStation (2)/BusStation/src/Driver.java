import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Driver extends Employee implements Serializable{
	private String tripID;
	private Trips trip = null;
	private boolean busy = false;
	
	
	
public Trips getTrip() {
		return trip ;
	}

	public void setTrip(Trips trip) {
	this.trip= trip;
}
	
	
public String getTripID() {
		return tripID ;
	}

	public void setTripid(String tripID) {
	this.tripID= tripID;
}

public boolean getBusy() {
	return busy ;
}
public void setBusy(Boolean busy) {
this.busy= busy;
}

}
