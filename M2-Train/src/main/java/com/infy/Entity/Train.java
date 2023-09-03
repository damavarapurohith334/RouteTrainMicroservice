package com.infy.Entity;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "train")
@Validated
@RequestMapping("/train_controller")
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainId;

	private Integer trainNumber;

	private String trainName;

	private String arrivalTime;

	private String departureTime;

	private Double fare;

	private String source;

	private String destination;

	public Train() {
		// Default constructor
	}

	public Train(Integer trainNumber, String trainName, String arrivalTime, String departureTime, Double fare,
			String source, String destination) {
		this.trainNumber = trainNumber;
		this.trainName = trainName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.fare = fare;
		this.source = source;
		this.destination = destination;
	}

	// Getters and setters

	public Integer getTrainId() {
		return trainId;
	}

	public void setTrainId(Integer trainId) {
		this.trainId = trainId;
	}

	public Integer getTrainNumber() {
		return trainNumber;
	}

	public void setTrainNumber(Integer trainNumber) {
		this.trainNumber = trainNumber;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainNumber=" + trainNumber + ", trainName=" + trainName
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", fare=" + fare + ", source="
				+ source + ", destination=" + destination + "]";
	}

	// Equals and hashCode
	@Override
	public int hashCode() {
		return Objects.hash(arrivalTime, departureTime, destination, fare, source, trainId, trainName, trainNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return Objects.equals(arrivalTime, other.arrivalTime) && Objects.equals(departureTime, other.departureTime)
				&& Objects.equals(destination, other.destination) && Objects.equals(fare, other.fare)
				&& Objects.equals(source, other.source) && Objects.equals(trainId, other.trainId)
				&& Objects.equals(trainName, other.trainName) && Objects.equals(trainNumber, other.trainNumber);
	}

}
