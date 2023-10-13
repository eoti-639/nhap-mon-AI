package Lab1_Task2;

import Lab1_Task2.Environment.LocationState;

public class Percept {
	private String agentLocation;
	private LocationState state;
	/**
	 * @param agentLocation
	 * @param state
	 */
	public Percept(String agentLocation, LocationState state) {
		this.agentLocation = agentLocation;
		this.state = state;
	}
	/**
	 * @return the agentLocation
	 */
	public String getAgentLocation() {
		return agentLocation;
	}
	/**
	 * @return the state
	 */
	public LocationState getLocationState() {
		return state;
	}
	
	
	
}
