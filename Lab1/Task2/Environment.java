package Lab1_Task2;

public class Environment {
	public static final Action MOVE_LEFT = new DyamicAction("LEFT");
	public static final Action MOVE_RIGHT = new DyamicAction("RTGHT");
	public static final Action MOVE_UP = new DyamicAction("UP");
	public static final Action MOVE_DOWN = new DyamicAction("DOWN");
	public static final Action SUCK_DIRT = new DyamicAction("SUCK");
	public static final String LOCATION_A = "A";
	public static final String LOCATION_B = "B";
	public static final String LOCATION_C = "C";
	public static final String LOCATION_D = "D";
	private boolean isDone = false;
	
	public enum LocationState{
		CLEAN, DIRTY
	}

	private LocationState location;
	private EnvironmentState envState;
	private Agent agent = null;
	private int score = 0;
	
	public Environment(LocationState locAState, LocationState locBState, LocationState locCState, LocationState locDState) {
		envState = new EnvironmentState(locAState, locBState, locCState, locDState);
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
			envState.setAgentLocation(LOCATION_D);
		if(action.equals(MOVE_LEFT))
			envState.setAgentLocation(LOCATION_C);
		if(action.equals(MOVE_UP))
			envState.setAgentLocation(LOCATION_D);
		if(action.equals(MOVE_DOWN))
			envState.setAgentLocation(LOCATION_B);
		return envState;
	}
	
	
	public Percept getPerceptSeenBy() {
		return new Percept(envState.getAgentLocation(), envState.getLocationState(envState.getAgentLocation()));
	}
	
	private int performance(Action action) {
		int count =0;
		
		if(action == null)
			count-= 100;
		else if(action.equals(SUCK_DIRT))
			count+=500;
		else 
			count-=10;
		return count;
	}

	public void step() {
		envState.display();
		String agentLocation = this.envState.getAgentLocation();
		Action anAction = agent.execute(getPerceptSeenBy());
		EnvironmentState es = executeAction(anAction);
		int count = performance(anAction);
		score += count;
		System.out.println("Agent Loc.: " + agentLocation + "\tAction: " + anAction);
		System.out.println("Performance measure:   " + score);
		
		if ((es.getLocationState(LOCATION_A) == LocationState.CLEAN)
				&& (es.getLocationState(LOCATION_B) == LocationState.CLEAN) && 
				(es.getLocationState(LOCATION_C) == LocationState.CLEAN)
			&& (es.getLocationState(LOCATION_D) == LocationState.CLEAN))
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
