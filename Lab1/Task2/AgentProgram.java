package Lab1_Task2;

public class AgentProgram {

	public Action execute(Percept p) {
		if(p.getLocationState().equals(Environment.LocationState.CLEAN)) {
			switch (p.getAgentLocation()) {
			case Environment.LOCATION_A:
				return Environment.MOVE_RIGHT;
			case Environment.LOCATION_B:
				return Environment.MOVE_LEFT;
			case Environment.LOCATION_C:
				return Environment.MOVE_UP;
			case Environment.LOCATION_D:
				return Environment.MOVE_DOWN;
			}
		}
		else 
			return Environment.SUCK_DIRT;
		return NoOpAction.NO_OP;
	}
}
