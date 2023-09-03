package com.infy.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class RouteDTO {

	private Integer routeId;

	@NotBlank(message = "Source cannot be empty")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Source must contain only alphabets")
	private String source;

	@NotBlank(message = "Destination cannot be empty")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Destination must contain only alphabets")
	private String destination;

	public RouteDTO() {
	}

	public RouteDTO(Integer rootId,
			@NotBlank(message = "Source cannot be empty") @Pattern(regexp = "^[a-zA-Z]+$", message = "Source must contain only alphabets") String source,
			@NotBlank(message = "Destination cannot be empty") @Pattern(regexp = "^[a-zA-Z]+$", message = "Destination must contain only alphabets") String destination) {
		this.routeId = rootId;
		this.source = source;
		this.destination = destination;
	}

	public Integer getRootId() {
		return routeId;
	}

	public void setRootId(Integer rootId) {
		this.routeId = rootId;
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
		return "RouteDTO [rootId=" + routeId + ", source=" + source + ", destination=" + destination + "]";
	}

}
