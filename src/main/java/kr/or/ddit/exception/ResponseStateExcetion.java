package kr.or.ddit.exception;

public class ResponseStateExcetion extends RuntimeException {
	private final int status;
	
	public ResponseStateExcetion(int status, String message) {
		super(message);
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
}
