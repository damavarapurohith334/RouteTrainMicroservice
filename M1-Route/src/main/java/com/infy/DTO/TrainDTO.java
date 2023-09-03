package com.infy.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TrainDTO {

	private Integer trainId;

	private Integer trainNumber;

	private String trainName;

	private String arrivalTime;

	private String departureTime;

	private Double fare;

	private String source;

	private String destination;

	public TrainDTO() {
	}

	public TrainDTO(Integer trainId, @NotNull(message = "Train number is required") Integer trainNumber,
			@NotBlank(message = "Train name is required") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Train name must contain only alphabets and spaces") String trainName,
			@NotBlank(message = "Arrival time is required") String arrivalTime,
			@NotBlank(message = "Departure time is required") String departureTime,
			@NotNull(message = "Fare is required") Double fare,
			@NotBlank(message = "Source is required") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Source name must contain only alphabets and spaces") String source,
			@NotBlank(message = "Destination is required") @Pattern(regexp = "^[a-zA-Z\\s]*$", message = "Destination name must contain only alphabets and spaces") String destination) {
		this.trainId = trainId;
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
		return "TrainDTO [trainId=" + trainId + ", trainNumber=" + trainNumber + ", trainName=" + trainName
				+ ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + ", fare=" + fare + ", source="
				+ source + ", destination=" + destination + "]";
	}

}
