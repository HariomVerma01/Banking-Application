package com.ExpenseTracker.entity;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorObject {

		int errorCode;
		@Override
		public String toString() {
			return "ErrorObject [errorCode=" + errorCode + ", message=" + message + ", timestamp=" + timestamp + "]";
		}
		String message;
		Date timestamp;
		public Integer getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(Integer errorCode) {
			this.errorCode = errorCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Date getTimestamp() {
			return timestamp;
		}
		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}
}
