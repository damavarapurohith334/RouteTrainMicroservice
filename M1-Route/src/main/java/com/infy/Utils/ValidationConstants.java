package com.infy.Utils;

public enum ValidationConstants {
	// Movie Validation Constants
	MOVIE_TITLE_NOT_EMPTY("movie.title.notEmpty"), MOVIE_RUNNING_TIME_FUTURE("movie.runningTime.future"),

	// Director Validation Constants
	DIRECTOR_FIRST_NAME_NOT_EMPTY("director.firstName.notEmpty"),
	DIRECTOR_LAST_NAME_NOT_EMPTY("director.lastName.notEmpty"),
	DIRECTOR_CONTACT_NUMBER_PATTERN("director.contactNumber.pattern"), DIRECTOR_EMAIL_PATTERN("director.email.pattern"),
	//general exception messages
	ROUTE_NOT_FOUND("Route.not.Found"),
	SOMETHING_WENT_WRONG("somthing.went.wrong");

	private final String messageKey;

	ValidationConstants(String messageKey) {
		this.messageKey = messageKey;
	}

	public String getMessageKey() {
		return messageKey;
	}
}
