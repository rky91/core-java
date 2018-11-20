package com.cube.domain;

public class ErrorDomain {
	
	private String errorId;
	private String errorMessage;
	private String errorLabel;
	
	public String getErrorLabel() {
		return errorLabel;
	}

	public void setErrorLabel(String errorLabel) {
		this.errorLabel = errorLabel;
	}

	public ErrorDomain(String errorId, String errorMessage) {
		super();
		this.errorId = errorId;
		this.errorMessage = errorMessage;
		this.errorLabel = errorMessage;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorDomain [errorId=" + errorId + ", errorMessage=" + errorMessage + "]";
	}
	
	

}
