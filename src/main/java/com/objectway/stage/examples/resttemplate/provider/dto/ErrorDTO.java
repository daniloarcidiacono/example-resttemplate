package com.objectway.stage.examples.resttemplate.provider.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;

/**
 * DTO for an API error.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
	private String message;
	private String causeMessage;

	public ErrorDTO() {
	}

	public ErrorDTO(String message) {
		this.message = message;
	}

	public ErrorDTO(String message, String causeMessage) {
		this.message = message;
		this.causeMessage = causeMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCauseMessage() {
		return causeMessage;
	}

	public void setCauseMessage(String causeMessage) {
		this.causeMessage = causeMessage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ErrorDTO errorDTO = (ErrorDTO) o;
		return Objects.equals(message, errorDTO.message) &&
				Objects.equals(causeMessage, errorDTO.causeMessage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(message, causeMessage);
	}

	@Override
	public String toString() {
		return "ErrorDTO{" +
				"message='" + message + '\'' +
				", causeMessage='" + causeMessage + '\'' +
				'}';
	}
}
