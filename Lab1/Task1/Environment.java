package Lab1_Task1;

public class Environment {
	public static final Action MOVE_LEFT = new DyamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DyamicAction("RTGHT");
	public static final Action SUCK_DIRT = new DyamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	private boolean isDone = false;
	
	public enum LocationState{
		CLEAN, DIRTY
	}

	private LocationState location;
	private EnvironmentState envState;
	private Agent agent = null;
	
	public Environment(LocationState locAState, LocationState locBState) {
		envState = new EnvironmentState(locAState, locBState);
	}

	// add an agent into the environment
	public void addAgent(Agent agent, String location) {
			this.agent = agent;
			envState.setAgentLocation(location);
	}
	public EnvironmentState executeAction(Action action) {
		if(action.equals(SUCK_DIRT))
			envState.setLocationState(envState.getAgentLocation(), LocationState.CLEAN);
		if(action.equals(MOVE_RIGHT))
			envState.setAgentLocation(LOCATION_B);
		if(action.equals(MOVE_LEFT))
			envState.setAgentLocation(LOCATION_A);
		return envState;
	}
	
	
	public Percept getPerceptSeenBy() {
		return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
	}
	
	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);

		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);

		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN))
			isDone = true;// if both squares are clean, then agent do not need to do any action
		es.display();
	}

	public void step(int n) {
		for (int i = 0; i < n; i++) {
			step();
			System.out.println("-------------------------");
		}
	}

	public void stepUntilDone() {
		int i = 0;

		while (!isDone) {
			System.out.println("step: " + i++);
			step();
		}
	}

}
