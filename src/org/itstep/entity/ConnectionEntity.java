package org.itstep.entity;

public class ConnectionEntity {
	
	private Long time;
	private Integer sessionId;
	private String IPAddress;
	
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	public Integer getSessionId() {
		return sessionId;
	}
	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}
	public String getIPAddress() {
		return IPAddress;
	}
	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}

	public ConnectionEntity(Long time, Integer sessionId, String iPAddress) {
		this.time = time;
		this.sessionId = sessionId;
		IPAddress = iPAddress;
	}
	
	public ConnectionEntity() {
	}
	
	@Override
	public String toString() {
		return time + " " + sessionId + " " + IPAddress;
	}
}
