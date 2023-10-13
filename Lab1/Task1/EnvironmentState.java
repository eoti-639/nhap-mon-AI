package Lab1_Task1;

import java.util.HashMap;
import java.util.Map;

import Lab1_Task1.Environment.LocationState;

public class EnvironmentState {
	
	private Map<String, LocationState> state = new HashMap<String, LocationState>();
	private String agentLocation = null;

	public EnvironmentState(LocationState locAState, LocationState locBState) {
		state.put(Environment.LOCATION_A, locAState);
		state.put(Environment.LOCATION_B, locBState);		
	}
	public void setAgentLocation(String locAgent) {
		this.agentLocation = locAgent;
	}
	
	public String getAgentLocation() {
		return agentLocation;
	}
	
	public LocationState getLocationState(String location) {
		return state.get(location);
	}
	
	public void setLocationState(String location, LocationState lcaState) {
		state.put(location, lcaState);
	}
	
	public void display() {
		System.out.println("Enviroment state: \n\t" + this.state);
	}
	
}
