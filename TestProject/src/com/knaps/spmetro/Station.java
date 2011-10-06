package com.knaps.spmetro;

import java.util.ArrayList;

import com.knaps.spmetro.Enums.LineStatus;

public class Station implements AlertObserver {
	private int id;
	private String displayName;
	private String mapURI;
	private boolean	bikeRack;
	private boolean bikeLoan;
	private boolean bikePark;
	private boolean elevator;
	private boolean parking;
	private long latitude;
	private long longitude;
	private ArrayList<Alert> alerts;
	private LineStatus status;
	private ArrayList<Line> lines;
	private ObservationSubject alertUpdates;
	
	public Station(int id, ObservationSubject o){
		//Register for Alert Updates
		this.alertUpdates = o;
		alertUpdates.registerObserver(this);
		
		this.id = id;
		setLines(myDB.getLinesByStation(id));	
	}
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setMapURI(String mapURI) {
		this.mapURI = mapURI;
	}

	public String getMapURI() {
		return mapURI;
	}

	public void setBikeRack(boolean bikeRack) {
		this.bikeRack = bikeRack;
	}

	public boolean isBikeRack() {
		return bikeRack;
	}

	public void setBikeLoan(boolean bikeLoan) {
		this.bikeLoan = bikeLoan;
	}

	public boolean isBikeLoan() {
		return bikeLoan;
	}

	public void setBikePark(boolean bikePark) {
		this.bikePark = bikePark;
	}

	public boolean isBikePark() {
		return bikePark;
	}

	public void setElevator(boolean elevator) {
		this.elevator = elevator;
	}

	public boolean isElevator() {
		return elevator;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isParking() {
		return parking;
	}

	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}

	public long getLatitude() {
		return latitude;
	}

	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}

	public long getLongitude() {
		return longitude;
	}

	public void setAlerts(ArrayList<Alert> alerts) {
		this.alerts = alerts;
	}

	public ArrayList<Alert> getAlerts() {
		return alerts;
	}

	public void setStatus(LineStatus status) {
		this.status = status;
	}

	public LineStatus getStatus() {
		return status;
	}

	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}
	public ArrayList<Line> getLines() {
		return lines;
	}
	@Override
	public void updateStatus(ObservationSubject o) {
		// TODO Auto-generated method stub
		if (o instanceof AlertSubject){
			alertUpdates = (AlertSubject)o;
			setAlerts(((AlertSubject) o).getAlerts());
			displayNewAlerts();
		}
		
	}
	public void displayNewAlerts() {
		// TODO display New Alerts
		
	}
	
	public void showMap() {
		// TODO Show station map (redirect to show map activity)
	}
	
	public boolean isOpen() {
		return statusUtility.isOpen(this);
	}

}
