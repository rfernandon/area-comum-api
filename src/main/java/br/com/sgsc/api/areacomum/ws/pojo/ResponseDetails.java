package br.com.sgsc.api.areacomum.ws.pojo;

import java.util.List;

public class ResponseDetails {

	private long timestamp;
	private int statusCode;
	private String statusMessage;
	private String message;
	private String path;
	
	private List<String> validations;

	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	
	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @return the validations
	 */
	public List<String> getValidations() {
		return validations;
	}
	
	public static Builder builder() {
		return new Builder();
	}
	
	public static class Builder {

		private ResponseDetails errorDetails;

		Builder() {
			this.errorDetails = new ResponseDetails();
		}
		
		public Builder addTimestamp(long timestamp) {
			this.errorDetails.timestamp = timestamp;
			return this;
		}
		
		public Builder addStatusCode(int statusCode) {
			this.errorDetails.statusCode = statusCode;
			return this;
		}
		
		public Builder addStatusMessage(String statusMessage) {
			this.errorDetails.statusMessage = statusMessage;
			return this;
		}
		
		public Builder addMessage(String message) {
			this.errorDetails.message = message;
			return this;
		}
		
		public Builder addPath(String path) {
			this.errorDetails.path = path;
			return this;
		}

		public Builder addValidations(List<String> validations) {
			this.errorDetails.validations = validations;
			return this;
		}

		public ResponseDetails build() {
			return this.errorDetails;
		}
	}
}
